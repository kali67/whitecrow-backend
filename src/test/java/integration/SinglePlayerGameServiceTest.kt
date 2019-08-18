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
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.*
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
class SinglePlayerGameServiceTest {

    @SpyBean
    private lateinit var die: IRandomDieRoller

    @SpyBean
    private lateinit var playerShufflerFacade: IPlayerShuffler

    @Autowired
    private lateinit var singlePlayerGameService: SinglePlayerGameService

    @Autowired
    private lateinit var gameSharedServiceImpl: GameSharedServiceImpl

    @Autowired
    private lateinit var playerServiceImpl: PlayerServiceImpl

    @Autowired
    private lateinit var authenticationService: IAuthenticationService

    @Autowired
    private lateinit var appContext: ApplicationContext


    companion object {
        const val GAME_ID = 3
    }

    @Before
    fun setUpMocks() {
        MockitoAnnotations.initMocks(this)
        ReflectionTestUtils.setField(appContext.getBean(NormalTurnStrategy::class.java), "die", die)
        ReflectionTestUtils.setField(appContext.getBean(AIOpportunityTileService::class.java), "die", die)
        ReflectionTestUtils.setField(appContext.getBean(GameSharedServiceImpl::class.java), "playerShufflerFacade", playerShufflerFacade)
    }


    @Test
    fun makePlayerTurns_userHasFirstTurn_noTurnResultsReturned() {
        authenticationService.authenticate("bob", "welcome1")

        whenever(die.rollDie()).thenReturn(6)

        singlePlayerGameService.create(GameDto(GameType.SINGLEPLAYER, 1,6))
        var game = gameSharedServiceImpl.findOne(GAME_ID)
        val userPlayerDto = gameSharedServiceImpl.findCurrentPlayer(GAME_ID)
        val playerEntity = playerServiceImpl.findOne(userPlayerDto.id)
        val expectedReturnOfShuffle = mutableListOf(playerEntity)
        expectedReturnOfShuffle.addAll(game.player.filter { it.id != playerEntity.id })
        whenever(playerShufflerFacade.shufflePlayers(game.player)).then { expectedReturnOfShuffle }
        gameSharedServiceImpl.assignPlayerOrder(game)

        val turnResults = singlePlayerGameService.makePlayerTurns(GAME_ID)
        Assert.assertEquals(6, game.player.size)
        Assert.assertEquals("User player has first turn so no turns should occur yet",0, turnResults.size)


        playerEntity.currentDay = 31
        playerServiceImpl.update(playerEntity)
        val turnResult = playerServiceImpl.useTurn(playerEntity.id, GAME_ID)
        Assert.assertEquals(true, turnResult.hasFinishedGame)

        game = gameSharedServiceImpl.findOne(GAME_ID)
        Assert.assertEquals(game.player.first { it.playOrder == 1 }, game.next)
    }
}