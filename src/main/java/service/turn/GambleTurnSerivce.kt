package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*

@Service
class GambleTurnSerivce : TurnServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.deductMoney(playerId, tile.cost)
        // todo : roll for each player in game, add players * cost to winner
        return TurnResult(
            playerId, message = "test", turnStage = TurnProgress.COMPLETED,
            moneyDifference = -tile.cost
        )
    }
}