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

enum class DECISION {
    ACCEPTED,
    UN_DECIDED,
    DECLINED
}


class OpportunityCardResult(
    val card: Card,
    val decision: DECISION
)


class TurnResult(
    val playerId: Int,
    val mailCard: Card? = null,
    val opportunityCardResult: OpportunityCardResult? = null,
    val message: String,
    val chanceResult: ChanceResult? = null,
    val turnStage: TurnProgress
) {
    var currentDay: Int = 0
}