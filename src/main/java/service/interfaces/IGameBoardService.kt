package whitecrow.service.interfaces

import whitecrow.static_objects.BoardTile
import whitecrow.static_objects.GameBoard

interface IGameBoardService {

    fun load(): GameBoard

    fun findTileByDate(date: Int): BoardTile
}
