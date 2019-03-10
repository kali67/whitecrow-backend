package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import whitecrow.service.IPlayerService


@RestController
class PlayerApiController @Autowired constructor(var playerService: IPlayerService) {

    @GetMapping("/create/player")
    fun createPlayer(@RequestParam(value = "username") username : String): String {
        playerService.createPlayer(username)
        return "done"
    }

}