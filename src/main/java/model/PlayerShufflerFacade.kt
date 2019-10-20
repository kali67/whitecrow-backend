package whitecrow.model

import org.springframework.stereotype.*

@Component
class SinglePlayerShufflerFacade : IPlayerShuffler {

    /**
     * Single Player implementation of this ensure that
     * the user is the first player to use their turn. The remaining players
     * are shuffled.
     *
     * @param players players to shuffle
     * @return shuffled list of players
     */
    override fun shufflePlayers(players: Collection<Player>): List<Player> {
        val shuffledPlayers = players.shuffled().toMutableList()
        val indexOfUser = shuffledPlayers.indexOfFirst { it.user != null }
        val temp =  shuffledPlayers[0]
        shuffledPlayers[0] = shuffledPlayers[indexOfUser]
        shuffledPlayers[indexOfUser] = temp
        return shuffledPlayers
    }
}