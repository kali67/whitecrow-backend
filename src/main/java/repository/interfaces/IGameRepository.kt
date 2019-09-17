package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.*

@NoRepositoryBean
interface IGameRepository : IBaseRepository<Game, Int> {

    fun findAllPlayers(id: Int): List<Player>

    fun update(game: Game)

    fun findAllFinishedGamesByUser(user: User): List<Game>
}