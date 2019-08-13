package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*

@Component
class NormalTurnStrategy @Autowired constructor(
    private val gameSharedServiceImpl: IGameSharedService,
    private val gameBoardServiceImpl: IGameBoardService,
    private val playerRepository: IPlayerRepository,
    private val die: IRandomDieRoller
) :
    TurnStrategy() {

    override fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult {
        val game = gameSharedServiceImpl.findOne(gameId)
        var playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasFinishedGame) {
            return skipPlayerTurn(player)
        }

        if (player.triggeredLastSetBack) {
            player.triggeredLastSetBack = false
            playerRepository.update(player)
        }

        val playerDieRoll = die.rollDie()
        player.currentDay += playerDieRoll
        playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)

        if (playerHasFinishedGame) {
            player.currentDay = gameSharedServiceImpl.findFinalDay(game)
        }
        playerRepository.update(player)
        val turnResult = gameBoardServiceImpl.applyTileActionToPlayer(player, game)
        turnResult.hasFinishedGame = playerHasFinishedGame
        return turnResult
    }
}