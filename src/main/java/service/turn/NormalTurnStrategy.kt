package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.*
import whitecrow.service.interfaces.*

@Component
class NormalTurnStrategy @Autowired constructor(
    private val gameSharedServiceImpl: GameSharedServiceImpl,
    private val gameBoardServiceImpl: GameBoardServiceImpl,
    private val playerRepository: IPlayerRepository,
    private val die: IRandomDieRoller
) :
    TurnStrategy() {

    /**
     * Implements from base class [TurnStrategy].
     * Carries out the turn of the player by rolling die, applying
     * tile action etc.
     *
     * @param player player whos turn will be used
     * @param gameId id of the current game
     */
    override fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult {
        val game = gameSharedServiceImpl.findOne(gameId)
        var playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasFinishedGame) {
            return skipPlayerTurn(player)
        }

        val playerDieRoll = die.rollDie()
        player.currentDay += playerDieRoll
        playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)

        if (playerHasFinishedGame) {
            player.currentDay = gameSharedServiceImpl.findFinalDay(game)
        }

        if (player.triggeredLastSetBack) {
            player.triggeredLastSetBack = false
        }

        val turnResult = gameBoardServiceImpl.applyTileActionToPlayer(player, game)
        turnResult.hasFinishedGame = playerHasFinishedGame
        playerRepository.update(player)
        return turnResult
    }
}