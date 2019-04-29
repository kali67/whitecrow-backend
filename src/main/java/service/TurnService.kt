package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.TurnProgress
import whitecrow.dto.TurnResult
import whitecrow.model.Card
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import whitecrow.static_objects.BoardTile
import javax.transaction.Transactional
import kotlin.random.Random

@Service
abstract class PlayerTurnService {

    @Autowired
    private lateinit var gameSharedServiceImpl: IGameSharedService

    fun executeAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val turnResult = applyTileAction(playerId, gameId, tile)
        if (turnResult.turnStage == TurnProgress.COMPLETED || turnResult.turnStage == TurnProgress.COMPLETED_WITH_ROLLS) {
            gameSharedServiceImpl.endTurn(gameId)
        }
        return turnResult
    }

    abstract fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult
}

@Service
class MailTileService : PlayerTurnService() {

    @Autowired
    private lateinit var mailCardServiceImpl: IMailCardService

    @Transactional
    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val card = mailCardServiceImpl.findCardHand()
        mailCardServiceImpl.addMailCard(playerId, card.id)
        return TurnResult(playerId, card, message = "test", turnStage = TurnProgress.COMPLETED)
    }

}


@Service
class ExpenseTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        playerServiceImpl.deductMoney(playerId, tile.cost)
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED)
    }

}

@Service
class OpportunityTileService : PlayerTurnService() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val card = opCardServiceImpl.findHand().first()
        return TurnResult(
            playerId,
            oppourtunityCard = card,
            message = "test",
            turnStage = TurnProgress.COMPLETED //TODO: needs client request to confirm decision, this will end the turn
        )
    }
}

@Service
class AIOpportunityTileService : PlayerTurnService() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val cards = opCardServiceImpl.findHand()
        val card = makeOpportunityDecision(cards)
        if (card != null) {
            opCardServiceImpl.addOpportunityCard(playerId, card.id)
        }
        return TurnResult(
            playerId,
            oppourtunityCard = cards.first(), //todo
            message = "test",
            turnStage = TurnProgress.COMPLETED
        )
    }

    private fun makeOpportunityDecision(cards: List<Card>): Card? {
        val card = cards[Random.nextInt(cards.size)]
        if (Math.round(Math.random()) == 1L) {
            return card
        }
        return null
    }
}

@Service
class BonusTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        playerServiceImpl.increaseMoney(playerId, tile.cost)
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED)
    }
}

@Service
class GambleTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        playerServiceImpl.deductMoney(playerId, tile.cost)
        //todo : roll for each player in game, add players * cost to winner
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED)
    }
}

@Service
class CostReductionTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        player.costReducedSince = player.currentDay
        playerRepositoryImpl.update(player)
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED)
    }
}

@Service
class SetBackTileService : PlayerTurnService() {

    @Autowired
    private lateinit var gameSharedServiceImpl: IGameSharedService

    @Transactional
    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val players = gameSharedServiceImpl.findAllPlayers(gameId)
//        players.forEach {
//            it.day -= 1 //todo: add method to player service to set players back by X
//        }
//        playerRepositoryImpl.update(player)
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED)
    }
}

@Service
class OtherTileService : PlayerTurnService() {

    override fun applyTileAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        return TurnResult(playerId, message = "Enjoy your rest day!", turnStage = TurnProgress.COMPLETED)
    }


}