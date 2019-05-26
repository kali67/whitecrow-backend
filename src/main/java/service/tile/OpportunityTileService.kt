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
        return TurnResult(
            player.id,
            opportunityCardResult = OpportunityCardResult(card, DECISION.UN_DECIDED),
            message = "test",
            turnStage = TurnProgress.DECISION_PENDING,
            moneyDifference = 0f
        )
    }
}