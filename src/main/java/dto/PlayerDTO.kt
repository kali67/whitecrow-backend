package whitecrow.dto

import whitecrow.model.Card

data class PlayerDTO constructor(
    val id: Int,
    val money: Float,
    val day: Int,
    val order: Int,
    val score: Float
) {
    lateinit var username: String
    //    lateinit var flows: List<FlowDTO>
    var hasFinishedGame = false
    lateinit var mailCards: MutableList<Card>
    lateinit var opportunityCards: MutableList<Card>
}