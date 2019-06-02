package whitecrow.service.tile

import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.static_objects.*

@Service
class OtherTileService : TileServiceBase() {

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
        }.build()
    }
}
