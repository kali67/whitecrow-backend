package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class CostReductionTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        player.costReducedSince = player.currentDay
        playerRepositoryImpl.update(player)
        return TurnResult(
            player.id, message = "test", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}