package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.TurnResult
import whitecrow.service.interfaces.IGameSharedService

import whitecrow.service.interfaces.IPlayerService

@RestController
class PlayerApiController @Autowired constructor(var playerService: IPlayerService) {


    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/player/{playerId}/game/{gameId}/roll")
    fun useTurn(@PathVariable playerId: Int, @PathVariable gameId: Int): TurnResult {
        return playerService.useTurn(playerId, gameId)
    }
}