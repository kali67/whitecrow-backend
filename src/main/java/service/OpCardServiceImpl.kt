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
    val gameSharedServiceImpl: IGameSharedService
) : IOpCardService {

    @Autowired
    private lateinit var flowService: IFlowService

    override fun findHand(): List<Card> {
        return pickCards(opCardRepositoryImpl.findAll())
    }

    fun pickCards(selection: List<Card>): List<Card> {
        var possibleDraws: List<Card> = selection
        val drawnCards: MutableList<Card> = mutableListOf()
        for (i in 0 until 3) {
            val index = Random.nextInt(possibleDraws.size)
            drawnCards.add(possibleDraws[index])
            possibleDraws = selection.filter { card ->
                !drawnCards.contains(card)
            }
        }
        return drawnCards
    }

    override fun addOpportunityCard(playerId: Int, cardId: Int) {
        val player = playerRepositoryImpl.findOne(playerId)
        val card = mailCardServiceImpl.findById(cardId)
        player.cards.add(card)
        flowService.createOpportunityInvestment(player, card)
        playerRepositoryImpl.update(player)
        playerServiceImpl.deductMoney(playerId, card.cost)
        gameSharedServiceImpl.progressToNextPlayer(player.game!!.id)
    }
}