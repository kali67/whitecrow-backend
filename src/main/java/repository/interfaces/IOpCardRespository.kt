package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.Card

@NoRepositoryBean
interface IOpCardRespository : Repository<Card, Int> {

    fun findAll(): List<Card>
}