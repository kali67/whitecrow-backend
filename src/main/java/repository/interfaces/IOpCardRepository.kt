package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.*

@NoRepositoryBean
interface IOpCardRepository : Repository<Card, Int> {

    /**
     * Finds all cards of a given lanugage
     * @param language language of cards to return
     * @return list of cards
     */
    fun findAll(language: Language): List<Card>
}