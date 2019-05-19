package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
abstract class TurnServiceBase {

    @Autowired
    protected lateinit var gameSharedServiceImpl: IGameSharedService

    @Autowired
    protected lateinit var gameRepository: IGameRepository

    fun executeAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {

        val game = gameRepository.findOne(gameId)
        val turnResult = applyTileAction(playerId, game, tile)
        if (turnResult.turnStage == TurnProgress.COMPLETED || turnResult.turnStage == TurnProgress.COMPLETED_WITH_ROLLS) {
            gameSharedServiceImpl.progressToNextPlayer(gameId)
        }
        return turnResult
    }

    abstract fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult
}