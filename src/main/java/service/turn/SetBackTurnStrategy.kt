package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

@Component
class SetBackTurnStrategy @Autowired constructor(val gameSharedServiceImpl: IGameSharedService, val gameBoardServiceImpl: IGameBoardService) :
    TurnStrategy() {

    @Autowired
    lateinit var playerService: IPlayerService

    override fun useTurn(player: Player, gameId: Int): TurnResult {
        val game = gameSharedServiceImpl.findOne(gameId)
        val playerHasAlreadyFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasAlreadyFinishedGame) {
            return skipPlayerTurn(player)
        }
        player.currentDay -= player.setBackSteps
        player.setBackSteps = 0
        playerService.update(player)

        val turnResult = gameBoardServiceImpl.applyTileActionToPlayer(player, game)
        if (player.setBackSteps == 0) {
            player.turnType = TurnType.NORMAL
        }
        return turnResult
    }
}