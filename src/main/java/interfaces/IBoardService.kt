package whitecrow.interfaces

import whitecrow.static_objects.GameBoard


interface IBoardService {

    fun load() : GameBoard
}
