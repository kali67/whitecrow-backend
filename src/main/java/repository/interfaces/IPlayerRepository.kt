package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.Player

@NoRepositoryBean
interface IPlayerRepository : IBaseRepository<Player, Int> {

    /**
     * Updates a player object in persistence
     * @param player to update
     */
    fun update(player: Player)
}