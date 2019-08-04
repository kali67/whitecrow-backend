package whitecrow.model

import org.hibernate.*
import org.hibernate.annotations.*
import org.hibernate.annotations.FetchMode
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table

enum class TurnType {
    NORMAL,
    SETBACK
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

    @ManyToOne
    var game: Game? = null

    @Column(name = "money")
    var money: Float = 1000.0f

    @Column(name = "current_day")
    var currentDay: Int = 0

    @Column(name = "play_order")
    var playOrder: Int = -1

    @Column(name = "cost_reduced_since")
    var costReducedSince: Int = -1

    @Column(name = "final_score")
    var finalScore: Float = 0f

    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    var cards: MutableList<Card> = mutableListOf()

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "player")
    var flow: MutableList<Flow> = mutableListOf()

    @Enumerated(EnumType.STRING)
    @Column(name = "turn_type")
    var turnType: TurnType = TurnType.NORMAL

    @Column(name = "set_back_steps")
    var setBackSteps: Int = 0
}