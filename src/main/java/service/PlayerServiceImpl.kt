package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.PlayerDTO
import whitecrow.dto.TurnResult
import whitecrow.model.Player
import whitecrow.repository.GameRepositoryImpl
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
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
    lateinit var gameSharedServiceImpl: IGameSharedService

    companion object {
        const val NUMBER_DAYS = 31
        const val DAYS_IN_TWO_WEEKS = 14
        const val REDUCTION_AMOUNT = 0.5f //50%
    }

    override fun useTurn(playerId: Int, gameId: Int): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        val dieResult = gameSharedServiceImpl.rollDice()
        player.currentDay += dieResult
        val tile = gameBoardServiceImpl.findTileByDate(player.currentDay.rem(NUMBER_DAYS))
        val service = turnServiceFactory.invoke(player, tile.type)
        val turnResult = service.executeAction(playerId, gameId, tile)
        turnResult.currentDay = player.currentDay
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