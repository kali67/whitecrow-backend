package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.Player

@NoRepositoryBean
interface IPlayerRepository : IBaseRepository<Player, Int> {

    fun update(player: Player)

    fun findGame(id: Int)
}