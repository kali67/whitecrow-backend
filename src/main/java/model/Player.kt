package whitecrow.model

import javax.persistence.*


@Entity
@Table(name = "Player")
class Player(
    @Id
    @Column(name = "id")
    private val id : Int,
    @Column(name = "username")
    private val userName: String)