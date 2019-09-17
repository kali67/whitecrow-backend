package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.dto.GameDto
import whitecrow.dto.TurnResult
import whitecrow.mappers.GameMapperDTO
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameRepository
import whitecrow.service.interfaces.*
import java.time.*
import java.time.format.*
import javax.transaction.Transactional

@Service
@Transactional
class SinglePlayerGameService @Autowired constructor(
    private val userServiceImpl: IUserSharedService,
    private val playerServiceImpl: IPlayerService,
    private val gameSharedServiceImpl: IGameSharedService,
    private val gameRepositoryImpl: IGameRepository
) : ISinglePlayerGameService {

    private val gameMapperDTO = GameMapperDTO()

    override fun setUpGame(game: GameDto): GameDto {
        val newGame = create(game)
        gameSharedServiceImpl.assignPlayerOrder(newGame)
        return gameMapperDTO.to(newGame)
    }

    override fun create(game: GameDto): Game {
        val gameCreator = userServiceImpl.currentUser()
        val player = Player()
        player.user = gameCreator
        gameCreator.players.add(player)
        userServiceImpl.update(gameCreator)
        val entity = gameMapperDTO.from(game)
        entity.player.add(player)
        player.game = entity
        for (n in 1 until game.maxPlayers) {
            val botPlayer = Player()
            botPlayer.game = entity
            entity.player.add(botPlayer)
            playerServiceImpl.save(botPlayer)
        }
        gameSharedServiceImpl.save(entity)
        return entity
    }

    @Transactional
    override fun start(id: Int): List<TurnResult> {
        return makePlayerTurns(id)
    }

    @Transactional
    override fun makePlayerTurns(id: Int): List<TurnResult> {
        println(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))
        val game = gameRepositoryImpl.findOne(id)
        val players = gameRepositoryImpl.findAllPlayers(id).sortedBy { it.playOrder }
        val nextPlayer = game.next
        val turnResults = mutableListOf<TurnResult>()
        if (nextPlayer != null) {
            var index = nextPlayer.playOrder
            while (players[index].user == null) { // make turns until it gets back to user
                val turnResult = playerServiceImpl.useTurn(players[index].id, id)
                turnResults.add(turnResult)
                index = (index + 1).rem(players.size)
            }
        }
        return turnResults
    }
}