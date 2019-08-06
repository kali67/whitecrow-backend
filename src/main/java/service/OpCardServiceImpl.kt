package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Card
import whitecrow.repository.interfaces.IOpCardRespository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
class OpCardServiceImpl @Autowired constructor(
    val opCardRepositoryImpl: IOpCardRespository,
    val playerServiceImpl: IPlayerService,
    val playerRepositoryImpl: IPlayerRepository,
    val mailCardServiceImpl: IMailCardService,
    val userSharedService: IUserSharedService
) : IOpCardService {

    @Autowired
    private lateinit var flowService: IFlowService

    override fun findHand(): List<Card> {
        val cards = opCardRepositoryImpl.findAll(userSharedService.currentUser().language)
        val list = mutableListOf<Card>()
        list.add(cards[Random.nextInt(cards.size)])
        return list.toList()
    }

    override fun addOpportunityCard(playerId: Int, cardId: Int) {
        val player = playerRepositoryImpl.findOne(playerId)
        val card = mailCardServiceImpl.findById(cardId)
        player.cards.add(card)
        flowService.createOpportunityInvestment(player, card)
        playerRepositoryImpl.update(player)
        playerServiceImpl.deductMoney(playerId, card.cost)
    }
}