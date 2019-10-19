package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

/**
 * Implements gambling logic for the gamble tile.
 */
@Service
class GambleTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        playerServiceImpl.deductMoney(player.id, tile!!.cost)
        // todo : roll for each player in game, add players * cost to winner
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setMessage(tile.description)
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(-tile.cost)
        }.build()
    }
}