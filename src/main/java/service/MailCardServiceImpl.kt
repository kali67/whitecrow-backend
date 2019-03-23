package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.config.LocaleHelper
import whitecrow.interfaces.IMailCardRepository
import whitecrow.interfaces.IMailCardService
import whitecrow.static_objects.MailCard
import kotlin.random.Random

@Service
class MailCardServiceImpl @Autowired constructor(private val mailCardRepository: IMailCardRepository): IMailCardService {


    @Autowired
    private lateinit var localeHelper: LocaleHelper

    override fun findCardHand(): List<MailCard> {
        val cards = mailCardRepository.findAll()
        val handSelection = pickCards(cards)
        return  handSelection.map {
            it.action = localeHelper.translate(it.action)
            it.title = localeHelper.translate(it.title)
            it.category = localeHelper.translate(it.category)
            it.description = localeHelper.translate(it.description)
            it.subTitle = localeHelper.translate(it.subTitle)
            it
        }
    }

    fun pickCards(selection: List<MailCard>): List<MailCard> {
        var possibleDraws: List<MailCard> = selection

        val drawnCards: MutableList<MailCard> = mutableListOf()
        for (i in 0 until 3) {
            val index = Random.nextInt(possibleDraws.size - 1)
            drawnCards.add(possibleDraws[index])
            possibleDraws = selection.filter { card ->
                !drawnCards.contains(card)
            }
        }
        return drawnCards
    }
}