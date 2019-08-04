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

    @OneToMany(mappedBy = "game", cascade = [CascadeType.REMOVE], fetch = FetchType.EAGER, orphanRemoval = true)
    var player: MutableSet<Player> = mutableSetOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "next", referencedColumnName = "player_id")
    var next: Player? = null

    @OneToOne
    @JoinColumn(name = "winner", referencedColumnName = "player_id")
    var winner: Player? = null
}