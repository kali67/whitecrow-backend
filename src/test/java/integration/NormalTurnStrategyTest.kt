package integration

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
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

    @Mock
    private lateinit var die: IDie

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
        const val OP_CARD_DIE_ROLL = 4
    }


    @Before
    fun setUpMocks() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun useTurn_AIPlayerLandsOnOpportunityTileAndAccepts_CardAddedToPlayerInvestmentFlowCreated() {

        // use reflection of die property to set mocks for die parameters
        // @SpyBean and @Autowired don't seem to be creating dependencies correctly
        ReflectionTestUtils.setField(normalTurnStrategy, "die", die)
        ReflectionTestUtils.setField(appContext.getBean(AIOpportunityTileService::class.java), "die", die)

        val expectedNumberOfCards = 1
        whenever(die.rollDie()).thenReturn(OP_CARD_DIE_ROLL)
        authenticationService.authenticate("bob", "welcome1")
        normalTurnStrategy.useTurn(playerServiceImpl.findOne(PLAYER_TWO_ID), GAME_ONE_ID)
        Assert.assertTrue(playerServiceImpl.findOne(PLAYER_TWO_ID).cards.size == expectedNumberOfCards)
    }
}