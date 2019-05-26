package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service
import whitecrow.dto.GameDto
import whitecrow.dto.PlayerDTO
import whitecrow.mappers.GameMapperDTO
import whitecrow.mappers.PlayerMapperDTO
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.GameBoardServiceImpl.Companion.NUMBER_DAYS_MONTH
import whitecrow.service.GameBoardServiceImpl.Companion.NUMBER_DIE
import whitecrow.service.interfaces.IGameSharedService
import whitecrow.service.interfaces.IPlayerService
import whitecrow.service.interfaces.IUserSharedService
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
@Lazy
class GameSharedServiceImpl @Autowired constructor(
    var gameRepositoryImpl: IGameRepository,
    var playerRepositoryImpl: IPlayerRepository,
    var userServiceImpl: IUserSharedService,
    var playerServiceImpl: IPlayerService
) : IGameSharedService {

    private val gameMapperDTO = GameMapperDTO()
    private val playerMapperDTO = PlayerMapperDTO()

    override fun findAll(): List<GameDto> {
        return gameRepositoryImpl.findAll().map {
            gameMapperDTO.to(it)
        }
    }

    override fun findAllPlayers(id: Int): List<PlayerDTO> {
        val game = gameRepositoryImpl.findOne(id)
        val players = gameRepositoryImpl.findAllPlayers(id)
        return players.map {
            val playerDTO = playerMapperDTO.to(it)
            playerDTO.hasFinishedGame = playerDTO.day >= NUMBER_DAYS_MONTH * game.numberRounds
            playerDTO
        }
    }

    override fun findCurrentPlayer(gameId: Int): PlayerDTO {
        val currentUser = userServiceImpl.currentUser()
        val players = gameRepositoryImpl.findAllPlayers(gameId)
        val game = gameRepositoryImpl.findOne(gameId)
        val playerDTO = playerMapperDTO.to(players.first { it.user?.id == currentUser.id })
        playerDTO.hasFinishedGame = playerDTO.day >= NUMBER_DAYS_MONTH * game.numberRounds
        return playerDTO
    }

    override fun assignPlayerOrder(gameId: Int) {
        val players = gameRepositoryImpl.findAllPlayers(gameId)
        val shuffledCollection = players.shuffled()
        shuffledCollection.forEachIndexed { index, player ->
            player.playOrder = index
            playerRepositoryImpl.update(player)
        }
        val game = gameRepositoryImpl.findOne(gameId)
        game.next = shuffledCollection[0]
        gameRepositoryImpl.update(game)
    }

    override fun gameHasFinished(game: Game): Boolean {
        val playersInGame = gameRepositoryImpl.findAllPlayers(game.id)
        return playersInGame.all { it.currentDay >= NUMBER_DAYS_MONTH * game.numberRounds }
    }

    override fun calculateEndGameScore(id: Int): GameDto {
        val game = gameRepositoryImpl.findOne(id)
        if (gameHasFinished(game)) {
            val playersInGame = gameRepositoryImpl.findAllPlayers(id)
            playersInGame.forEach {
                it.finalScore = playerServiceImpl.calculateScore(it)
                playerRepositoryImpl.update(it)
            }

            val winner = playersInGame.maxBy {
                it.finalScore
            }
            game.winner = winner
            gameRepositoryImpl.update(game)
        }
        return gameMapperDTO.to(game)
    }

    private fun isValidTurnProgress(game: Game): Boolean {
        val player = findCurrentPlayer(game.id)
        return game.next?.id == player.id
    }

    override fun finalGameDay(game: Game): Int {
        return ((GameBoardServiceImpl.NUMBER_DAYS_MONTH * game.numberRounds) + game.numberRounds - 1)
    }

    private fun findNextPlayer(game: Game): Player? {
        var nextPlayer = game.next
        if (nextPlayer != null) {
            val gamePlayers = gameRepositoryImpl.findAllPlayers(game.id)
            var findingNextPlayer = true
            while (findingNextPlayer) {
                val nextOrder = nextPlayer!!.playOrder.plus(1).rem(gamePlayers.size)
                nextPlayer = gamePlayers.first { it.playOrder == nextOrder }
                findingNextPlayer = nextPlayer.currentDay >= NUMBER_DAYS_MONTH * game.numberRounds
            }
        }
        return nextPlayer
    }

    override fun progressToNextPlayer(gameId: Int) {
        val game = gameRepositoryImpl.findOne(gameId)
        if (!gameHasFinished(game)) {
            val nextPlayer = findNextPlayer(game)
            game.next = nextPlayer
            gameRepositoryImpl.update(game)
        }
    }

    override fun hasGonePassedFinalDay(day: Int, game: Game): Boolean {
        return day >= ((GameBoardServiceImpl.NUMBER_DAYS_MONTH * game.numberRounds) + game.numberRounds - 1)
    }

    override fun rollDice(): Int {
        return Random.nextInt(NUMBER_DIE) + 1
    }

    override fun findOne(id: Int): GameDto {
        val game = gameRepositoryImpl.findOne(id)
        return gameMapperDTO.to(game)
    }

    override fun delete(deleted: Game) {
        gameRepositoryImpl.delete(deleted)
    }

    override fun save(persisted: Game) {
        gameRepositoryImpl.save(persisted)
    }
}