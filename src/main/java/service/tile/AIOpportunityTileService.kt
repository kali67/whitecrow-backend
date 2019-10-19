package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import kotlin.random.*

/**
 * This service object applies actions to AI players
 * who land on an opportunity tile. Not to be used for
 * human players as it includes decision making for cards.
 */
@Service
class AIOpportunityTileService : TileServiceBase() {

    @Autowired
    private lateinit var die: IRandomDieRoller

    @Autowired
    private lateinit var opCardServiceImpl: OpCardServiceImpl

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val excludingIds = player.cards.filter { it.cardType == CardType.OPPORTUNITY }.map { it.id.cardId }.toIntArray()
        val cards = opCardServiceImpl.findHand(excludingIds)
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

    /**
     * Given a list of cards, chose one card and make a random decision to accept or decline it
     * @param cards list of cards to choose from
     */
    private fun makeOpportunityDecision(cards: List<Card>): OpportunityCardResult {
        val card = cards[Random.nextInt(cards.size)]
        val shouldAcceptCard = die.rollDie() >= die.size.div(2) //greater or equal to half the die size
        if (shouldAcceptCard) {
            return OpportunityCardResult(card, DECISION.ACCEPTED)
        }
        return OpportunityCardResult(card, DECISION.DECLINED)
    }
}