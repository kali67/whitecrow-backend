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

        for (p in players) {
            p.turnType = TurnType.SETBACK
            p.setBackSteps += 1
            playerRepositoryImpl.update(player)
        }

        val turnResultBuilder = TurnResultBuilder(player.id, player.currentDay)
        return turnResultBuilder.apply {
            setTurnStage(TurnProgress.COMPLETED)
            setHasTriggeredSetBack(true)
        }.build()
    }
}