package unit

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import whitecrow.service.turn.*

@RunWith(MockitoJUnitRunner::class)
class NormalTurnStrategyTest {

    @Mock
    private lateinit var gameSharedService: IGameSharedService

    @Mock
    private lateinit var gameBoardService: IGameBoardService

    @Mock
    private lateinit var playerRepository: IPlayerRepository

    @Mock
    private lateinit var die: IRandomDieRoller

    @InjectMocks
    private lateinit var normalTurnStrategy: NormalTurnStrategy

    companion object {
        const val GAME_ID = 1
        const val DIE_ROLL_RESULT = 6
        const val DAYS_IN_MONTH = 31
    }

    @Test
    fun useTurn_playerFinishedGame_returnTurnResultPlayerFinished() {
        val player = Player()
        val game = Game(GameType.SINGLEPLAYER, 1, 6, mutableSetOf())
        game.id = GAME_ID
        game.next = player

        whenever(gameSharedService.findOne(GAME_ID)).thenReturn(game)
        whenever(gameSharedService.hasGonePassedFinalDay(any(), any())).thenReturn(true)

        val playerTurnResult = normalTurnStrategy.applyTurnToPlayer(player, GAME_ID)
        assert(playerTurnResult.hasFinishedGame)
    }

    @Test
    fun useTurn_playerFinishedAfterTurn_turnResultContainsCurrentDayAsFinalDay() {
        val player = Player()
        val game = Game(GameType.SINGLEPLAYER, 1, 6, mutableSetOf(player))
        game.id = GAME_ID
        game.next = player

        whenever(gameSharedService.findOne(GAME_ID)).thenReturn(game)
        whenever(gameSharedService.hasGonePassedFinalDay(player.currentDay, game)).thenReturn(false)
        whenever(die.rollDie()).thenReturn(DIE_ROLL_RESULT)

        val playersNewDay = player.currentDay + DIE_ROLL_RESULT
        whenever(gameSharedService.hasGonePassedFinalDay(playersNewDay, game)).thenReturn(true)

        val gameBoardTurnResult = TurnResultBuilder(player.id, DAYS_IN_MONTH).build()
        whenever(gameBoardService.applyTileActionToPlayer(player, game)).thenReturn(gameBoardTurnResult)
        whenever(gameSharedService.findFinalDay(game)).thenReturn(DAYS_IN_MONTH)

        val playerTurnResult = normalTurnStrategy.applyTurnToPlayer(player, GAME_ID)

        assert(playerTurnResult.hasFinishedGame)
        assert(playerTurnResult.currentDay == DAYS_IN_MONTH)
    }


}