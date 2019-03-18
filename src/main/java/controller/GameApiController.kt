package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import whitecrow.model.Game
import whitecrow.model.GameState
import whitecrow.service.GameServiceImpl

@RestController
class GameApiController @Autowired constructor(val gameServiceImpl: GameServiceImpl) {

    @GetMapping("/game")
    fun listGamesByState (@RequestParam state: GameState) : List<Game> {
        return gameServiceImpl.filterGamesByState(state)
    }

}