package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.Card
import whitecrow.model.CardType
import whitecrow.model.Card_
import whitecrow.repository.interfaces.IOpCardRespository

@Repository
class OpCardRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : IOpCardRespository {

    override fun findAll(): List<Card> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Card::class.java)
        val root = query.from(Card::class.java)
        query.select(root).where(criteriaBuilder.equal(root.get(Card_.cardType), CardType.OPPORTUNITY))
        return session.createQuery(query).resultList
    }
}