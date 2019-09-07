package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class MailTileService : TileServiceBase() {

    @Autowired
    private lateinit var mailCardServiceImpl: IMailCardService

    @Autowired
    private lateinit var playerRepository: IPlayerRepository

    @Transactional
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        val playerCards = playerRepository.findOne(player.id).cards
        var playerOpportunityCards = playerCards.filter { it.cardType == CardType.OPPORTUNITY }
        val playerMailCardIds = playerCards.filter { it.cardType == CardType.MAIL }.map { it.id.cardId }.toIntArray()
        val card = mailCardServiceImpl.findCardHand(playerMailCardIds)
        playerOpportunityCards = mailCardServiceImpl.loadTransients(playerOpportunityCards)
        val categoriesOwnedByPlayer: List<CardCategoryEnum> = playerOpportunityCards.flatMap { it.cardCategory!!.map { card -> card.category } }
        if (card.cardCategory!!.first().category in categoriesOwnedByPlayer) {
            val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
            return turnResultBuilder.apply {
                setCardCancelled(true)
                setTurnStage(TurnProgress.COMPLETED)
                setMailCard(card)
            }.build()
        }
        mailCardServiceImpl.addMailCard(player.id, card.id.cardId)
        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setMailCard(card)
            setMoneyDifference(-card.cost)
        }.build()
    }
}