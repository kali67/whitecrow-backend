package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.TurnResult
import whitecrow.service.interfaces.ISinglePlayerGameService

@RestController
@CrossOrigin
class SinglePlayerApiController @Autowired constructor(private val singlePlayerApiController: ISinglePlayerGameService) {

    @PostMapping("/game/single/{id}/start")
    fun start(@PathVariable id: Int): List<TurnResult> {
        return singlePlayerApiController.start(id)
    }
}