package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.Card
import whitecrow.service.interfaces.IOpCardService

@RestController
class OpCardApiController @Autowired constructor(val opCardServiceImpl: IOpCardService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/opportunity/card/draw")
    fun draw(@RequestParam(name = "count", defaultValue = "3") count: Int): List<Card> {
        return opCardServiceImpl.findHand()
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/player/{playerId}/add/opportunity/{opId}")
    fun addOpportunityCard(@PathVariable playerId: Int, opId: Int) {
        opCardServiceImpl.addOpportunityCard(playerId, opId)
    }
}