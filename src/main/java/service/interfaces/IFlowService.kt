package whitecrow.service.interfaces

import whitecrow.model.Card
import whitecrow.model.Flow
import whitecrow.model.Player

interface IFlowService {

    fun createOpportunityInvestment(player: Player, card: Card)

    fun findLoans(id: Int): List<Flow>

    fun findInvestments(id: Int): List<Flow>

    fun calcFlowPayback(flow: Flow): Float
}