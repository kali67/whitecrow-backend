package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.static_objects.*
import javax.transaction.*

@Service
class SetBackTurnService : TurnServiceBase() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val players = gameRepository.findAllPlayers(game.id)
        players.forEach {
            it.currentDay -= 1
            playerRepositoryImpl.update(it)
        }
        return TurnResult(
            playerId, message = "Everyone must go back one day!", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}