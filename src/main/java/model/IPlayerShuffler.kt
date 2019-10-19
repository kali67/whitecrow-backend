package whitecrow.model

interface IPlayerShuffler {

    /**
     * Shuffles a collection of players.
     * Used for assigning player order etc
     *
     * @param players collection of players to shuffle
     * @return list of players in new shuffled order
     */
    fun shufflePlayers(players: Collection<Player>): List<Player>
}