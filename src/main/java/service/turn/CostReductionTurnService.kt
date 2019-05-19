package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class CostReductionTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        player.costReducedSince = player.currentDay
        playerRepositoryImpl.update(player)
        return TurnResult(
            playerId, message = "test", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}