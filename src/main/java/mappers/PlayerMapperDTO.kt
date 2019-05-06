package whitecrow.mappers

import org.springframework.stereotype.Component
import whitecrow.dto.PlayerDTO
import whitecrow.model.CardType
import whitecrow.model.Player

@Component
class PlayerMapperDTO : IMapper<Player, PlayerDTO> {

    override fun to(from: Player): PlayerDTO {
        val dto = PlayerDTO(from.id, from.money, from.currentDay, from.playOrder)
//        dto.flows = from.flow.map { FlowMapperDTO().to(it) }
        val mailCards = from.cards.filter { it.cardType == CardType.MAIL }.toMutableList()
        val opCards = from.cards.filter { it.cardType == CardType.OPPORTUNITY }.toMutableList()
        dto.mailCards = mailCards
        dto.opportunityCards = opCards
        if (from.user != null) {
            dto.username = from.user!!.userName
        } else {
            dto.username = generateRandomUsername(from.id)
        }
        return dto
    }

    private fun generateRandomUsername(id: Int): String {
        val usernameChoices = arrayOf(
            "UglyJellyfish", "CuteBanana", "ToastedBagel", "BuffPin", "FluffyTiger", "AngryWalrus", "StrongHyena",
            "CheesyPizza", "HappyDeer", "SpeedyTortoise", "SleepySloth", "JuicyMango", "FriendlyHedgehog",
            "HandsomeLion", "SugaryCoffee", "SweetPeach", "QuietBunny", "SwiftCheetah", "ChocolateCookie",
            "StealthyFox", "BreakfastBurrito", "IceCreamSundae", "", "RoseSee",
            "RunningFaith", "RunningMidnight", "ShiyaDoll"
        )
        return usernameChoices[id.rem(usernameChoices.size)]

    }

    override fun from(from: PlayerDTO): Player {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}