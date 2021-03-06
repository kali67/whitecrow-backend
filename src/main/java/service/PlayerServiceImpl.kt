package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.TurnResult
import whitecrow.model.*
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
        return turnStrategy.useAndCompleteTurn(player, gameId)
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

    override fun update(obj: Player) {
        playerRepositoryImpl.update(obj)
    }

    override fun findOne(id: Int): Player {
        return playerRepositoryImpl.findOne(id)
    }
}