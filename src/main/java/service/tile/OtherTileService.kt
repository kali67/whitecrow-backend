package whitecrow.service.tile

import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*

@Service
/**
 * This tile service is reserved for days on the game board
 * that does not require any updating to player attributes such as
 * rest days.
 */
class OtherTileService : TileServiceBase() {

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
        }.build()
    }
}
