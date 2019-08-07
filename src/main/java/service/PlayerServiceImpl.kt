package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import whitecrow.dto.PlayerDTO
import whitecrow.dto.TurnProgress
import whitecrow.dto.TurnResult
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import whitecrow.service.turn.*
import javax.transaction.Transactional

@Service
@Transactional
class PlayerServiceImpl @Autowired constructor(
    private val playerRepositoryImpl: IPlayerRepository,
    private val turnStrategyFactory: TurnStrategyFactory
) : IPlayerService {

    companion object {
        const val DAYS_IN_TWO_WEEKS = 14
        const val REDUCTION_AMOUNT = 0.5f // 50%
        const val RETURN_ON_INVESTMENT_RATE = 0.5f
    }

    override fun useTurn(playerId: Int, gameId: Int): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        val turnStrategy = turnStrategyFactory.buildTurnStrategy(player.turnType)
        return turnStrategy.useTurn(player, gameId)
    }

    override fun deductMoney(playerId: Int, amount: Float) {
        val player = playerRepositoryImpl.findOne(playerId)
        if (player.costReducedSince != 0 && player.costReducedSince + DAYS_IN_TWO_WEEKS > player.currentDay) {
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
        val investments = player.flow.filter { it.flowType == FlowType.INVESTMENT }
        investments.forEach { totalScore += it.amount * RETURN_ON_INVESTMENT_RATE }
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

    override fun findAll(): List<Player> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Int): Player {
        return playerRepositoryImpl.findOne(id)
    }
}