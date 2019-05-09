package whitecrow.dto

import whitecrow.model.GameState
import whitecrow.model.GameType

class GameDto(
    var id: Int,
    var type: GameType,
    var numberRounds: Int,
    var maxPlayers: Int,
    var next: PlayerDTO?= null

) {
    var status: GameState = GameState.AWAITING_PLAYERS
    var players: MutableSet<PlayerDTO> = mutableSetOf()
    var winner: PlayerDTO? = null
}