package whitecrow.repository

import com.esotericsoftware.yamlbeans.YamlReader
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Repository
import whitecrow.repository.interfaces.IMailCardRepository
import whitecrow.static_objects.MailCard
import java.io.BufferedReader
import java.io.InputStreamReader

@Repository
class YAMLMailCardRepository : IMailCardRepository {

    override fun findAll(): List<MailCard> {
        val resource = ClassPathResource("mailcard-descriptor.yml").inputStream
        val reader = YamlReader(BufferedReader(InputStreamReader(resource)))
        lateinit var mailCardMap: Map<*, *>
        while (true) {
            val mailCard = reader.read() ?: break
            mailCardMap = mailCard as Map<*, *>
        }
        return (mailCardMap["cards"] as Iterable<*>).map { card ->
            card as Map<*, *>
            MailCard(
                card["category"] as String,
                card["title"] as String,
                card["action"] as String,
                card["subTitle"] as String,
                card["description"] as String
            )
        }
    }

}