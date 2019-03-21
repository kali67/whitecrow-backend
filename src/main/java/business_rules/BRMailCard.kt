package whitecrow.business_rules

import whitecrow.interfaces.IBRYamlMapper
import whitecrow.static_objects.MailCard

class BRMailCard : IBRYamlMapper<List<MailCard>> {

    override fun parseStaticYamlObjects(): Map<*, *> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapToLocalisedObject(yamlMap: Map<*, *>): List<MailCard> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}