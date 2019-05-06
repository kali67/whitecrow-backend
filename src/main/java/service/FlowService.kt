package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.model.Card
import whitecrow.model.Flow
import whitecrow.model.FlowType
import whitecrow.model.Player
import whitecrow.repository.interfaces.IFlowRepository
import whitecrow.service.interfaces.IFlowService
import javax.transaction.Transactional

@Service
@Transactional
class FlowService @Autowired constructor(private val flowRepositoryImpl: IFlowRepository) : IFlowService {

    override fun createOpportunityInvestment(player: Player, card: Card) {
        val flow = Flow(player = player, amount = card.cost, paybackRate = 12f, flowType = FlowType.INVESTMENT)
        player.flow.add(flow)
        flowRepositoryImpl.save(flow)
    }
}