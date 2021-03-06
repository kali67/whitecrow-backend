package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.Game
import whitecrow.model.Player
import whitecrow.model.Player_
import whitecrow.repository.interfaces.IPlayerRepository

@Repository
class PlayerRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : IPlayerRepository {

    override fun update(player: Player) {
        val session = sessionFactory.currentSession
        session.saveOrUpdate(player)
    }

    override fun findOne(id: Int): Player {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Player::class.java)
        val from = query.from(Player::class.java)
        query.select(from).where(criteriaBuilder.equal(from.get(Player_.id), id))
        return session.createQuery(query).singleResult
    }

    override fun save(persisted: Player): Player {
        val session = sessionFactory.currentSession
        session.save(persisted)
        return persisted
    }
}