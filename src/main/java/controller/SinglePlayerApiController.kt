package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.TurnResult
import whitecrow.service.interfaces.ISinglePlayerGameService

@RestController
class SinglePlayerApiController @Autowired constructor(private val singlePlayerApiController: ISinglePlayerGameService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/game/single/{id}/start")
    fun start(@PathVariable id: Int): List<TurnResult> {
        return singlePlayerApiController.start(id)
    }
}