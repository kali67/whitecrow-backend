package whitecrow.dto

import whitecrow.model.Card

enum class TurnProgress {
    COMPLETED,
    COMPLETED_WITH_ROLLS,
    DECISION_PENDING
}

class ChanceResult(
    winner: String, //username
    dieRolls: Map<String, Int> //username, die number
)

class TurnResult( //TODO: lower level react component will receive this and update gamecontroller state, add animate state change method to gamecontroller
    val playerId: Int,
    val mailCard: Card? = null,
    val oppourtunityCard: Card? = null,
    val message: String,
    val chanceResult: ChanceResult? = null,
    val turnStage: TurnProgress
) {
    var currentDay: Int = 0
}