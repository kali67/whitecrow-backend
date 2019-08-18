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
import whitecrow.mappers.*
import whitecrow.service.interfaces.IGameSharedService
import whitecrow.service.interfaces.ISinglePlayerGameService

@RestController
@CrossOrigin
class GameApiController @Autowired constructor(
    val singlePlayerGameService: ISinglePlayerGameService,
    val gameSharedServiceImpl: IGameSharedService
) {

    private val gameMapperDTO = GameMapperDTO()

    @GetMapping("/game")
    fun listGamesByState(): List<GameDto> {
        return gameSharedServiceImpl.findAll().map { gameMapperDTO.to(it) }
    }

    @PostMapping("/game/{id}/end_turn")
    fun endTurn(@PathVariable id: Int) {
        gameSharedServiceImpl.progressToNextPlayer(id)
    }


    @GetMapping("/game/players")
    fun findAllPlayers(@RequestParam from: Int): List<PlayerDTO> {
        return gameSharedServiceImpl.findAllPlayers(from)
    }

    @PostMapping("/game/create/single_player")
    fun create(@RequestBody game: GameDto): GameDto {
        return singlePlayerGameService.setUpGame(game)
    }

    @GetMapping("/game/details/{id}")
    fun load(@PathVariable id: Int): GameDto {
        val game = gameSharedServiceImpl.findOne(id)
        return gameMapperDTO.to(game)
    }

    @PostMapping("/game/start/{id}")
    fun start(@PathVariable id: Int) {
        singlePlayerGameService.start(id)
    }

    @GetMapping("/game/{id}/player")
    fun findCurrentPlayer(@PathVariable id: Int): PlayerDTO {
        return gameSharedServiceImpl.findCurrentPlayer(id)
    }

    @PostMapping("/game/{id}/end")
    fun endGame(@PathVariable id: Int): GameDto {
        return gameSharedServiceImpl.calculateEndGameScore(id)
    }

    @RequestMapping(method = [RequestMethod.OPTIONS], value = ["/*"]) // todo: pre flight requests
    @ResponseBody
    fun handleOptions(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}