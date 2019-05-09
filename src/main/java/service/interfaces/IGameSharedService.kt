package whitecrow.service.interfaces

import whitecrow.dto.GameDto
import whitecrow.dto.PlayerDTO
import whitecrow.model.Game

interface IGameSharedService : IDataService<Game, GameDto, Int> {

    fun findAllPlayers(id: Int): List<PlayerDTO>

    fun findCurrentPlayer(gameId: Int): PlayerDTO

    fun assignPlayerOrder(gameId: Int)

    fun rollDice() : Int

    fun progressToNextPlayer(gameId: Int)

    fun endGame(id: Int) : GameDto

    fun gameHasFinished(game: Game) : Boolean
}