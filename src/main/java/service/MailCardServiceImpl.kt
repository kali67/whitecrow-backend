package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.interfaces.IBRMailCard
import whitecrow.interfaces.IMailCardService
import whitecrow.static_objects.MailCard

@Service
class MailCardServiceImpl @Autowired constructor(private val brMailCard: IBRMailCard): IMailCardService {

    override fun loadHand(): List<MailCard> {
        return brMailCard.pickCards()
    }
}