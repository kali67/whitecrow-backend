package whitecrow.service.interfaces

import whitecrow.static_objects.MailCard

interface IMailCardService {

    fun findCardHand() : List<MailCard>
}