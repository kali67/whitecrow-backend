package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.mappers.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*
import kotlin.random.*

@Service
class AIOpportunityTileService : TileServiceBase() {

    @Autowired
    private lateinit var die: IRandomDieRoller

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val cards = opCardServiceImpl.findHand()
        val cardDecision = makeOpportunityDecision(cards)
        if (cardDecision.decision == DECISION.ACCEPTED) {
            opCardServiceImpl.addOpportunityCard(player.id, cardDecision.card.id.cardId)
        }
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setOpportunityCardResult(cardDecision)
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(-cardDecision.card.cost)
        }.build()
    }

    private fun makeOpportunityDecision(cards: List<Card>): OpportunityCardResult {
        val card = cards[Random.nextInt(cards.size)]
        val shouldAcceptCard = die.rollDie() >= die.size.div(2) //greater or equal to half the die size
        if (shouldAcceptCard) {
            return OpportunityCardResult(card, DECISION.ACCEPTED)
        }
        return OpportunityCardResult(card, DECISION.DECLINED)
    }
}