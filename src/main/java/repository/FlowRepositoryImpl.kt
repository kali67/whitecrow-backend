package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.Flow
import whitecrow.model.FlowType
import whitecrow.model.Flow_
import whitecrow.repository.interfaces.IFlowRepository

@Repository
class FlowRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : IFlowRepository {

    override fun delete(deleted: Flow) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<Flow> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Int): Flow {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun save(persisted: Flow): Flow {
        val session = sessionFactory.currentSession
        session.persist(persisted)
        return persisted
    }

    override fun findByFlowType(type: FlowType): List<Flow> {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Flow::class.java)
        val root = query.from(Flow::class.java)
        query.select(root).where(criteriaBuilder.equal(root.get(Flow_.flowType), type))
        return session.createQuery(query).resultList
    }
}