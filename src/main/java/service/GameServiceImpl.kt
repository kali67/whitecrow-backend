package whitecrow.service

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.interfaces.IGameService
import whitecrow.model.Game
import whitecrow.model.GameState
import javax.persistence.criteria.CriteriaQuery

@Service
data class GameServiceImpl @Autowired constructor(private val sessionFactory: SessionFactory) : IGameService {

    override fun filterGamesByState(gameState: GameState): List<Game> {
        val session = sessionFactory.openSession()
        val builder = session.criteriaBuilder
        val criteria: CriteriaQuery<Game> = builder.createQuery(Game::class.java)
//        criteria.
        return listOf()
    }

}