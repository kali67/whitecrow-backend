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

@RunWith(MockitoJUnitRunner::class)
class GameShardServiceTest {

    @Mock
    private lateinit var gameRepositoryImpl: IGameRepository

    @Mock
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Mock
    private lateinit var userServiceImpl: IUserSharedService

    @Mock
    private lateinit var playerServiceImpl: IPlayerService


    @InjectMocks
    private lateinit var gameSharedService: GameSharedServiceImpl

    companion object {
        const val GAME_ID = 1
        const val NUMBER_DAYS_IN_MONTH = 31
    }

    @Test
    fun gameHasFinished_AllPlayersFinished_returnTrue() {
        val playerOne = Player()
        playerOne.currentDay = NUMBER_DAYS_IN_MONTH
        playerOne.id = 1
        val playerTwo = Player()
        playerTwo.currentDay = NUMBER_DAYS_IN_MONTH
        playerOne.id = 2
        val playersInGame = mutableSetOf(playerOne, playerTwo)
        whenever(gameRepositoryImpl.findAllPlayers(GAME_ID)).thenReturn(playersInGame.toList())

        val game = Game(GameType.SINGLEPLAYER, 1, 2, playersInGame)
        game.id = GAME_ID
        val hasGameFinished = gameSharedService.gameHasFinished(game)

        assert(hasGameFinished)
    }


    @Test
    fun gameHasFinished_NotAllPlayersFinished_returnFalse() {
        val playerOne = Player()
        playerOne.currentDay = NUMBER_DAYS_IN_MONTH * 2
        playerOne.id = 1
        val playerTwo = Player()
        playerTwo.currentDay = NUMBER_DAYS_IN_MONTH
        playerOne.id = 2
        val playersInGame = mutableSetOf(playerOne, playerTwo)

        whenever(gameRepositoryImpl.findAllPlayers(GAME_ID)).thenReturn(playersInGame.toList())
        val game = Game(GameType.SINGLEPLAYER, 2, 2, playersInGame)
        game.id = GAME_ID
        val hasGameFinished = gameSharedService.gameHasFinished(game)

        assert(!hasGameFinished)
    }

}