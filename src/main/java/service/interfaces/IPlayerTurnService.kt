package whitecrow.service.interfaces

import whitecrow.dto.TurnResult
import whitecrow.static_objects.BoardTile

interface IPlayerTurnService {

    fun executeAction(playerId: Int, tile: BoardTile) : TurnResult
}