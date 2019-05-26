package whitecrow.service.tile

import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.static_objects.*

@Service
class OtherTileService : TileServiceBase() {

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        return TurnResult(
            player.id, message = "Enjoy your rest day!", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}
