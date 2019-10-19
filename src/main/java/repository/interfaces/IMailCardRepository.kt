package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.model.*

@NoRepositoryBean
interface IMailCardRepository : Repository<Card, Int> {


    /**
     * Finds all MAIL cards by a given language/translation
     *
     * @param language object to find cards by
     * @return list of cards belonging to the language given
     */
    fun findAll(language: Language): List<Card>

    /**
     * Finds a MAIL card by an ID
     *
     * @param id this is a composite primary key of card to find,
     * made up of Lang and Int id for a card.
     * @return the correct card conforming to the id given
     */
    fun findById(id: CardId): Card

    /**
     * Loads 'Transient' objects for a list of MAIL cards.
     * In this scenario, 'transients' are card categories etc
     *
     * @param cards list of cards to load card categories onto
     * @return list of cards with all transients loaded
     */
    fun loadTransients(cards: List<Card>): List<Card>
}