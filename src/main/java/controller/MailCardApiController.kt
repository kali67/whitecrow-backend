package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import whitecrow.service.interfaces.IMailCardService
import whitecrow.static_objects.MailCard

@RestController
class MailCardApiController @Autowired constructor(val mailCardService: IMailCardService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/cards/mail")
    fun listMailCards(@RequestParam(name = "count", defaultValue = "3") count: Int) : List<MailCard> {
        return mailCardService.findCardHand()
    }
}