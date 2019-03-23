package whitecrow.interfaces

import whitecrow.static_objects.MailCard

interface IMailCardService {

    fun findCardHand() : List<MailCard>
}