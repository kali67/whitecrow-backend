package whitecrow.model

interface IPlayerShuffler {

    fun shufflePlayers(players: Collection<Player>): List<Player>
}