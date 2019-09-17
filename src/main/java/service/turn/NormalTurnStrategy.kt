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
        println(String.format("player %s day %s", player.id, player.currentDay))
        var playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasFinishedGame) {
            println("skipping player turn")
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

        println(String.format("player %s day %s last call", player.id, player.currentDay))
        playerRepository.update(player)
        return turnResult
    }
}