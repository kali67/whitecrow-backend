package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.*
import whitecrow.repository.interfaces.IMailCardRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
class MailCardServiceImpl @Autowired constructor(
    val mailCardRepositoryImpl: IMailCardRepository,
    val playerServiceImpl: IPlayerService,
    val playerRepositoryImpl: IPlayerRepository,
    val userSharedService: IUserSharedService
) : IMailCardService {

    override fun loadTransients(card: List<Card>): List<Card> {
        return mailCardRepositoryImpl.loadTransients(card)
    }

    override fun findById(id: Int): Card {
        val systemLanguage = userSharedService.currentUser().language
        return mailCardRepositoryImpl.findById(CardId(id, systemLanguage.id))
    }

    override fun findCardHand(excluding: IntArray): Card {
        val systemLanguage = userSharedService.currentUser().language
        var cards = mailCardRepositoryImpl.findAll(systemLanguage)
        cards = cards.filter { !excluding.contains(it.id.cardId) }
        val index = Random.nextInt(cards.size)
        return cards[index]
    }

    override fun addMailCard(playerId: Int, cardId: Int) {
        val systemLanguage = userSharedService.currentUser().language
        val player = playerRepositoryImpl.findOne(playerId)
        val card = mailCardRepositoryImpl.findById(CardId(cardId, systemLanguage.id))
        player.cards.add(card)
        playerRepositoryImpl.update(player)
        playerServiceImpl.deductMoney(playerId, card.cost)
    }
}