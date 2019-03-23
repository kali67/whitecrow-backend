package whitecrow.service.interfaces

import whitecrow.static_objects.GameBoard


interface IGameBoardService  {

    fun load() : GameBoard
}
