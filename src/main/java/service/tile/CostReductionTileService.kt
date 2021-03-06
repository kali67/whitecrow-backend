package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import javax.transaction.*

/**
 * This service object implements logic for day 29,
 * cost reduction.
 */
@Service
class CostReductionTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        player.costReducedSince = player.currentDay
        playerRepositoryImpl.update(player)
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(0f)
        }.build()
    }
}