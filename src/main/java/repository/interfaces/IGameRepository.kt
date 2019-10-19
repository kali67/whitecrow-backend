package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.*

@NoRepositoryBean
interface IGameRepository : IBaseRepository<Game, Int> {

    /**
     * Updates a game in persistence implementation
     *
     * @param game game to update, this object must already
     * have the updated attributes
     */
    fun update(game: Game)

    /**
     * Finds all games that a particular user has completed
     *
     * @param user user for which the reduce finished game query by
     * @return a list of games that are finished by the user
     */
    fun findAllFinishedGamesByUser(user: User): List<Game>

    /**
     * Finds all players within a particular game
     * @param id id of the game
     * @return a list of players that are within the game of interest
     */
    fun findAllPlayers(id: Int): List<Player>
}