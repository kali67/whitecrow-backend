package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*

@Component
class NormalTurnStrategy @Autowired constructor(val gameSharedServiceImpl: IGameSharedService, val gameBoardServiceImpl: IGameBoardService) :
    TurnStrategy() {


    @Autowired
    lateinit var turnServiceFactory: TurnServiceFactory

    @Autowired
    lateinit var playerService: IPlayerService

    override fun useTurn(player: Player, game: Game): TurnResult {
        var playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasFinishedGame) {
            return skipPlayerTurn(player)
        }

        val playerDieRoll = gameSharedServiceImpl.rollDice()
        player.currentDay += playerDieRoll
        playerHasFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)

        if (playerHasFinishedGame) {
            player.currentDay = gameSharedServiceImpl.findFinalDay(game)
        }
        playerService.update(player)
        val tile = gameBoardServiceImpl.findTileByDate(player.currentDay.rem(GameBoardServiceImpl.NUMBER_DAYS_MONTH + 1))
        val service = turnServiceFactory.invoke(player, tile.type)
        val turnResult = service.executeAction(player, game, tile)
        turnResult.currentDay = player.currentDay
        turnResult.hasFinishedGame = playerHasFinishedGame
        return turnResult
    }

}