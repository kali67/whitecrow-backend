package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*

/**
 * Implements gambling logic for the gamble tile. All players must
 * pay $100 then each must roll for the highest roll. The player with
 * the highest roll will win the money pot. If multiple win, then its
 * split evenly to the winners.
 */
@Service
class GambleTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    @Autowired
    private lateinit var sixSidedDieRoller: SixSidedDieRoller


    override fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult {
        playerServiceImpl.deductMoney(player.id, tile!!.cost)

        val moneyPot  = game.player.size * 100

        var highestRoll = 0
        val highestRollPlayers = mutableListOf<Player>()
        game.player.forEach {
            it.money -= tile.cost
            val roll = sixSidedDieRoller.rollDie()
            if (roll >= highestRoll)
                highestRoll = roll
                highestRollPlayers.add(it)
            playerServiceImpl.update(it)
        }

        // split money to all winners
        var userPlayerMoneyDifference = -tile.cost
        val moneyPerWinner = moneyPot.div(highestRollPlayers.size)
        highestRollPlayers.forEach {
            it.money += moneyPerWinner
            playerServiceImpl.update(it)
            if (player.id == it.id) userPlayerMoneyDifference += moneyPerWinner
        }

        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setMessage(tile.description)
            setTurnStage(TurnProgress.COMPLETED)
            setMoneyDifference(userPlayerMoneyDifference)
        }.build()
    }
}