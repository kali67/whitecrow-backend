package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.*
import whitecrow.repository.interfaces.IOpCardRespository

@Repository
class OpCardRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : IOpCardRespository {

    override fun findAll(language: Language): List<Card> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Card::class.java)
        val root = query.from(Card::class.java)
        query.select(root).where(criteriaBuilder.equal(root.get(Card_.cardType), CardType.OPPORTUNITY))
        var cards = session.createQuery(query).resultList
        cards = cards.filter { it.id.langId == language.id }
        val cardIds = cards.map { it.id.cardId }

        val criteriaQueryCategory = criteriaBuilder.createQuery(CardCategory::class.java)
        val rootCategory = criteriaQueryCategory.from(CardCategory::class.java)
        criteriaQueryCategory.select(rootCategory).where(rootCategory.get(CardCategory_.cardId).`in`(cardIds))
        val categories = session.createQuery(criteriaQueryCategory).resultList
        cards.forEach { card -> card.cardCategory = categories.filter { it.cardId == card.id.cardId } }
        return cards
    }
}