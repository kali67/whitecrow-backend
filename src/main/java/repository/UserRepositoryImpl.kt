package whitecrow.repository

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import whitecrow.model.User
import whitecrow.model.User_
import whitecrow.repository.interfaces.IUserRepository

@Repository
class UserRepositoryImpl @Autowired constructor(private val sessionFactory: SessionFactory) : IUserRepository {

    override fun findByUserName(username: String): User? {
        val session = sessionFactory.currentSession
        val builder = session.criteriaBuilder
        val criteria = builder.createQuery(User::class.java)
        val from = criteria.from(User::class.java)
        criteria.select(from)
        criteria.where(
            builder.equal(
                from.get(User_.userName),
                username
            )
        )
        val users = session.createQuery(criteria).resultList
        return users.stream().findFirst().orElse(null)
    }

    override fun findAll(): List<User> {
        val session = sessionFactory.currentSession
        val builder = session.criteriaBuilder
        val query = builder.createQuery(User::class.java)
        val from = query.from(User::class.java)
        return session.createQuery(query.select(from)).resultList
    }

    override fun save(persisted: User): User {
        val session = sessionFactory.currentSession
        session.persist(persisted)
        return persisted
    }

    override fun update(user: User) {
        val session = sessionFactory.currentSession
        session.update(user)
    }

    override fun findOne(id: Int): User {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(deleted: User) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}