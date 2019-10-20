package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.TurnResult
import whitecrow.service.*

@RestController
@CrossOrigin
class SinglePlayerApiController @Autowired constructor(private val singlePlayerApiController: SinglePlayerGameService) {

    @PostMapping("/game/single/{id}/query_turns")
    fun start(@PathVariable id: Int): List<TurnResult> {
        return singlePlayerApiController.makePlayerTurns(id)
    }
}