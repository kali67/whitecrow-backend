package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.Card
import whitecrow.service.interfaces.IMailCardService

@RestController
@CrossOrigin
class MailCardApiController @Autowired constructor(val mailCardService: IMailCardService) {

    @PostMapping("/game/{id}/mail/card/draw")
    fun draw(@PathVariable id: Int): Card {
        return mailCardService.findCardHand()
    }

    @PostMapping("/player/{playerId}/add/mail/{mailId}")
    fun addMailCard(@PathVariable playerId: Int, @PathVariable mailId: Int) {
        mailCardService.addMailCard(playerId, mailId)
    }
}