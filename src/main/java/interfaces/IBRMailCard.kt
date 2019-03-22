package whitecrow.interfaces

import whitecrow.static_objects.MailCard

interface IBRMailCard : IBRYamlMapper<List<MailCard>> {

    fun pickCards() : List<MailCard>
}
