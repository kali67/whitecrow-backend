package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.Card

@NoRepositoryBean
interface IMailCardRepository : Repository<Card, Int> {
    fun findAll(): List<Card>

    fun findById(id: Int): Card
}