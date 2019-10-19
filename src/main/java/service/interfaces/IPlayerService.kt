package whitecrow.service.interfaces

import whitecrow.dto.TurnResult
import whitecrow.model.Player

interface IPlayerService : IDataService<Player, Int> {

    fun deductMoney(playerId: Int, amount: Float)

    fun increaseMoney(playerId: Int, amount: Float)

    fun useTurn(playerId: Int, gameId: Int): TurnResult

    fun calculateScore(player: Player): Float
}