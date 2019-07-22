package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.*

@NoRepositoryBean
interface IOpCardRespository : Repository<Card, Int> {

    fun findAll(language: Language): List<Card>
}