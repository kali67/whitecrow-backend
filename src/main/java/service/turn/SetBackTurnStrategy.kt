package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*

@Component
class SetBackTurnStrategy @Autowired constructor(val gameSharedServiceImpl: IGameSharedService, val gameBoardServiceImpl: IGameBoardService) :
    TurnStrategy() {

    @Autowired
    private lateinit var playerRepository: IPlayerRepository

    @Autowired
    private lateinit var normalTurnStrategy: NormalTurnStrategy


    companion object {
        const val SET_BACK_AMOUNT = 1
    }

    /**
     * Implements from base class. Behaviour differs from that of
     * [NormalTurnStrategy] as players go backwards by 1 day, apply the
     * action of the tile they land on, then are no longer considered in 'SET_BACK'
     * so will be able to progress via a [NormalTurnStrategy].
     *
     * @param player player whos should have their turn used and applied actions to
     * @param gameId game id of current game for the player
     */
    override fun applyTurnToPlayer(player: Player, gameId: Int): TurnResult {
        val game = gameSharedServiceImpl.findOne(gameId)
        val playerHasAlreadyFinishedGame = gameSharedServiceImpl.hasGonePassedFinalDay(player.currentDay, game)
        if (playerHasAlreadyFinishedGame) {
            return skipPlayerTurn(player)
        }

        player.currentDay -= SET_BACK_AMOUNT
        player.turnType = TurnType.NORMAL

        val turnResult = gameBoardServiceImpl.applyTileActionToPlayer(player, game)
        if (!player.triggeredLastSetBack) {
            val normalTurnAfterSetBack = normalTurnStrategy.applyTurnToPlayer(player, gameId) //no longer be in set back
            turnResult.turnResult = normalTurnAfterSetBack
        }
        playerRepository.update(player)
        return turnResult
    }
}