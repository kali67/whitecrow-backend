package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.exceptions.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

@Component
abstract class TurnStrategy {

    @Autowired
    private lateinit var gameSharedServiceImpl: IGameSharedService

    fun useAndCompleteTurn(player: Player, gameId: Int): TurnResult {
        if (isPlayersTurn(gameId, player)) {
            val turnResultParent = applyTurnToPlayer(player, gameId)
            println(player.id)
            println(turnResultParent)
            val lastTurnResult = turnResultParent.findLastTurnResult()
            if (lastTurnResult.turnStage == TurnProgress.COMPLETED) {
                gameSharedServiceImpl.progressToNextPlayer(gameId)
            }
            return turnResultParent
        }
        println("ksdgagsha;ldkgh;sgkhsdgkhsd;gksah;gkash;gkl")
        println(player.id)
        throw InvalidPlayerRequestException()
    }

    fun isPlayersTurn(gameId: Int, player: Player): Boolean {
        val game = gameSharedServiceImpl.findOne(gameId)
        return game.next!!.id == player.id
    }

    abstract fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult

    protected fun skipPlayerTurn(player: Player): TurnResult {
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setHasFinishedGame(true)
        }.build()
    }
}