package whitecrow.repository

import org.hibernate.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*

@Repository
class LanguageRepositoryImpl @Autowired constructor(val sessionFactory: SessionFactory) : ILanguageRepository {

    override fun findByCode(code: String): Language {
        val session = sessionFactory.currentSession
        val criteriaBuilder = session.criteriaBuilder
        val query = criteriaBuilder.createQuery(Language::class.java)
        val root = query.from(Language::class.java)
        query.select(root).where(criteriaBuilder.equal(root.get(Language_.code), code))
        return session.createQuery(query).singleResult
    }
}