package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.TurnResult

import whitecrow.service.interfaces.IPlayerService

@RestController
@CrossOrigin
class PlayerApiController @Autowired constructor(var playerService: IPlayerService) {


    @PostMapping("/player/{playerId}/game/{gameId}/roll")
    fun useTurn(@PathVariable playerId: Int, @PathVariable gameId: Int): TurnResult {
        return playerService.useTurn(playerId, gameId)
    }
}