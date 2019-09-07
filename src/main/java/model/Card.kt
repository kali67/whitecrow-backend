package whitecrow.model

import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*

enum class CardType {
    MAIL,
    OPPORTUNITY
}

enum class FlowDirection {
    OUT,
    IN,
    ALL_IN,
    ALL_OUT
}


@Entity
@Table(name = "card")
class Card(

    @EmbeddedId
    var id: CardId,

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    var cardType: CardType,

    @Column(name = "title")
    var title: String,

    @Column(name = "color")
    var color: String,

    @Column(name = "category_description")
    var categoryDescription: String,

    @Column(name = "action")
    var action: String,

    @Column(name = "sub_title")
    var subTitle: String,

    @Column(name = "description", length = 1024)
    var description: String,

    @Column(name = "cost")
    var cost: Float,

    @Column(name = "flow_direction")
    @Enumerated(EnumType.STRING)
    var flowDirection: FlowDirection
) {

    @Transient
    var cardCategory: List<CardCategory>? = null
}

@Embeddable
class CardId(val cardId: Int, val langId: Int) : Serializable
