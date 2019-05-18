package whitecrow.service.interfaces

import whitecrow.dto.GameDto
import whitecrow.dto.TurnResult

interface ISinglePlayerGameService {

    fun create(game: GameDto): GameDto

    fun start(id: Int): List<TurnResult>

    fun makePlayerTurns(id: Int): List<TurnResult>
}