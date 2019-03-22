package whitecrow.business_rules

import com.esotericsoftware.yamlbeans.YamlReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import whitecrow.config.LocaleHelper
import whitecrow.interfaces.IBRMailCard
import whitecrow.static_objects.MailCard
import java.io.FileReader
import kotlin.random.Random

@Component
class BRMailCard : IBRMailCard {

    @Autowired
    lateinit var localeHelper: LocaleHelper

    override fun parseStaticYamlObjects(): Map<*, *> {
        val reader = YamlReader(FileReader(this::class.java.classLoader.getResource("mailcard-descriptor.yml").file))
        lateinit var mailCardMap: Map<*, *>
        while (true) {
            val mailCard = reader.read() ?: break
            mailCardMap = mailCard as Map<*, *>
        }
        return mailCardMap
    }

    override fun mapToLocalisedObject(yamlMap: Map<*, *>): List<MailCard> {
        return (yamlMap["cards"] as Iterable<*>).map { card ->
            card as Map<*, *>
            MailCard(
                localeHelper.translate(card["category"] as String),
                localeHelper.translate(card["title"] as String),
                localeHelper.translate(card["action"] as String),
                localeHelper.translate(card["subTitle"] as String),
                localeHelper.translate(card["description"] as String)
            )
        }
    }

    override fun pickCards(): List<MailCard> {
        val cards: List<MailCard> = mapToLocalisedObject(parseStaticYamlObjects())
        var possibleDraws: List<MailCard> = cards

        val drawnCards: MutableList<MailCard> = mutableListOf()
        for (i in 0 until 3) {
            val index = Random.nextInt(possibleDraws.size - 1)
            drawnCards.add(possibleDraws[index])
            possibleDraws = cards.filter { card ->
                !drawnCards.contains(card)
            }
        }

        return drawnCards
    }
}