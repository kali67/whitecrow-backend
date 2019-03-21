package whitecrow.interfaces

import whitecrow.model.Game
import whitecrow.model.GameState

interface IGameService {

    fun filterGamesByState(gameState: GameState): List<Game>

}