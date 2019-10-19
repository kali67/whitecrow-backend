package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.exceptions.*
import whitecrow.model.*
import whitecrow.service.*
import whitecrow.service.interfaces.*

@Component
abstract class TurnStrategy {

    @Autowired
    private lateinit var gameSharedServiceImpl: GameSharedServiceImpl

    /**
     * Method to be implemented by those extending a [TurnStrategy]
     * This should detail how a turn is played out, i.e. forward [whitecrow.service.turn.NormalTurnStrategy]
     * or backward [whitecrow.service.turn.SetBackTurnStrategy].
     *
     * @param player player whos should have their turn used and applied actions to
     * @param gameId game id of current game for the player
     */
    abstract fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult

    /**
     * Forms part of the strategy pattern for turns.
     * Uses a players turn, this includes die rolling, applying tile actions
     * and ending the player turn to progress it to the next player
     *
     * @param player player who's turn should be used
     * @param gameId game id of the player who about to use turn
     */
    fun useAndCompleteTurn(player: Player, gameId: Int): TurnResult {
        if (isPlayersTurn(gameId, player)) {
            val turnResultParent = applyTurnToPlayer(player, gameId)
            val lastTurnResult = turnResultParent.findLastTurnResult()
            if (lastTurnResult.turnStage == TurnProgress.COMPLETED) {
                gameSharedServiceImpl.progressToNextPlayer(gameId)
            }
            return turnResultParent
        }
        throw InvalidPlayerRequestException()
    }

    /**
     * Checks if the next players turn in the game is the passed
     * in player.
     *
     * @param gameId game id of the game to check next players turn
     * @param player player object of the game next player to be compared with
     */
    private fun isPlayersTurn(gameId: Int, player: Player): Boolean {
        val game = gameSharedServiceImpl.findOne(gameId)
        return game.next!!.id == player.id
    }


    /**
     * Generic turn that contains not updates or actions, used when a player
     * has already finished the game but are next in the order.
     *
     * @param player who's turn to skip
     */
    protected fun skipPlayerTurn(player: Player): TurnResult {
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setHasFinishedGame(true)
        }.build()
    }
}