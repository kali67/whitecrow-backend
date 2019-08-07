package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.*

@NoRepositoryBean
interface IFlowRepository : IBaseRepository<Flow, Int> {

}