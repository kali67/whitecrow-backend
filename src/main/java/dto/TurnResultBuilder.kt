package whitecrow.dto

import whitecrow.model.*

/**
 * Builder class for [TurnResult].
 * This should be used when creating a TurnResult as it
 * simplifies object creation from a clients point of view
 *
 * @param playerId id of player to build result around
 * @param currentDay current day of player
 */
class TurnResultBuilder(playerId: Int, currentDay: Int) {

    private val turnResult = TurnResult()

    init {
        this.turnResult.playerId = playerId
        this.turnResult.currentDay = currentDay
    }

    fun build(): TurnResult {
        return this.turnResult
    }

    fun setMailCard(card: Card): TurnResultBuilder {
        this.turnResult.mailCard = card
        return this
    }

    fun setOpportunityCardResult(opportunityCardResult: OpportunityCardResult): TurnResultBuilder {
        this.turnResult.opportunityCardResult = opportunityCardResult
        return this
    }

    fun setMessage(message: String): TurnResultBuilder {
        this.turnResult.message = message
        return this
    }

    fun setCardCancelled(cardCancelled: Boolean): TurnResultBuilder {
        this.turnResult.cardCancelled = cardCancelled
        return this
    }

    fun setTurnStage(turnStage: TurnProgress): TurnResultBuilder {
        this.turnResult.turnStage = turnStage
        return this
    }

    fun setHasFinishedGame(hasFinishedGame: Boolean): TurnResultBuilder {
        this.turnResult.hasFinishedGame = hasFinishedGame
        return this
    }

    fun setMoneyDifference(moneyDifference: Float): TurnResultBuilder {
        this.turnResult.moneyDifference = moneyDifference
        return this
    }

    fun setHasTriggeredSetBack(hasTriggeredSetBack: Boolean): TurnResultBuilder {
        this.turnResult.hasTriggeredSetBack = hasTriggeredSetBack
        return this
    }

    fun setTurnResult(turnResult: TurnResult): TurnResultBuilder {
        this.turnResult.turnResult = turnResult
        return this
    }

}
