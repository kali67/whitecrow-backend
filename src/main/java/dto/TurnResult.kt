package whitecrow.dto

import whitecrow.model.Card
import java.util.*

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
    var turnResultIdentifier: UUID = UUID.randomUUID()
    var playerId: Int = 0
    var turnResult: TurnResult? = null
    var mailCard: Card? = null
    var opportunityCardResult: OpportunityCardResult? = null
    var message: String? = null
    var turnStage: TurnProgress? = null
    var hasFinishedGame: Boolean = false
    var moneyDifference: Float = 0f
    var hasTriggeredSetBack: Boolean = false
    var currentDay: Int = 0
    var cardCancelled: Boolean = false


    fun findLastTurnResult(): TurnResult {
        turnResult?.let {
            return it.findLastTurnResult()
        }
        return this
    }

    override fun toString(): String {
        return String.format("Turnresult: %s, %s %s %s", this.turnResult, opportunityCardResult, currentDay, hasFinishedGame)
    }
}
