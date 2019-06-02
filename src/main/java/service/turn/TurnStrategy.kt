package whitecrow.service.turn

import whitecrow.dto.*
import whitecrow.model.*

abstract class TurnStrategy {

    abstract fun useTurn(player: Player, gameId: Int): TurnResult

    protected fun skipPlayerTurn(player: Player): TurnResult {
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setHasFinishedGame(true)
        }.build()
    }
}