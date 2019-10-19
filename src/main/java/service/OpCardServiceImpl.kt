package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Card
import whitecrow.repository.interfaces.IOpCardRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
class OpCardServiceImpl @Autowired constructor(
    val opCardRepositoryImpl: IOpCardRepository,
    val playerServiceImpl: IPlayerService,
    val playerRepositoryImpl: IPlayerRepository,
    val mailCardServiceImpl: MailCardServiceImpl,
    val userSharedService: IUserSharedService
) {

    @Autowired
    private lateinit var flowService: FlowService

    fun findHand(excluding: IntArray): List<Card> {
        var cards = opCardRepositoryImpl.findAll(userSharedService.currentUser().language)
        cards = cards.filter { !excluding.contains(it.id.cardId) }
        val list = mutableListOf<Card>()
        list.add(cards[Random.nextInt(cards.size)])
        return list.toList()
    }

    fun addOpportunityCard(playerId: Int, cardId: Int) {
        val player = playerRepositoryImpl.findOne(playerId)
        val card = mailCardServiceImpl.findById(cardId)
        player.cards.add(card)
        flowService.createOpportunityInvestment(player, card)
        playerRepositoryImpl.update(player)
        playerServiceImpl.deductMoney(playerId, card.cost)
    }
}