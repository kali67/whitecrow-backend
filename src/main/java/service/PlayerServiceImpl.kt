package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import whitecrow.dto.PlayerDTO
import whitecrow.dto.TurnProgress
import whitecrow.dto.TurnResult
import whitecrow.model.Game
import whitecrow.model.Player
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.GameBoardServiceImpl.Companion.NUMBER_DAYS_MONTH
import whitecrow.service.interfaces.*
import javax.transaction.Transactional

@Service
@Transactional
class PlayerServiceImpl @Autowired constructor(
    private val playerRepositoryImpl: IPlayerRepository
) : IPlayerService {

    @Autowired
    lateinit var gameBoardServiceImpl: IGameBoardService

    @Autowired
    private lateinit var turnServiceFactory: TurnServiceFactory

    @Autowired
    lateinit var flowService: IFlowService

    @Autowired
    lateinit var gameRepository: IGameRepository

    @Autowired
    @Lazy
    lateinit var gameSharedServiceImpl: IGameSharedService

    companion object {
        const val DAYS_IN_TWO_WEEKS = 14
        const val REDUCTION_AMOUNT = 0.5f // 50%
    }

    private fun hasGonePassedLastRound(currentDay: Int, numberRounds: Int): Boolean {
        return currentDay >= ((NUMBER_DAYS_MONTH * numberRounds) + numberRounds - 1)
    }

    override fun useTurn(playerId: Int, gameId: Int, daysToProgress: Int): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        val game = gameRepository.findOne(gameId)
        var hasFinishedGame = false

        if (hasGonePassedLastRound(player.currentDay, game.numberRounds)) {
            val turnResult = TurnResult(
                player.id, turnStage = TurnProgress.COMPLETED,
                hasFinishedGame = true, moneyDifference = 0f
            )
            turnResult.currentDay = player.currentDay
            gameSharedServiceImpl.progressToNextPlayer(gameId)
            return turnResult
        }

        player.currentDay += daysToProgress
        if (hasGonePassedLastRound(player.currentDay, game.numberRounds)) {
            player.currentDay = ((NUMBER_DAYS_MONTH * game.numberRounds) + game.numberRounds - 1)
            hasFinishedGame = true
        }
        update(player)
        val tile = gameBoardServiceImpl.findTileByDate(player.currentDay.rem(NUMBER_DAYS_MONTH + 1))
        val service = turnServiceFactory.invoke(player, tile.type)
        val turnResult = service.executeAction(playerId, gameId, tile)
        turnResult.currentDay = player.currentDay
        turnResult.hasFinishedGame = hasFinishedGame
        return turnResult
    }

    override fun deductMoney(playerId: Int, amount: Float) {
        val player = playerRepositoryImpl.findOne(playerId)
        if (player.costReducedSince != -1 && player.costReducedSince + DAYS_IN_TWO_WEEKS > player.currentDay) {
            player.money -= (amount * REDUCTION_AMOUNT)
        } else {
            player.money -= amount
        }
        playerRepositoryImpl.update(player)
    }

    override fun increaseMoney(playerId: Int, amount: Float) {
        val player = playerRepositoryImpl.findOne(playerId)
        player.money += amount
        playerRepositoryImpl.update(player)
    }

    override fun calculateScore(player: Player): Float {
        var totalScore = player.money
        val investments = flowService.findInvestments(player.id)
        val loans = flowService.findLoans(player.id)
        investments.forEach { totalScore += it.amount * 0.5f }
        loans.forEach { totalScore -= flowService.calcFlowPayback(it) }
        return totalScore
    }

    override fun save(persisted: Player) {
        playerRepositoryImpl.save(persisted)
    }

    override fun update(player: Player) {
        playerRepositoryImpl.update(player)
    }

    override fun delete(deleted: Player) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<PlayerDTO> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Int): PlayerDTO {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}