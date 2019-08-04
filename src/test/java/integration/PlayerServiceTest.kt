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
        )
    ]
)
class PlayerServiceTest {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    companion object {
        const val PLAYER_ONE_ID = 1
        const val PLAYER_STARTING_MONEY = 1000f
    }

    @Test
    fun increaseMoney_PlayerHasStartingMoney_TotalMoneySummed() {
        val increaseSum = 200f
        playerServiceImpl.increaseMoney(PLAYER_ONE_ID, increaseSum)
        val player = playerServiceImpl.findOne(PLAYER_ONE_ID)
        Assert.assertEquals(1200f, player.money)
    }

    @Test
    fun calculateScore_PlayerHasNoInvestments_ScoreIsTotalMoney() {
        val player = playerServiceImpl.findOne(PLAYER_ONE_ID)
        val score = playerServiceImpl.calculateScore(player)
        Assert.assertEquals(PLAYER_STARTING_MONEY, score)
    }

}