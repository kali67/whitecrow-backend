package whitecrow.service.interfaces

import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.static_objects.BoardTile
import whitecrow.static_objects.GameBoard

interface IGameBoardService {

    fun load(): GameBoard

    fun findTileByDate(date: Int): BoardTile

    fun applyTileActionToPlayer(player: Player, game: Game) : TurnResult
}
