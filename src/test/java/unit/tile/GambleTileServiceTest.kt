package unit.tile

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import org.springframework.boot.test.mock.mockito.*
import org.springframework.test.util.*
import whitecrow.model.*
import whitecrow.service.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*

@RunWith(MockitoJUnitRunner::class)
class GambleTileServiceTest {

    @Mock
    private lateinit var playerServiceImpl: IPlayerService

    @Mock
    private lateinit var die: IRandomDieRoller

    @InjectMocks
    private lateinit var gambleTileService: GambleTileService

    private lateinit var game: Game

    private lateinit var players: MutableSet<Player>

    private lateinit var gambleTile: BoardTile

    @Before
    fun mockBeans() {
        MockitoAnnotations.initMocks(this)
        ReflectionTestUtils.setField(gambleTileService, "sixSidedDieRoller", die)
        game = Game(GameType.SINGLEPLAYER, 1, 3)
        players = sortedSetOf(Player(1), Player(2), Player(3)) // ensure player 1 is first to roll
        game.player = players
        gambleTile = BoardTile(
            1, TileType.GAMBLE, 100f, "Title", "Description",
            "action", "red", "red", "red", "red"
        )
    }

    @Test
    fun applyTileAction_userWinsRolls_GetsAllMoney() {
        whenever(die.rollDie()).thenReturn(6).thenReturn(5).thenReturn(4)
        whenever(playerServiceImpl.deductMoney(1, gambleTile.cost)).then{}
        val turnResult = gambleTileService.applyTileAction(players.first(), game, gambleTile)
        Assert.assertEquals(200f, turnResult.moneyDifference)
        Assert.assertEquals(1200f, players.find { it.id == 1 }!!.money)
    }

    @Test
    fun applyTileAction_userLosesRolls_GetsNoMoney() {
        whenever(die.rollDie()).thenReturn(4).thenReturn(5).thenReturn(6)
        whenever(playerServiceImpl.deductMoney(1, gambleTile.cost)).then{}
        val turnResult = gambleTileService.applyTileAction(players.first(), game, gambleTile)
        Assert.assertEquals(-100f, turnResult.moneyDifference)
        Assert.assertEquals(900f, players.find { it.id == 1 }!!.money)
    }

    @Test
    fun applyTileAction_userTiesWithAll_GetsSplitMoneyPot() {
        whenever(die.rollDie()).thenReturn(4).thenReturn(4).thenReturn(4)
        whenever(playerServiceImpl.deductMoney(1, gambleTile.cost)).then{}
        val turnResult = gambleTileService.applyTileAction(players.first(), game, gambleTile)
        Assert.assertEquals(0f, turnResult.moneyDifference)
        Assert.assertEquals(1000f, players.find { it.id == 1 }!!.money)
    }


}