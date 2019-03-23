package whitecrow.service

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.BankingStrategy
import whitecrow.model.ProjectManager
import whitecrow.service.interfaces.IProjectManagerService


@Service
data class ProjectManagerServiceImpl @Autowired constructor(private val sessionFactory: SessionFactory) :
    IProjectManagerService {


    override fun updateUsername(id: Int, username: String) {
        val session = sessionFactory.openSession()
        session.beginTransaction()
        val player: ProjectManager = session.load(ProjectManager::class.java, id)
        player.userName = username
        session.save(player)
        session.transaction.commit()
    }

    override fun createPlayer(username: String) {
        val session = sessionFactory.openSession()
        session.beginTransaction()
        val manager = ProjectManager(5, username, 1000.00)
        session.save(manager)
        session.transaction.commit()
    }

    override fun updateBankingStrategy(id: Int, bankingStrategy: BankingStrategy) {
        val session = sessionFactory.openSession()
        session.beginTransaction()
        val manager = session.load(ProjectManager::class.java, id)
        manager.bankingStrategy = bankingStrategy
        session.save(manager)
        session.transaction.commit()
    }
}