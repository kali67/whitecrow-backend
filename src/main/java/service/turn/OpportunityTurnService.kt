package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
class OpportunityTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val card = opCardServiceImpl.findHand().first()
        return TurnResult(
            playerId,
            opportunityCardResult = OpportunityCardResult(card, DECISION.UN_DECIDED),
            message = "test",
            turnStage = TurnProgress.DECISION_PENDING,
            moneyDifference = 0f
        )
    }
}