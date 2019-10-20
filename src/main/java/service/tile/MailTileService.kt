package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import javax.transaction.*

@Service
@Transactional
class MailTileService : TileServiceBase() {

    @Autowired
    private lateinit var mailCardServiceImpl: MailCardServiceImpl

    @Autowired
    private lateinit var playerRepository: IPlayerRepository

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val playerCards = playerRepository.findOne(player.id).cards
        val playerMailCardIds = playerCards.filter { it.cardType == CardType.MAIL }.map { it.id.cardId }.toIntArray()
        val drawnCard = mailCardServiceImpl.findCardHand(playerMailCardIds)
        mailCardServiceImpl.addMailCard(player.id, drawnCard.id.cardId)

        if (ownsOpportunityCardToCancel(playerCards, drawnCard)) {
            val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
            return turnResultBuilder.apply {
                setCardCancelled(true)
                setTurnStage(TurnProgress.COMPLETED)
                setMailCard(drawnCard)
            }.build()
        }

        applyCostsOfCard(player, drawnCard, game)
        val moneyDifference = if (drawnCard.flowDirection == FlowDirection.ALL_IN || drawnCard.flowDirection == FlowDirection.IN) {
            drawnCard.cost
        } else -drawnCard.cost
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setMailCard(drawnCard)
            setMoneyDifference(moneyDifference)
        }.build()
    }

    /**
     * Applies the cost of the card on the player who drew it. Costs can be
     * IN, OUT or ALL.
     *
     * @param player player who to apply cost to
     * @param drawnCard card drawn by player
     * @param game game that the card was drawn from
     */
    private fun applyCostsOfCard(player: Player, drawnCard: Card, game: Game) {
        when {
            drawnCard.flowDirection == FlowDirection.IN -> {
                playerServiceImpl.increaseMoney(player.id, drawnCard.cost)
            }
            drawnCard.flowDirection == FlowDirection.OUT -> {
                playerServiceImpl.deductMoney(player.id, drawnCard.cost)
            }
            drawnCard.flowDirection == FlowDirection.ALL_IN -> {
                game.player.forEach { playerServiceImpl.increaseMoney(it.id, drawnCard.cost) }
            }
            else -> {
                game.player.forEach { playerServiceImpl.deductMoney(it.id, drawnCard.cost) }
            }
        }
    }

    /**
     * Check to decide if player owns an opportunity to cancel out the risk
     * of the drawn card.
     *
     * @param card card drawn by player
     * @param playerCards all cards owned by a player
     * @return boolean detailing if player owns an opportunity to cancel out the risk of drawn card
     */
    private fun ownsOpportunityCardToCancel(playerCards: List<Card>, card: Card): Boolean {
        var playerOpportunityCards = playerCards.filter { it.cardType == CardType.OPPORTUNITY }
        playerOpportunityCards = mailCardServiceImpl.loadTransients(playerOpportunityCards)
        val categoriesOwnedByPlayer: List<CardCategoryEnum> = playerOpportunityCards.flatMap { it.cardCategory!!.map { card -> card.category } }
        return card.cardCategory!!.first().category in categoriesOwnedByPlayer
    }
}