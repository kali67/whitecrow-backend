package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.service.*

@RestController
@CrossOrigin
class OpCardApiController @Autowired constructor(val opCardServiceImpl: OpCardServiceImpl) {


    @PostMapping("/player/{playerId}/add/opportunity/{opId}")
    fun addOpportunityCard(@PathVariable playerId: Int, @PathVariable opId: Int) {
        opCardServiceImpl.addOpportunityCard(playerId, opId)
    }
}