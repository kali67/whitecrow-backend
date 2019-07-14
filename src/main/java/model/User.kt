package whitecrow.model

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id: Int,

    @Column(name = "username")
    var userName: String,

    @Column(name = "password")
    var password: String
) {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = [CascadeType.ALL])
    var players: MutableList<Player> = mutableListOf()
}
