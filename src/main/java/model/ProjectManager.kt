package whitecrow.model

import javax.persistence.*


enum class BankingStrategy {
    DEPOSIT,
    LOAN
}


@Entity
@Table(name = "project_manager")
class ProjectManager(
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id : Int,

    @Column(name = "username")
    var userName: String,

    @Column(name = "budget")
    var budget: Double
)
{
    @Column(name = "banking_strategy")
    @Enumerated(EnumType.STRING)
    lateinit var bankingStrategy: BankingStrategy
}