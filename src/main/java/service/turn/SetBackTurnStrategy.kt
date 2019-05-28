package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*

@Component
class SetBackTurnStrategy @Autowired constructor(val gameSharedServiceImpl: IGameSharedService, val gameBoardServiceImpl: IGameBoardService) :
    TurnStrategy() {

    @Autowired
    lateinit var turnServiceFactory: TurnServiceFactory

    override fun useTurn(player: Player, game: Game): TurnResult {
        val playerHasAlreadyFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasAlreadyFinishedGame) {
            return skipPlayerTurn(player)
        }
        player.currentDay -= player.setBackSteps
        player.setBackSteps = 0

        val tile = gameBoardServiceImpl.findTileByDate(player.currentDay.rem(GameBoardServiceImpl.NUMBER_DAYS_MONTH + 1))
        val service = turnServiceFactory.invoke(player, tile.type)
        val turnResult = service.executeAction(player, game, tile)
        turnResult.currentDay = player.currentDay

        player.turnType = TurnType.NORMAL
        return turnResult
    }
}