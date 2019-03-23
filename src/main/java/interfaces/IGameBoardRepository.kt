package whitecrow.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.static_objects.GameBoard

@NoRepositoryBean
interface IGameBoardRepository : Repository<GameBoard, Int> {

    fun find() : GameBoard
}
