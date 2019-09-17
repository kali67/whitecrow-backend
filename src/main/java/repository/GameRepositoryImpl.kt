package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameRepository
import javax.persistence.criteria.*

@Repository
class GameRepositoryImpl @Autowired constructor(private val sessionFactory: SessionFactory) : IGameRepository {

    override fun findAllPlayers(id: Int): List<Player> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Game::class.java)
        val root = query.from(Game::class.java)
        query.select(root).where(criteriaBuilder.equal(root.get(Game_.id), id))
        val game = session.createQuery(query).singleResult
        return game.player.toList()
    }

    override fun findAll(): List<Game> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Game::class.java)
        val root = query.from(Game::class.java)
        query.select(root)
        return session.createQuery(query).resultList
    }

    override fun findOne(id: Int): Game {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val criteriaQuery = criteriaBuilder.createQuery(Game::class.java)
        val root = criteriaQuery.from(Game::class.java)
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(Game_.id), id))
        return session.createQuery(criteriaQuery).singleResult
    }

    override fun findAllFinishedGamesByUser(user: User): List<Game> {
        val session = sessionFactory.currentSession
        val builder = session.criteriaBuilder

        val query = builder.createQuery(Game::class.java)
        val fromGame = query.from(Game::class.java)
        val players: Join<Game, Player> = fromGame.join(Game_.player)
        query.select(fromGame)
            .where(builder.equal(players.get(Player_.user), user))
        return session.createQuery(query).resultList.filter { it.winner != null }
    }

    override fun update(game: Game) {
        val session = sessionFactory.currentSession
        session.merge(game)
    }

    override fun save(persisted: Game): Game {
        val session = sessionFactory.currentSession
        session.persist(persisted)
        return persisted
    }

    override fun delete(deleted: Game) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}