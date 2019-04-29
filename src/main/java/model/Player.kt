package whitecrow.model

import javax.persistence.*

enum class BankingStrategy {
    DEPOSIT,
    LOAN
}

@Entity
@Table(name = "player")
data class Player(
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "user_id")
    var user: User? = null
) {

    @Column(name = "money")
    var money: Float = 1000.0f

    @Column(name = "current_day")
    var currentDay: Int = 0

    @Column(name = "play_order")
    var playOrder: Int = -1

    @Column(name = "cost_reduced_since")
    var costReducedSince: Int = -1

    @ManyToMany
    var cards: MutableList<Card> = mutableListOf()

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
    var flow: MutableList<Flow> = mutableListOf()
}