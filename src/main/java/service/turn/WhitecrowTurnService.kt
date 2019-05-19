package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class WhitecrowTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.increaseMoney(playerId, tile.cost)
        return TurnResult(
            playerId, turnStage = TurnProgress.COMPLETED,
            moneyDifference = tile.cost
        )
    }
}