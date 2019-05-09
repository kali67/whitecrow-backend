package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.Flow
import whitecrow.model.FlowType

@NoRepositoryBean
interface IFlowRepository : IBaseRepository<Flow, Int> {

    fun findByFlowType(type: FlowType): List<Flow>
}