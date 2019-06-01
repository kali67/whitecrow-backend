package whitecrow.service.turn

import whitecrow.dto.*
import whitecrow.model.*

abstract class TurnStrategy {

    abstract fun useTurn(player: Player, gameId: Int): TurnResult

    protected fun skipPlayerTurn(player: Player): TurnResult {
        val turnResult = TurnResult(
            player.id, turnStage = TurnProgress.COMPLETED,
            hasFinishedGame = true, moneyDifference = 0f
        )
        turnResult.currentDay = player.currentDay
        return turnResult
    }
}