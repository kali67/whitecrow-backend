package whitecrow.model

import javax.persistence.*


enum class LanguageCode {
    EN,
    ES
}


@Entity
@Table(name = "lang")
data class Language(

    @Column(name = "code")
    @Enumerated(EnumType.STRING)
    var code: LanguageCode
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
}