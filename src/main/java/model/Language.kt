package whitecrow.model

import javax.persistence.*

@Entity
@Table(name = "lang")
data class Language(
    @Column(name = "code")
    var code: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}