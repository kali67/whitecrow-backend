package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.Card
import whitecrow.service.interfaces.IMailCardService

@RestController
class MailCardApiController @Autowired constructor(val mailCardService: IMailCardService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/game/{id}/mail/card/draw")
    fun draw(@PathVariable id: Int): Card {
        return mailCardService.findCardHand()
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/player/{playerId}/add/mail/{mailId}")
    fun addMailCard(@PathVariable playerId: Int, @PathVariable mailId: Int) {
        mailCardService.addMailCard(playerId, mailId)
    }
}