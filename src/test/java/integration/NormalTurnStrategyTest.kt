package integration

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.boot.test.mock.mockito.*
import org.springframework.context.*
import org.springframework.test.context.*
import org.springframework.test.context.jdbc.*
import org.springframework.test.context.junit4.*
import org.springframework.test.util.*
import org.springframework.transaction.annotation.*
import whitecrow.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*
import whitecrow.service.turn.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@ActiveProfiles("test")
@Transactional
@Sql(
    scripts = ["classpath:test_scripts/game_shared_service/light_games.sql"],
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
class NormalTurnStrategyTest {

    @SpyBean
    private lateinit var die: IRandomDieRoller

    @Autowired
    private lateinit var normalTurnStrategy: NormalTurnStrategy

    @Autowired
    private lateinit var authenticationService: IAuthenticationService

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    @Autowired
    private lateinit var appContext: ApplicationContext

    companion object {
        const val GAME_ONE_ID = 1
        const val PLAYER_TWO_ID = 2
        const val OPPORTUNITY_CARD_DIE_ROLL = 4
        const val OPPORTUNITY_DECISION_ROLL_ACCEPT = 4
        const val OPPORTUNITY_DECISION_ROLL_DECLINE = 2
    }

    @Before
    fun setUpMocks() {
        //must manually init mocks as we are using SpringRunner rather than mockito spring runner
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun useTurn_AiPlayerLandsOnOpportunityTileAndAccepts_CardAddedToPlayerInvestmentFlowCreated() {

        // use reflection of die property to set mocks for die parameters
        // @SpyBean and @Autowired don't seem to be creating dependencies correctly
        ReflectionTestUtils.setField(normalTurnStrategy, "die", die)
        ReflectionTestUtils.setField(appContext.getBean(AIOpportunityTileService::class.java), "die", die)

        val expectedNumberOfCards = 1
        whenever(die.rollDie()).thenReturn(OPPORTUNITY_CARD_DIE_ROLL).thenReturn(OPPORTUNITY_DECISION_ROLL_ACCEPT)
        authenticationService.authenticate("bob", "welcome1")
        normalTurnStrategy.applyTurnToPlayer(playerServiceImpl.findOne(PLAYER_TWO_ID), GAME_ONE_ID)

        val playerTwo = playerServiceImpl.findOne(PLAYER_TWO_ID)
        Assert.assertEquals(expectedNumberOfCards, playerServiceImpl.findOne(PLAYER_TWO_ID).cards.size)

        val expectedNumberOfFlows = 1
        val playerTwoInvestmentFlows = playerTwo.flow.filter { it.flowType == FlowType.INVESTMENT }
        Assert.assertEquals(expectedNumberOfFlows, playerTwoInvestmentFlows.size)

        val opportunityCardAdded = playerTwo.cards.first { it.cardType == CardType.OPPORTUNITY }
        Assert.assertEquals(opportunityCardAdded.cost, playerTwoInvestmentFlows.first().amount)
    }

    @Test
    fun useTurn_AiPlayerLandsOnOpportunityTileAndDeclines_CardNotAddedToPlayerNoInvestmentFlowCreated() {
        ReflectionTestUtils.setField(normalTurnStrategy, "die", die)
        ReflectionTestUtils.setField(appContext.getBean(AIOpportunityTileService::class.java), "die", die)

        val expectedNumberOfCards = 0
        whenever(die.rollDie()).thenReturn(OPPORTUNITY_CARD_DIE_ROLL).thenReturn(OPPORTUNITY_DECISION_ROLL_DECLINE)
        authenticationService.authenticate("bob", "welcome1")
        normalTurnStrategy.applyTurnToPlayer(playerServiceImpl.findOne(PLAYER_TWO_ID), GAME_ONE_ID)
        Assert.assertEquals(expectedNumberOfCards, playerServiceImpl.findOne(PLAYER_TWO_ID).cards.size)

        val playerTwo = playerServiceImpl.findOne(PLAYER_TWO_ID)
        Assert.assertEquals(expectedNumberOfCards, playerServiceImpl.findOne(PLAYER_TWO_ID).cards.size)

        val expectedNumberOfFlows = 0
        val playerTwoInvestmentFlows = playerTwo.flow.filter { it.flowType == FlowType.INVESTMENT }
        Assert.assertEquals(expectedNumberOfFlows, playerTwoInvestmentFlows.size)
    }
}