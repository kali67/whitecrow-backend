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
    private lateinit var playerService: IPlayerService

    @Autowired
    private lateinit var normalTurnStrategy: NormalTurnStrategy


    companion object {
        const val SET_BACK_AMOUNT = 1
    }

    override fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult {
        val game = gameSharedServiceImpl.findOne(gameId)
        player.currentDay -= SET_BACK_AMOUNT
        player.turnType = TurnType.NORMAL
        playerService.update(player)

        val turnResult = gameBoardServiceImpl.applyTileActionToPlayer(player, game)

        if (!player.triggeredLastSetBack) {
            val normalTurnAfterSetBack = normalTurnStrategy.applyTurnToPlayer(player, gameId) //no longer be in set back
            turnResult.turnResult = normalTurnAfterSetBack
        }
        return turnResult
    }
}