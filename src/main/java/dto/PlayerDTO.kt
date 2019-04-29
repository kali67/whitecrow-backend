package whitecrow.dto

import whitecrow.model.Card
import whitecrow.model.Flow

data class PlayerDTO constructor(
    val id: Int,
    val money: Float,
    val day: Int,
    val order: Int

) {
//    lateinit var username: String
    lateinit var flows: MutableList<Flow>
    lateinit var mailCards: MutableList<Card>
    lateinit var opportunityCards: MutableList<Card>
}