package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.Game
import whitecrow.model.Player

@NoRepositoryBean
interface IGameRepository : IBaseRepository<Game, Int> {

    fun findAllPlayers(id: Int): List<Player>

    fun update(game: Game)
}