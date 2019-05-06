package whitecrow.model

import javax.persistence.*

enum class FlowType {
    LOAN,
    INVESTMENT,
    DEPOSIT
}

@Entity
@Table(name = "flow")
class Flow(

    @ManyToOne
    var player: Player,

    @Column(name = "amount")
    var amount: Float,

    @Column(name = "payback_rate")
    var paybackRate: Float,

    @Enumerated(EnumType.STRING)
    @Column(name = "flow_type")
    var flowType: FlowType
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}