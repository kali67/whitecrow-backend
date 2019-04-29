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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "player_id")
    var player: Player,

    @Column(name = "amount")
    var amount: Int,

    @Column(name = "payback_rate")
    var paybackRate: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "flow_type")
    var flowType: FlowType
)