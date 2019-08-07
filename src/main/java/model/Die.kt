package whitecrow.model

import org.springframework.stereotype.*
import kotlin.random.*

@Component
class SixSidedDieRoller() : IRandomDieRoller {

    override val size = 6

    override fun rollDie(): Int {
        return Random.nextInt(size)
    }
}