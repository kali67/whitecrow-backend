package whitecrow.mappers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import whitecrow.dto.GameDto
import whitecrow.model.Game

@Component
class GameMapperDTO : IMapper<Game, GameDto> {

    private val playerMapperDTO = PlayerMapperDTO()

    override fun to(from: Game): GameDto {
        val dto = GameDto(from.id, from.type, from.numberRounds, from.maxPlayers, playerMapperDTO.to(from.next!!))
        dto.status = from.state
        dto.players = from.player.map { playerMapperDTO.to(it) }.toMutableSet()
        return dto
    }

    override fun from(from: GameDto): Game {
        return Game(from.type, from.numberRounds, from.maxPlayers)
    }
}