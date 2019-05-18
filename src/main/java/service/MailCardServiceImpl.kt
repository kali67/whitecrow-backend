package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Card
import whitecrow.repository.interfaces.IMailCardRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.IMailCardService
import whitecrow.service.interfaces.IPlayerService
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
class MailCardServiceImpl @Autowired constructor(
    val mailCardRepositoryImpl: IMailCardRepository,
    val playerServiceImpl: IPlayerService,
    val playerRepositoryImpl: IPlayerRepository
) : IMailCardService {

    override fun findById(id: Int): Card {
        return mailCardRepositoryImpl.findById(id)
    }

    override fun findCardHand(): Card {
        val cards = mailCardRepositoryImpl.findAll()
        val index = Random.nextInt(cards.size)
        val card = cards[index]

        return cards[index]
    }

    override fun addMailCard(playerId: Int, cardId: Int) {
        val player = playerRepositoryImpl.findOne(playerId)
        val card = mailCardRepositoryImpl.findById(cardId)
        player.cards.add(card)
        playerRepositoryImpl.update(player)
        playerServiceImpl.deductMoney(playerId, card.cost)
    }
}