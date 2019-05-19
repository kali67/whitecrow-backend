package whitecrow.service.turn

import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.static_objects.*

@Service
class OtherTurnService : TurnServiceBase() {

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        return TurnResult(
            playerId, message = "Enjoy your rest day!", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}
