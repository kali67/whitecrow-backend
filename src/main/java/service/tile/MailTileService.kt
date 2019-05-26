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
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        val card = mailCardServiceImpl.findCardHand()
        val playerOpportunityCards = playerRepository.findOne(player.id).cards.filter { it.cardType == CardType.OPPORTUNITY }
        val categoriesOwnedByPlayer = playerOpportunityCards.map { it.category }
        if (card.category in categoriesOwnedByPlayer) {
            val playerMessage = "You're recent investment has disregarded this mail card!"
            return TurnResult(
                player.id,
                card,
                message = playerMessage,
                moneyDifference = 0f,
                turnStage = TurnProgress.COMPLETED
            )
        }
        mailCardServiceImpl.addMailCard(player.id, card.id)
        return TurnResult(
            player.id,
            card,
            message = "test",
            turnStage = TurnProgress.COMPLETED,
            moneyDifference = -card.cost
        )
    }
}