package whitecrow.model

import javax.persistence.*

enum class GameState {
    IN_PROGRESS,
    AWAITING_PLAYERS,
    COMPLETED
}

enum class GameType {
    SINGLEPLAYER,
    MULTIPLAYER
}

@Entity
@Table(name = "game")
class Game(

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    var type: GameType,

    @Column(name = "number_rounds")
    var numberRounds: Int,

    @Column(name = "max_players")
    var maxPlayers: Int,

    @ManyToMany(cascade = [CascadeType.MERGE], fetch = FetchType.EAGER)
    var player: MutableSet<Player> = mutableSetOf(),

    @Column(name = "current_day")
    var currentDay: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    var state: GameState = GameState.AWAITING_PLAYERS


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "next", referencedColumnName = "player_id")
    var next: Player? = null
}