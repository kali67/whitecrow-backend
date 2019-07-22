package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.*

@NoRepositoryBean
interface IMailCardRepository : Repository<Card, Int> {
    fun findAll(language: Language): List<Card>

    fun findById(id: CardId): Card

    fun loadTransients(cards: List<Card>): List<Card>
}