package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
class BonusTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        playerServiceImpl.increaseMoney(player.id, tile!!.cost)
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setMessage(tile.description)
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(tile.cost)
        }.build()
    }
}