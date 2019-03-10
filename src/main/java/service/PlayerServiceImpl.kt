package whitecrow.service

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Player


@Service
data class PlayerServiceImpl @Autowired constructor(private val sessionFactory: SessionFactory) :
    IPlayerService {

    override fun createPlayer(username: String) {
        val session = sessionFactory.openSession()
        session.beginTransaction()
        val player = Player(5, username)
        session.save(player)
        session.transaction.commit()
    }
}