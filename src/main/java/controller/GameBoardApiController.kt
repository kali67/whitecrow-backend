package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import whitecrow.interfaces.IGameBoardService
import whitecrow.static_objects.GameBoard

@RestController
class GameBoardApiController @Autowired constructor(val gameBoardService: IGameBoardService){


    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/board")
    fun gameBoard(): GameBoard {
        return gameBoardService.load()
    }

}