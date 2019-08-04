package integration

import org.junit.*
import org.junit.runner.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.*
import org.springframework.test.context.jdbc.*
import org.springframework.test.context.junit4.*
import org.springframework.transaction.annotation.*
import whitecrow.*
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
        ),
        Sql(
            scripts = ["classpath:test_scripts/helpers/clean_db.sql"],
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD
        )
    ]
)
class GameSharedServiceTest {

    @Autowired
    private lateinit var gameSharedServiceImpl: IGameSharedService

    companion object {

        const val GAME_ONE_ID = 1

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


}