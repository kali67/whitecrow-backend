package whitecrow.model

import javax.persistence.*

enum class GameState {
    IN_PROGRESS,
    AWAITING_PLAYERS,
    COMPLETED
}

@Entity
class Game(

    @Id
    @GeneratedValue
    var id: Int,

    @Column(name = "number_rounds")
    var numberRounds: Int,

    @Column(name = "current_day")
    var currentDay: Int,

    @ManyToMany
    var managers: MutableSet<ProjectManager>,

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    var state: GameState
)
