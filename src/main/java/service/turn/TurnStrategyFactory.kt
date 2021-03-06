package whitecrow.service.turn

import org.springframework.beans.factory.annotation.*
import org.springframework.context.*
import org.springframework.stereotype.*
import whitecrow.model.*

@Component
class TurnStrategyFactory {

    @Autowired
    private lateinit var appContext: ApplicationContext

    /**
     * Creational pattern 'Factory Pattern' to create instances of type [TurnStrategy].
     * @param turnType type of turn a player is going to use.
     */
    fun buildTurnStrategy(turnType: TurnType): TurnStrategy {
        return when (turnType) {
            TurnType.NORMAL -> {
                appContext.getBean(NormalTurnStrategy::class.java)
            }
            TurnType.SETBACK -> {
                appContext.getBean(SetBackTurnStrategy::class.java)
            }
        }
    }
}