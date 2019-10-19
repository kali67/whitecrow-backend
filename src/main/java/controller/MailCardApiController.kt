package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.service.*

@RestController
@CrossOrigin
class MailCardApiController @Autowired constructor(val mailCardService: MailCardServiceImpl) {

    @PostMapping("/player/{playerId}/add/mail/{mailId}")
    fun addMailCard(@PathVariable playerId: Int, @PathVariable mailId: Int) {
        mailCardService.addMailCard(playerId, mailId)
    }
}