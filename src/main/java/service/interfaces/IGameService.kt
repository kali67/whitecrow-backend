package whitecrow.service.interfaces

import whitecrow.model.Game
import whitecrow.model.GameState

interface IGameService : IDataService<Game, Int> {

    fun findAllByState(gameState: GameState): List<Game>

}