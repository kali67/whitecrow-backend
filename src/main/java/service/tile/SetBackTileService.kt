package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.turn.*
import javax.transaction.*

/**
 * This service object implements logic for the setback/last minute change day.
 */
@Service
class SetBackTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Autowired
    private lateinit var setBackTurnStrategy: SetBackTurnStrategy

    @Transactional
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val players = gameRepository.findAllPlayers(game.id)
        if (players.any { it.triggeredLastSetBack }) { //if we already in set back mode dont apply any actions
            val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
            return turnResultBuilder.apply {
                setTurnStage(TurnProgress.COMPLETED)
            }.build()
        }

        val playersNotFinishedGame = players.filter { !gameSharedServiceImpl.hasGonePassedFinalDay(it.currentDay, game) }
        playersNotFinishedGame.forEach {
            it.turnType = TurnType.SETBACK
            playerRepositoryImpl.update(it)
        }

        player.triggeredLastSetBack = true
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        val setBackTurnResult = setBackTurnStrategy.applyTurnToPlayer(player, game.id)

        playerRepositoryImpl.update(player)
        return turnResultBuilder.apply {
            setHasTriggeredSetBack(true)
            setTurnResult(setBackTurnResult)
        }.build()
    }
}