package whitecrow.service.interfaces

import whitecrow.dto.GameDto
import whitecrow.dto.PlayerDTO
import whitecrow.model.Game

interface IGameSharedService : IDataService<Game, Int> {

    fun findAllPlayers(id: Int): List<PlayerDTO>

    fun findCurrentPlayer(gameId: Int): PlayerDTO

    fun assignPlayerOrder(game: Game)

    fun progressToNextPlayer(gameId: Int)

    fun calculateEndGameScore(id: Int): GameDto

    fun gameHasFinished(game: Game): Boolean

    fun findFinalDay(game: Game): Int

    fun hasGonePassedFinalDay(day: Int, game: Game): Boolean

    fun update(game: Game)
}