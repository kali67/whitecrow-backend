package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class MailTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var mailCardServiceImpl: IMailCardService

    @Autowired
    private lateinit var playerRepository: IPlayerRepository

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val card = mailCardServiceImpl.findCardHand()
//        val playerOpportunityCards = playerRepository.findOne(playerId).opportunityCards
//        val categoriesOwnedByPlayer = playerOpportunityCards.map { it.category }
//        if (card.category in categoriesOwnedByPlayer) {
//            val playerMessage = "You're recent investment has disregarded this mail card!"
//            return TurnResult(
//                playerId,
//                card,
//                message = playerMessage,
//                moneyDifference = 0f,
//                turnStage = TurnProgress.COMPLETED
//            )
//        }
        mailCardServiceImpl.addMailCard(playerId, card.id)
        return TurnResult(
            playerId,
            card,
            message = "test",
            turnStage = TurnProgress.COMPLETED,
            moneyDifference = -card.cost
        )
    }
}