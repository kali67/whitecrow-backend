package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*
import kotlin.random.*

@Service
class AIOpportunityTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val cards = opCardServiceImpl.findHand()
        val cardDecision = makeOpportunityDecision(cards)
        if (cardDecision.decision == DECISION.ACCEPTED) {
//            opCardServiceImpl.addOpportunityCard(playerId, cardDecision.card.id)
        }
        return TurnResult(
            playerId,
            opportunityCardResult = cardDecision,
            message = "test",
            turnStage = TurnProgress.COMPLETED,
            moneyDifference = -cardDecision.card.cost
        )
    }

    private fun makeOpportunityDecision(cards: List<Card>): OpportunityCardResult {
        val card = cards[Random.nextInt(cards.size)]
        if (Math.round(Math.random()) == 1L) {
            return OpportunityCardResult(card, DECISION.ACCEPTED)
        }
        return OpportunityCardResult(card, DECISION.DECLINED)
    }
}