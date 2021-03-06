package whitecrow.mappers

import org.springframework.stereotype.Component
import whitecrow.dto.GameDto
import whitecrow.model.Game
import javax.transaction.*

@Component
@Transactional
class GameMapperDTO : IMapper<Game, GameDto> {

    private val playerMapperDTO = PlayerMapperDTO()

    override fun to(from: Game): GameDto {
        val dto = GameDto(from.type, from.numberRounds, from.maxPlayers, playerMapperDTO.to(from.next!!))
        dto.id = from.id
        dto.winner = from.winner?.let {
            playerMapperDTO.to(it)
        }
        dto.players = from.player.map { playerMapperDTO.to(it) }.toMutableSet()
        return dto
    }

    override fun from(from: GameDto): Game {
        return Game(from.type, from.numberRounds, from.maxPlayers)
    }
}