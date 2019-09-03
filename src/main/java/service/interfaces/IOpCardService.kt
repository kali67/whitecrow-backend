package whitecrow.service.interfaces

import whitecrow.model.Card

interface IOpCardService {

    fun findHand(excluding: IntArray): List<Card>

    fun addOpportunityCard(playerId: Int, cardId: Int)
}