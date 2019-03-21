package whitecrow.service

import org.springframework.stereotype.Service
import whitecrow.interfaces.IMailCardService
import whitecrow.static_objects.MailCard

@Service
class MailCardServiceImpl : IMailCardService {

    override fun loadHand(): List<MailCard> {
        return listOf(MailCard("test", "test", "test", "test", "test"))
    }

}