package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.*
import whitecrow.repository.interfaces.IFlowRepository

@Repository
class FlowRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : IFlowRepository {

    override fun findOne(id: Int): Flow {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun save(persisted: Flow): Flow {
        val session = sessionFactory.currentSession
        session.persist(persisted)
        return persisted
    }
}