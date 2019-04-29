package whitecrow.model

import javax.persistence.*

enum class CardType {
    MAIL,
    OPPORTUNITY
}

@Entity
@Table(name = "card")
class Card(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @OneToOne
    @JoinColumn(name = "lang_id")
    var language: Language,

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    var cardType: CardType,

    @Column(name = "title")
    var title: String,

    @Column(name = "category")
    var category: String,

    @Column(name = "action")
    var action: String,

    @Column(name = "sub_title")
    var subTitle: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "cost")
    var cost: Float
)