package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.*
import whitecrow.repository.interfaces.IMailCardRepository

@Repository
class MailCardRepositoryImpl @Autowired constructor(private val sessionFactory: SessionFactory) : IMailCardRepository {

    override fun findAll(language: Language): List<Card> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(Card::class.java)
        val root = criteriaQuery.from(Card::class.java)
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(Card_.cardType), CardType.MAIL))
        val cards = session.createQuery(criteriaQuery).resultList
        return loadTransients(cards.filter { it.id.langId == language.id })
    }

    override fun loadTransients(cards: List<Card>): List<Card> {
        if (cards.isNotEmpty()) {
            val session = sessionFactory.currentSession
            val criteriaBuilder = session.criteriaBuilder
            val cardIds = cards.map { it.id.cardId }
            val criteriaQueryCategory = criteriaBuilder.createQuery(CardCategory::class.java)
            val rootCategory = criteriaQueryCategory.from(CardCategory::class.java)
            criteriaQueryCategory.select(rootCategory).where(rootCategory.get(CardCategory_.cardId).`in`(cardIds))
            val categories = session.createQuery(criteriaQueryCategory).resultList
            cards.forEach { card -> card.cardCategory = categories.filter { it.cardId == card.id.cardId } }
            return cards
        }
        return listOf()
    }

    override fun findById(id: CardId): Card {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(Card::class.java)
        val root = criteriaQuery.from(Card::class.java)
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(Card_.id), id))
        return session.createQuery(criteriaQuery).singleResult
    }
}