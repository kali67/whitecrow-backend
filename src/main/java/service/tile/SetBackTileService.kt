package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class SetBackTileService : TileServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(player: Player, game: Game, tile: BoardTile): TurnResult {
        val players = gameRepository.findAllPlayers(game.id)
        var hasTriggeredSetBack = false
        if (player.turnType == TurnType.NORMAL) {
            for (p in players) {
                p.turnType = TurnType.SETBACK
                playerRepositoryImpl.update(player)
            }
            hasTriggeredSetBack = true
        }
        val turnResult = TurnResult(
            player.id, message = "Everyone must go back one day!", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
        turnResult.hasTriggeredSetBack = hasTriggeredSetBack
        return turnResult
    }
}