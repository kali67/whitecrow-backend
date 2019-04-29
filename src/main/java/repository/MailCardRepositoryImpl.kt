package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.Card
import whitecrow.model.CardType
import whitecrow.model.Card_
import whitecrow.repository.interfaces.IMailCardRepository

@Repository
class MailCardRepositoryImpl @Autowired constructor(private val sessionFactory: SessionFactory) : IMailCardRepository {

    override fun findAll(): List<Card> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(Card::class.java)
        val root = criteriaQuery.from(Card::class.java)
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(Card_.cardType), CardType.MAIL))
        return session.createQuery(criteriaQuery).resultList
    }

    override fun findById(id: Int): Card {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(Card::class.java)
        val root = criteriaQuery.from(Card::class.java)
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(Card_.id), id))
        return session.createQuery(criteriaQuery).singleResult
    }
}