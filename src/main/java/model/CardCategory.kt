package whitecrow.model

import javax.persistence.*


enum class CardCategoryEnum {
    PEOPLE_ORGANISATION,
    PEOPLE_COLLABORATION,
    PEOPLE_COMMUNICATION,
    PEOPLE_ENVIRONMENT,
    PRODUCT_FUNCTIONALITY,
    PRODUCT_USABILITY,
    PRODUCT_EFFICIENCY,
    PRODUCT_MAINTAINABILITY,
    PRODUCT_PORTABILITY,
    PRODUCT_COMPATIBILITY,
    PRODUCT_SECURITY,
    PRODUCT_RELIABILITY,
    PROCESS_PLANNING,
    PROCESS_REQUIREMENTS,
    PROCESS_DESIGN,
    PROCESS_CONSTRUCTION,
    PROCESS_INTEGRATION,
    PROCESS_TESTING,
    PROCESS_MONITORING,
    PROCESS_CLOSURE,
}


@Entity
@Table(name="card_category")
class CardCategory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @Column(name = "card_id")
    var cardId: Int,

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    var category: CardCategoryEnum
)