package whitecrow.service.interfaces

import whitecrow.model.Card

interface IMailCardService {

    fun findCardHand(): Card

    fun findById(id: Int): Card

    fun addMailCard(playerId: Int, cardId: Int)
}