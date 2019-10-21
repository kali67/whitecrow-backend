package unit.tile

import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.service.tile.*

@RunWith(MockitoJUnitRunner::class)
class BonusTileServiceTest {

    @InjectMocks
    private lateinit var bonusTileService: BonusTileService

    @Mock
    private lateinit var playerServiceImpl: IPlayerService

    private lateinit var game: Game

    private lateinit var players: MutableSet<Player>

    private lateinit var bonusTile: BoardTile

    companion object {
        const val BONUS_TILE_AMOUNT = 500f
    }

    @Before
    fun mockBeans() {
        game = Game(GameType.SINGLEPLAYER, 1, 3)
        players = sortedSetOf(Player(1), Player(2), Player(3)) // ensure player 1 is first to roll
        game.player = players
        bonusTile = BoardTile(
            1, TileType.BONUS, BONUS_TILE_AMOUNT, "Title", "Description",
            "action", "red", "red", "red", "red"
        )
    }

    @Test
    fun applyTileAction_bonusTile_PlayerHasCorrectMoney() {
        val turnResult = bonusTileService.applyTileAction(players.first(), game, bonusTile)
        Assert.assertEquals(BONUS_TILE_AMOUNT, turnResult.moneyDifference)
    }
}