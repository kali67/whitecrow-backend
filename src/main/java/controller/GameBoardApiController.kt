package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import whitecrow.service.interfaces.IGameBoardService
import whitecrow.static_objects.GameBoard

@RestController
@CrossOrigin
class GameBoardApiController @Autowired constructor(val gameBoardService: IGameBoardService) {

    @GetMapping("/board")
    fun gameBoard(): GameBoard {
        return gameBoardService.load()
    }
}