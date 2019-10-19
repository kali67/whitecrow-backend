package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.GameBoard

@NoRepositoryBean
interface IGameBoardRepository : Repository<GameBoard, Int> {

    /**
     * Loads the board game object
     */
    fun load(): GameBoard
}
