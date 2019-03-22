package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import whitecrow.interfaces.IBoardService
import whitecrow.static_objects.GameBoard

@RestController
class BoardApiController @Autowired constructor(val boardService: IBoardService){


    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com"])
    @GetMapping("/board")
    fun gameBoard(): GameBoard {
        return boardService.load()
    }

}