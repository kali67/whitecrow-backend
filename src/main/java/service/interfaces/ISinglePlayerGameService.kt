package whitecrow.service.interfaces

import whitecrow.dto.GameDto
import whitecrow.dto.TurnResult
import whitecrow.model.*

interface ISinglePlayerGameService {

    fun setUpGame(game: GameDto): GameDto

    fun create(game: GameDto): Game

    fun start(id: Int): List<TurnResult>

    fun makePlayerTurns(id: Int): List<TurnResult>
}