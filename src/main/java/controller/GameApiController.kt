package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.GameDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import whitecrow.dto.PlayerDTO
import whitecrow.service.interfaces.IGameSharedService
import whitecrow.service.interfaces.ISinglePlayerGameService

@RestController
class GameApiController @Autowired constructor(
    val singlePlayerGameService: ISinglePlayerGameService,
    val gameSharedServiceImpl: IGameSharedService
) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/game")
    fun listGamesByState(): List<GameDto> {
        return gameSharedServiceImpl.findAll()
    }


    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/game/{id}/end_turn")
    fun endTurn(@PathVariable id: Int) {
        gameSharedServiceImpl.progressToNextPlayer(id)
    }


    @GetMapping("/game/players")
    fun findAllPlayers(@RequestParam from: Int): List<PlayerDTO> {
        return gameSharedServiceImpl.findAllPlayers(from)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/game/create/single_player")
    fun create(@RequestBody game: GameDto): GameDto {
        return singlePlayerGameService.create(game)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/game/details/{id}")
    fun load(@PathVariable id: Int): GameDto {
        return gameSharedServiceImpl.findOne(id)
    }

    @PostMapping("/game/start/{id}")
    fun start(@PathVariable id: Int) {
        singlePlayerGameService.start(id)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/game/{id}/player")
    fun findCurrentPlayer(@PathVariable id: Int): PlayerDTO {
        return gameSharedServiceImpl.findCurrentPlayer(id)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/game/{id}/end")
    fun endGame(@PathVariable id: Int): GameDto {
        return gameSharedServiceImpl.endGame(id)
    }

    @RequestMapping(method = [RequestMethod.OPTIONS], value = ["/*"]) // todo: pre flight requests
    @ResponseBody
    fun handleOptions(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}