package whitecrow.service.interfaces

import whitecrow.dto.*
import whitecrow.model.*

interface IGameBoardService {

    fun load(): GameBoard

    fun findTileByDate(date: Int): BoardTile

    fun applyTileActionToPlayer(player: Player, game: Game) : TurnResult
}
