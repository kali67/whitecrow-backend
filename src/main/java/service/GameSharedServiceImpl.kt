package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.GameDto
import whitecrow.dto.PlayerDTO
import whitecrow.mappers.GameMapperDTO
import whitecrow.mappers.PlayerMapperDTO
import whitecrow.model.Game
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.repository.interfaces.IPlayerRepository
import whitecrow.service.interfaces.IGameSharedService
import whitecrow.service.interfaces.IPlayerService
import whitecrow.service.interfaces.IUserSharedService
import javax.transaction.Transactional
import kotlin.random.Random

@Service
@Transactional
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
        val players = gameRepositoryImpl.findAllPlayers(id)
        return players.map { playerMapperDTO.to(it) }
    }

    override fun findCurrentPlayer(gameId: Int): PlayerDTO {
        val currentUser = userServiceImpl.currentUser()
        val players = gameRepositoryImpl.findAllPlayers(gameId)
        return playerMapperDTO.to(players.first { it.user?.id == currentUser.id })
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
        return playersInGame.all { it.currentDay > NUMBER_DAYS_MONTH * game.numberRounds }
    }

    override fun endGame(id: Int): GameDto {
        val game = gameRepositoryImpl.findOne(id)
        if (gameHasFinished(game)) {
            val playersInGame = gameRepositoryImpl.findAllPlayers(id)
            val winner = playersInGame.maxBy { playerServiceImpl.calculateScore(it) }
            game.winner = winner
            gameRepositoryImpl.update(game)
        }
        return gameMapperDTO.to(game)
    }

    override fun progressToNextPlayer(gameId: Int) {
        val game = gameRepositoryImpl.findOne(gameId)
        val nextPlayer = game.next
        if (nextPlayer != null) {
            val gamePlayers = gameRepositoryImpl.findAllPlayers(gameId)
            val nextOrder = nextPlayer.playOrder.plus(1).rem(gamePlayers.size)
            val newNextPlayer = gamePlayers.first { it.playOrder == nextOrder }
            game.next = newNextPlayer
            gameRepositoryImpl.update(game)
        }
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

    companion object {
        const val NUMBER_DIE = 6
        const val NUMBER_DAYS_MONTH = 31
    }
}