package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
class OpportunityTileService : TileServiceBase() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        val card = opCardServiceImpl.findHand().first()
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setOpportunityCardResult(OpportunityCardResult(card, DECISION.UN_DECIDED))
            setTurnStage(TurnProgress.DECISION_PENDING)
        }.build()
    }
}