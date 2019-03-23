package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import whitecrow.model.Game
import whitecrow.model.GameState
import whitecrow.service.interfaces.IGameService

@RestController
class GameApiController @Autowired constructor(val gameServiceImpl: IGameService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com"])
    @GetMapping("/game")
    fun listGamesByState (@RequestParam state: GameState) : List<Game> {
        return gameServiceImpl.findAllByState(state)
    }
}