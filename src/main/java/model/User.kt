package whitecrow.model

import org.hibernate.annotations.*
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false, nullable = false)
    var id: UUID,

    @Column(name = "username")
    var userName: String,

    @Column(name = "password")
    var password: String,

    @ManyToOne
    var language: Language
) {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = [CascadeType.ALL])
    var players: MutableList<Player> = mutableListOf()
}
