package whitecrow.model

import javax.persistence.*

enum class FlowType {
    LOAN,
    INVESTMENT
}

@Entity
class Cashflow(
    @Id
    @GeneratedValue
    var id: Int,

    @ManyToOne
    var projectManager: ProjectManager,

    @Column(name = "amount")
    var amount: Int,

    @Column(name = "rate")
    var rate: Double,

    @Column(name = "flow_type")
    @Enumerated(EnumType.STRING)
    var flowType: FlowType
)