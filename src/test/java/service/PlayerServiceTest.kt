package service

import com.nhaarman.mockitokotlin2.*
import org.junit.*
import org.junit.runner.*
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.*
import whitecrow.service.turn.*

@RunWith(MockitoJUnitRunner::class)
class PlayerServiceTest {

    @Mock
    lateinit var playerRepositoryImpl: IPlayerRepository

    @Mock
    lateinit var turnStrategyFactory: TurnStrategyFactory

    @Mock
    lateinit var flowService: FlowService

    @InjectMocks
    lateinit var playerService: PlayerServiceImpl

    companion object {
        const val PLAYER_ID = 1
        const val PLAYER_STARTING_MONEY = 1000f
    }

    @Test
    fun deductMoney_noBenefits_exactDeduction() {
        val playerUnderTest = Player()
        playerUnderTest.money = PLAYER_STARTING_MONEY
        whenever(playerRepositoryImpl.findOne(PLAYER_ID)).thenReturn(playerUnderTest)
        playerService.deductMoney(PLAYER_ID, 200f)

        assert(playerUnderTest.money == 800f)
    }

    @Test
    fun deductMoney_benefitSinceCurrentDay_reducedDeduction() {
        val playerUnderTest = Player()
        playerUnderTest.money = PLAYER_STARTING_MONEY
        playerUnderTest.costReducedSince = playerUnderTest.currentDay
        whenever(playerRepositoryImpl.findOne(PLAYER_ID)).thenReturn(playerUnderTest)
        playerService.deductMoney(PLAYER_ID, 200f)

        assert(playerUnderTest.money == 900f)
    }

    @Test
    fun deductMoney_benefitExpired_exactDeduction() {
        val playerUnderTest = Player()
        playerUnderTest.money = PLAYER_STARTING_MONEY
        playerUnderTest.currentDay = 31
        playerUnderTest.costReducedSince = playerUnderTest.currentDay - 15
        whenever(playerRepositoryImpl.findOne(PLAYER_ID)).thenReturn(playerUnderTest)
        playerService.deductMoney(PLAYER_ID, 200f)

        assert(playerUnderTest.money == 800f)
    }

}