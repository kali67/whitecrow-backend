package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.GameDto
import whitecrow.dto.PlayerDTO
import whitecrow.mappers.GameMapperDTO
import whitecrow.mappers.PlayerMapperDTO
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.service.GameBoardServiceImpl.Companion.NUMBER_DAYS_MONTH
import whitecrow.service.interfaces.IPlayerService
import whitecrow.service.interfaces.IUserSharedService
import javax.transaction.Transactional

@Service
@Transactional
class GameSharedServiceImpl @Autowired constructor(
    private var gameRepositoryImpl: IGameRepository,
    private var userServiceImpl: IUserSharedService,
    private var playerServiceImpl: IPlayerService
) {

    @Autowired
    private lateinit var playerShufflerFacade: IPlayerShuffler

    private val gameMapperDTO = GameMapperDTO()
    private val playerMapperDTO = PlayerMapperDTO()

    fun findAll(): List<Game> {
        return gameRepositoryImpl.findAll()
    }

    fun findAllPlayers(id: Int): List<PlayerDTO> {
        val game = gameRepositoryImpl.findOne(id)
        val players = gameRepositoryImpl.findAllPlayers(id)
        return players.map {
            val playerDTO = playerMapperDTO.to(it)
            playerDTO.hasFinishedGame = playerDTO.day >= NUMBER_DAYS_MONTH * game.numberRounds
            playerDTO
        }
    }

    fun findCurrentPlayer(gameId: Int): PlayerDTO {
        val currentUser = userServiceImpl.currentUser()
        val players = gameRepositoryImpl.findAllPlayers(gameId)

        val game = gameRepositoryImpl.findOne(gameId)
        val playerDTO = playerMapperDTO.to(players.first { it.user?.id == currentUser.id })
        playerDTO.hasFinishedGame = playerDTO.day >= findFinalDay(game)
        return playerDTO
    }

    fun assignPlayerOrder(game: Game) {
        val players = game.player
        val shuffledCollection = playerShufflerFacade.shufflePlayers(players)
        shuffledCollection.forEachIndexed { index, player ->
            player.playOrder = index
            playerServiceImpl.update(player)
        }
        game.next = shuffledCollection[0]
        update(game)
    }

    fun gameHasFinished(game: Game): Boolean {
        val playersInGame = gameRepositoryImpl.findAllPlayers(game.id)
        return playersInGame.all { it.currentDay >= NUMBER_DAYS_MONTH * game.numberRounds }
    }


    fun calculateEndGameScore(id: Int): GameDto {
        val game = gameRepositoryImpl.findOne(id)
        if (gameHasFinished(game)) {
            val playersInGame = gameRepositoryImpl.findAllPlayers(id)
            playersInGame.forEach {
                it.finalScore = playerServiceImpl.calculateScore(it)
                playerServiceImpl.update(it)
            }
            val winner = playersInGame.maxBy {
                it.finalScore
            }
            game.winner = winner
            update(game)
        }
        return gameMapperDTO.to(game)
    }

    fun findFinalDay(game: Game): Int {
        return ((NUMBER_DAYS_MONTH * game.numberRounds) + game.numberRounds - 1)
    }

    private fun findNextPlayer(game: Game): Player? {
        var nextPlayer = game.next
        if (nextPlayer != null) {
            val gamePlayers = gameRepositoryImpl.findAllPlayers(game.id)
            val nextOrder = nextPlayer.playOrder.plus(1).rem(gamePlayers.size)
            nextPlayer = gamePlayers.first { it.playOrder == nextOrder }

        }
        return nextPlayer
    }

    fun progressToNextPlayer(gameId: Int) {
        val game = gameRepositoryImpl.findOne(gameId)
        val nextPlayer = findNextPlayer(game)
        game.next = nextPlayer
        update(game)
    }

    fun hasGonePassedFinalDay(day: Int, game: Game): Boolean {
        return day >= ((NUMBER_DAYS_MONTH * game.numberRounds) + game.numberRounds - 1)
    }

    fun findFinishedGames(): List<GameDto> {
        val user = userServiceImpl.currentUser()
        return gameRepositoryImpl.findAllFinishedGamesByUser(user).map { gameMapperDTO.to(it) }
    }

    fun update(game: Game) {
        gameRepositoryImpl.update(game)
    }

    fun findOne(id: Int): Game {
        return gameRepositoryImpl.findOne(id)
    }

    fun save(persisted: Game) {
        gameRepositoryImpl.save(persisted)
    }
}