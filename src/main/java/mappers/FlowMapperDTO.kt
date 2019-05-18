package whitecrow.mappers

import whitecrow.dto.FlowDTO
import whitecrow.model.Flow

class FlowMapperDTO : IMapper<Flow, FlowDTO> {

    override fun from(from: FlowDTO): Flow {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun to(from: Flow): FlowDTO {
        return FlowDTO(from.id, from.amount, from.flowType, from.paybackRate)
    }
}