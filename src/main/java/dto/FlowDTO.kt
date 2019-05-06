package whitecrow.dto

import whitecrow.model.FlowType

class FlowDTO(val id: Int, val amount: Float, val flowType: FlowType, val paybackRate: Float)