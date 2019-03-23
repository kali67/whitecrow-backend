package whitecrow.service

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Game
import whitecrow.model.GameState
import whitecrow.service.interfaces.IGameService
import javax.persistence.criteria.CriteriaQuery

@Service
data class GameServiceImpl @Autowired constructor(private val sessionFactory: SessionFactory ) : IGameService { //TODO DAO
    override fun delete(deleted: Game) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Game> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Int): Game {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(persisted: Game): Game {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllByState(gameState: GameState): List<Game> {
        val session = sessionFactory.openSession()
        val builder = session.criteriaBuilder
        val criteria: CriteriaQuery<Game> = builder.createQuery(Game::class.java)
//        criteria.
        return listOf()
    }

}