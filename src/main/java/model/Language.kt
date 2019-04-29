package whitecrow.model

import javax.persistence.*

@Entity
@Table(name = "lang")
data class Language(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(name = "code")
    var code: String
)