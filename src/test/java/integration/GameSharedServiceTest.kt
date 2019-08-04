package integration

import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import org.junit.*
import org.junit.runner.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.*
import org.springframework.test.context.jdbc.*
import org.springframework.test.context.junit4.*
import org.springframework.transaction.annotation.*
import whitecrow.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [Application::class])
@ActiveProfiles("test")
@Transactional
@SqlGroup(
    value = [
        Sql(
            scripts = ["classpath:test_scripts/game_shared_service/light_games.sql"],
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
        )
//        Sql(
//            scripts = ["classpath:test_scripts/helpers/clean_db.sql"],
//            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
//        )
    ]
)
class GameSharedServiceTest {

    @Autowired
    private lateinit var gameSharedServiceImpl: IGameSharedService

    @Autowired
    private lateinit var playerService: IPlayerService

    companion object {

        const val GAME_ONE_ID = 1
        const val MAX_DAYS_ONE_ROUND = 31
        const val PLAYER_TWO_ID = 2
        const val PLAYER_ONE_ID = 1
        const val PLAYER_THREE_ID = 3

        @JvmStatic
        @BeforeClass
        fun setUp() {

        }
    }

    //UnitOfWork_StateUnderTest_ExpectedBehavior

    @Test
    fun findAll_DbPopulated_ReturnsTwoGames() {
        assert(gameSharedServiceImpl.findAll().size == 2)
    }

    @Test
    fun gameHasFinished_AllPlayersCurrentDayZero_NotFinished() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        assert(!gameSharedServiceImpl.gameHasFinished(game))
    }

    @Test
    fun gameHasFinished_AllPlayersPastMaxDays_Finished() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.player.forEach {
            it.currentDay = 1
        }
        assert(!gameSharedServiceImpl.gameHasFinished(game))
    }

    @Test
    fun gameHasFinished_OnePlayerPastMaxDays_Finished() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.player.first().currentDay = MAX_DAYS_ONE_ROUND
        assert(!gameSharedServiceImpl.gameHasFinished(game))
    }

    @Test
    fun findAllPlayers_PlayersInGame_ReturnTwoPlayers() {
        val players = gameSharedServiceImpl.findAllPlayers(GAME_ONE_ID)
        assert(players.size == 2)
    }

    @Test
    fun progressToNextPlayer_PlayerOneFinishedTurn_PlayerTwoTurnNow() {
        gameSharedServiceImpl.progressToNextPlayer(GAME_ONE_ID)
        val nextPlayer = gameSharedServiceImpl.findOne(GAME_ONE_ID).next
        if (nextPlayer != null) {
            assert(nextPlayer.id == PLAYER_TWO_ID)
        } else {
            fail("Next player is null")
        }
    }

    @Test
    fun progressToNextPlayer_GameHasFinished_NoNextPlayerUpdate() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.player.forEach {
            it.currentDay = MAX_DAYS_ONE_ROUND
            playerService.update(it)
        }
        gameSharedServiceImpl.progressToNextPlayer(GAME_ONE_ID)
        val nextPlayer = gameSharedServiceImpl.findOne(GAME_ONE_ID).next
        if (nextPlayer != null) {
            assert(nextPlayer.id == PLAYER_ONE_ID)
        } else {
            fail("Next player is null")
        }
    }

    @Test
    fun progressToNextPlayer_PlayerTwoFinishedTurn_PlayerOnesTurn() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.next = playerService.findOne(PLAYER_TWO_ID)
        gameSharedServiceImpl.update(game)

        gameSharedServiceImpl.progressToNextPlayer(GAME_ONE_ID) //finish player 2 turn
        val nextPlayer = gameSharedServiceImpl.findOne(GAME_ONE_ID).next
        if (nextPlayer != null) {
            assert(nextPlayer.id == PLAYER_ONE_ID)
        } else {
            fail("Next player is null")
        }
    }

    @Test
    fun progressToNextPlayer_PlayerTwoAlreadyFinishedGame_PlayerThreeTurn() {
        createNewPlayer(GAME_ONE_ID, PLAYER_THREE_ID)

        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.player.add(Player(PLAYER_THREE_ID, null))
        game.next = playerService.findOne(PLAYER_ONE_ID)
        gameSharedServiceImpl.update(game)

        val playerTwo = playerService.findOne(PLAYER_TWO_ID)
        playerTwo.currentDay = MAX_DAYS_ONE_ROUND
        playerService.update(playerTwo)

        gameSharedServiceImpl.progressToNextPlayer(GAME_ONE_ID) //finish player 2 turn
        val nextPlayer = gameSharedServiceImpl.findOne(GAME_ONE_ID).next
        if (nextPlayer != null) {
            assert(nextPlayer.id == PLAYER_THREE_ID)
        } else {
            fail("Next player is null")
        }
    }

    @Test
    fun findFinalDay_GameHasOneRound_Return31() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        val finalDay = gameSharedServiceImpl.findFinalDay(game)
        assertEquals(MAX_DAYS_ONE_ROUND, finalDay)
    }

    @Test
    fun findFinalDay_GameHasTwoRounds_Return63() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.numberRounds = 2
        val finalDay = gameSharedServiceImpl.findFinalDay(game)
        assertEquals(63, finalDay)
    }

    @Test
    fun findFinalDay_GameHasThreeRounds_Return95() {
        val game = gameSharedServiceImpl.findOne(GAME_ONE_ID)
        game.numberRounds = 3
        val finalDay = gameSharedServiceImpl.findFinalDay(game)
        assertEquals(95, finalDay)
    }

    private fun createNewPlayer(gameId: Int, playerId: Int): Player {
        val newPlayer = Player(playerId)
        newPlayer.game = gameSharedServiceImpl.findOne(gameId)
        newPlayer.playOrder = (gameSharedServiceImpl.findAllPlayers(GAME_ONE_ID).maxBy { it.order } as PlayerDTO).order + 1
        playerService.save(newPlayer)
        return newPlayer
    }


}