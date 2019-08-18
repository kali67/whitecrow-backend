package whitecrow.dto

import whitecrow.model.GameState
import whitecrow.model.GameType

class GameDto(

    var type: GameType,
    var numberRounds: Int,
    var maxPlayers: Int,
    var next: PlayerDTO? = null

) {
    var id: Int = 0
    var status: GameState = GameState.AWAITING_PLAYERS
    var players: MutableSet<PlayerDTO> = mutableSetOf()
    var winner: PlayerDTO? = null
    var gameHasFinished: Boolean = false
}