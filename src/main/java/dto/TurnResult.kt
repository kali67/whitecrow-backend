package whitecrow.dto

import whitecrow.model.Card

enum class TurnProgress {
    COMPLETED,
    COMPLETED_WITH_ROLLS,
    DECISION_PENDING
}

enum class DECISION {
    ACCEPTED,
    UN_DECIDED,
    DECLINED
}

class OpportunityCardResult(
    val card: Card,
    val decision: DECISION
)

class TurnResult {
    var playerId: Int = 0
    var mailCard: Card? = null
    var opportunityCardResult: OpportunityCardResult? = null
    var message: String? = null
    var turnStage: TurnProgress? = null
    var hasFinishedGame: Boolean = false
    var moneyDifference: Float = 0f
    var hasTriggeredSetBack: Boolean = false
    var currentDay: Int = 0
}
