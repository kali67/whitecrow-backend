package whitecrow.model

import org.springframework.stereotype.*

@Component
class PlayerShufflerFacade : IPlayerShuffler {

    override fun shufflePlayers(players: Collection<Player>): List<Player> {
        return players.shuffled()
    }
}