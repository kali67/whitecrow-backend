package whitecrow.service.interfaces

import whitecrow.dto.PlayerDTO
import whitecrow.dto.TurnResult
import whitecrow.model.Player

interface IPlayerService : IDataService<Player, PlayerDTO, Int> {

    fun update(player: Player)

    fun deductMoney(playerId: Int, amount: Float)

    fun increaseMoney(playerId: Int, amount: Float)

    fun useTurn(playerId: Int, gameId: Int): TurnResult

    fun calculateScore(player: Player): Float
}