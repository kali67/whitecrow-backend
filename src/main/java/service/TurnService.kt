package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.*
import whitecrow.model.Card
import whitecrow.model.Game
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.*
import whitecrow.static_objects.BoardTile
import javax.transaction.Transactional
import kotlin.random.Random

@Service
abstract class PlayerTurnService {

    @Autowired
    protected lateinit var gameSharedServiceImpl: IGameSharedService

    @Autowired
    protected lateinit var gameRepository: IGameRepository


    fun executeAction(playerId: Int, gameId: Int, tile: BoardTile): TurnResult {
        val game = gameRepository.findOne(gameId)
        val turnResult = applyTileAction(playerId, game, tile)
        if (turnResult.turnStage == TurnProgress.COMPLETED || turnResult.turnStage == TurnProgress.COMPLETED_WITH_ROLLS) {
            gameSharedServiceImpl.progressToNextPlayer(gameId)
        }
        if (gameSharedServiceImpl.gameHasFinished(game)) {
            turnResult.isGameEnding = true
        }
        return turnResult
    }

    abstract fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult
}

@Service
class MailTileService : PlayerTurnService() {

    @Autowired
    private lateinit var mailCardServiceImpl: IMailCardService

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val card = mailCardServiceImpl.findCardHand()
        mailCardServiceImpl.addMailCard(playerId, card.id)
        return TurnResult(
            playerId,
            card,
            message = "test",
            turnStage = TurnProgress.COMPLETED,
            moneyDifference = -card.cost
        )
    }

}


@Service
class ExpenseTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.deductMoney(playerId, tile.cost)
        return TurnResult(playerId, message = "test", turnStage = TurnProgress.COMPLETED, moneyDifference = -tile.cost)
    }

}

@Service
class OpportunityTileService : PlayerTurnService() {

    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val card = opCardServiceImpl.findHand().first()
        return TurnResult(
            playerId,
            opportunityCardResult = OpportunityCardResult(card, DECISION.UN_DECIDED),
            message = "test",
            turnStage = TurnProgress.DECISION_PENDING,
            moneyDifference = -card.cost
        )
    }
}

@Service
class AIOpportunityTileService : PlayerTurnService() {


    @Autowired
    private lateinit var opCardServiceImpl: IOpCardService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val cards = opCardServiceImpl.findHand()
        val cardDecision = makeOpportunityDecision(cards)
        if (cardDecision.decision == DECISION.ACCEPTED) {
            opCardServiceImpl.addOpportunityCard(playerId, cardDecision.card.id)
        }
        return TurnResult(
            playerId,
            opportunityCardResult = cardDecision,
            message = "test",
            turnStage = TurnProgress.COMPLETED,
            moneyDifference = -cardDecision.card.cost
        )
    }

    private fun makeOpportunityDecision(cards: List<Card>): OpportunityCardResult {
        val card = cards[Random.nextInt(cards.size)]
        if (Math.round(Math.random()) == 1L) {
            return OpportunityCardResult(card, DECISION.ACCEPTED)
        }
        return OpportunityCardResult(card, DECISION.DECLINED)
    }
}

@Service
class BonusTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.increaseMoney(playerId, tile.cost)
        return TurnResult(
            playerId, message = tile.description, turnStage = TurnProgress.COMPLETED,
            moneyDifference = tile.cost
        )
    }
}

@Service
class GambleTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.deductMoney(playerId, tile.cost)
        //todo : roll for each player in game, add players * cost to winner
        return TurnResult(
            playerId, message = "test", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}

@Service
class CostReductionTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        val player = playerRepositoryImpl.findOne(playerId)
        player.costReducedSince = player.currentDay
        playerRepositoryImpl.update(player)
        return TurnResult(
            playerId, message = "test", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}

@Service
class SetBackTileService : PlayerTurnService() {

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

@Service
class OtherTileService : PlayerTurnService() {

    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        return TurnResult(
            playerId, message = "Enjoy your rest day!", turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}

@Service
class DayWhitecrowTileService : PlayerTurnService() {

    @Autowired
    private lateinit var playerServiceImpl: IPlayerService

    @Transactional
    override fun applyTileAction(playerId: Int, game: Game, tile: BoardTile): TurnResult {
        playerServiceImpl.increaseMoney(playerId, tile.cost)
        return TurnResult(
            playerId, turnStage = TurnProgress.COMPLETED,
            moneyDifference = 0f
        )
    }
}