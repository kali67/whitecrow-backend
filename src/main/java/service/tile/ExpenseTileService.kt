package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

/**
 * Service object reserved for expense tiles on the board. This consists
 * of just a deduction of player funds.
 */
@Service
class ExpenseTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        playerServiceImpl.deductMoney(player.id, tile!!.cost)
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(-tile.cost)
        }.build()
    }
}