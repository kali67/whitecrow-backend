package unit

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*

@RunWith(MockitoJUnitRunner.Silent::class)
class MailTileServiceTest {

    @Mock
    private lateinit var playerServiceImpl: PlayerServiceImpl

    @Mock
    private lateinit var playerRepository: IPlayerRepository

    @Mock
    private lateinit var mailCardServiceImpl: MailCardServiceImpl

    @InjectMocks
    private lateinit var mailTileService: MailTileService


    companion object {
        const val MAIL_CARD_ID = 1
        private const val OPPORTUNITY_CARD_ID = 2
        private const val MAIL_CARD_VALUE = 100F
        private const val OPPORTUNITY_CARD_VALUE = 150F
        private lateinit var mailCard: Card
        private lateinit var peopleEnvironmentOpportunityCard: Card
        private lateinit var peopleOrganisationOpportunityCard: Card
        private val cardCategory = CardCategory(0, 1, CardCategoryEnum.PEOPLE_ENVIRONMENT)

        @BeforeClass
        @kotlin.jvm.JvmStatic
        fun mock() {
            mailCard = Card(
                CardId(MAIL_CARD_ID, 1), CardType.MAIL,
                "Test Title", "red", "People (Environment)",
                "Pay $100", "Situation", "Negative scenario", MAIL_CARD_VALUE,
                FlowDirection.OUT
            )
            mailCard.cardCategory = listOf(cardCategory)
            peopleEnvironmentOpportunityCard = Card(
                CardId(OPPORTUNITY_CARD_ID, 1), CardType.OPPORTUNITY, "Test Title",
                "green", "People (Environment)",
                "Cost $100", "Effect", "Positive Scenario", OPPORTUNITY_CARD_VALUE,
                FlowDirection.OUT
            )
            peopleOrganisationOpportunityCard = Card(
                CardId(OPPORTUNITY_CARD_ID, 1), CardType.OPPORTUNITY, "Test Title",
                "green", "People (Environment)",
                "Cost $100", "Effect", "Positive Scenario", OPPORTUNITY_CARD_VALUE,
                FlowDirection.OUT
            )
            peopleOrganisationOpportunityCard.cardCategory = listOf(
                CardCategory(
                    0, 1,
                    CardCategoryEnum.PEOPLE_ORGANISATION
                )
            )

        }
    }


    @Test
    fun applyAction_MailCardWithSameCategoryOpportunityOwned_TurnResultNoCost() {
        val mockedPlayer = Player(1, null)
        mockedPlayer.cards.add(peopleEnvironmentOpportunityCard)
        val mail = mockedPlayer.cards.filter { it.cardType == CardType.MAIL }.map { it.id.cardId }.toIntArray()
        whenever(mailCardServiceImpl.findCardHand(mail)).thenReturn(mailCard)
        whenever(playerRepository.findOne(mockedPlayer.id)).thenReturn(mockedPlayer)
        peopleEnvironmentOpportunityCard.cardCategory = listOf(cardCategory)
        whenever(mailCardServiceImpl.loadTransients(mockedPlayer.cards)).thenReturn(listOf(peopleEnvironmentOpportunityCard))

        whenever(mailCardServiceImpl.addMailCard(mockedPlayer.id, MAIL_CARD_ID)).then {}
        val turnResult = mailTileService.applyTileAction(
            mockedPlayer, Game(
                GameType.SINGLEPLAYER, 1,
                2, mutableSetOf(mockedPlayer)
            ), null
        )
        assert(turnResult.moneyDifference == 0F)
    }

    @Test
    fun applyAction_MailCardWithOutSameCategoryOpCard_TurnResultHasCost() {
        val mockedPlayer = Player(1, null)
        mockedPlayer.cards.add(peopleOrganisationOpportunityCard)
        val mail = mockedPlayer.cards.filter { it.cardType == CardType.MAIL }.map { it.id.cardId }.toIntArray()
        whenever(mailCardServiceImpl.findCardHand(mail)).thenReturn(mailCard)
        whenever(playerRepository.findOne(mockedPlayer.id)).thenReturn(mockedPlayer)
        peopleEnvironmentOpportunityCard.cardCategory = listOf(cardCategory)
        whenever(mailCardServiceImpl.loadTransients(mockedPlayer.cards)).thenReturn(listOf(peopleOrganisationOpportunityCard))

        whenever(mailCardServiceImpl.addMailCard(mockedPlayer.id, MAIL_CARD_ID)).then {}
        val turnResult = mailTileService.applyTileAction(
            mockedPlayer, Game(
                GameType.SINGLEPLAYER, 1,
                2, mutableSetOf(mockedPlayer)
            ), null
        )
        assert(turnResult.moneyDifference == -MAIL_CARD_VALUE)
    }
}