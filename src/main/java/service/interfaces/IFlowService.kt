package whitecrow.service.interfaces

import whitecrow.model.Card
import whitecrow.model.Player

interface IFlowService {

    fun createOpportunityInvestment(player: Player, card: Card)

}