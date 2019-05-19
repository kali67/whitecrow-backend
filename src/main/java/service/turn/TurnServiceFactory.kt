package whitecrow.service

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import whitecrow.model.Player
import whitecrow.static_objects.TileType
import org.springframework.beans.factory.annotation.Autowired
import whitecrow.service.turn.*

@Service
class TurnServiceFactory {

    @Autowired
    private lateinit var appContext: ApplicationContext

    fun invoke(player: Player, tileType: TileType): TurnServiceBase {
        when {
            tileType == TileType.MAIL -> {
                return appContext.getBean(MailTurnService::class.java)
            }
            tileType == TileType.EXPENSE -> {
                return appContext.getBean(ExpenseTurnService::class.java)
            }
            tileType == TileType.OPPORTUNITY && player.user == null -> { // AI
                return appContext.getBean(AIOpportunityTurnService::class.java)
            }
            tileType == TileType.OPPORTUNITY -> {
                return appContext.getBean(OpportunityTurnService::class.java)
            }
            tileType == TileType.BONUS -> {
                return appContext.getBean(BonusTurnService::class.java)
            }
            tileType == TileType.GAMBLE -> {
                return appContext.getBean(GambleTurnSerivce::class.java)
            }
            tileType == TileType.SET_BACK -> {
                return appContext.getBean(SetBackTurnService::class.java)
            }
            tileType == TileType.COST_REDUCTION -> {
                return appContext.getBean(CostReductionTurnService::class.java)
            }
            tileType == TileType.END_GAME -> {
                return appContext.getBean(WhitecrowTurnService::class.java)
            }
        }
        return appContext.getBean(OtherTurnService::class.java)
    }
}