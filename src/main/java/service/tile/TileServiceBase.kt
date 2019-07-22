package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
abstract class TileServiceBase {

    @Autowired
    protected lateinit var gameSharedServiceImpl: IGameSharedService

    @Autowired
    protected lateinit var gameRepository: IGameRepository

    fun executeAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val turnResult = applyTileAction(player, game, tile)
        if (turnResult.turnStage == TurnProgress.COMPLETED || turnResult.turnStage == TurnProgress.COMPLETED_WITH_ROLLS) {
            gameSharedServiceImpl.progressToNextPlayer(game.id)
        }
        return turnResult
    }

    abstract fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult
}