package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.Card
import whitecrow.service.interfaces.IOpCardService

@RestController
@CrossOrigin
class OpCardApiController @Autowired constructor(val opCardServiceImpl: IOpCardService) {

    @GetMapping("/opportunity/card/draw")
    fun draw(@RequestParam(name = "count", defaultValue = "3") count: Int): List<Card> {
        return opCardServiceImpl.findHand()
    }

    @PostMapping("/player/{playerId}/add/opportunity/{opId}")
    fun addOpportunityCard(@PathVariable playerId: Int, @PathVariable opId: Int) {
        opCardServiceImpl.addOpportunityCard(playerId, opId)
    }
}