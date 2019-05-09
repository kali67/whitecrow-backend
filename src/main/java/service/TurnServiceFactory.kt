package whitecrow.service

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import whitecrow.model.Player
import whitecrow.static_objects.TileType
import org.springframework.beans.factory.annotation.Autowired


@Service
class TurnServiceFactory {

    @Autowired
    private lateinit var appContext: ApplicationContext

    fun invoke(player: Player, tileType: TileType): PlayerTurnService {
        when {
            tileType == TileType.MAIL -> {
                return appContext.getBean(MailTileService::class.java)
            }
            tileType == TileType.EXPENSE -> {
                return appContext.getBean(ExpenseTileService::class.java)
            }
            tileType == TileType.OPPORTUNITY && player.user == null -> { // AI
                return appContext.getBean(AIOpportunityTileService::class.java)
            }
            tileType == TileType.OPPORTUNITY -> {
                return appContext.getBean(OpportunityTileService::class.java)
            }
            tileType == TileType.BONUS -> {
                return appContext.getBean(BonusTileService::class.java)
            }
            tileType == TileType.GAMBLE -> {
                return appContext.getBean(GambleTileService::class.java)
            }
            tileType == TileType.SET_BACK -> {
                return appContext.getBean(SetBackTileService::class.java)
            }
            tileType == TileType.COST_REDUCTION -> {
                return appContext.getBean(CostReductionTileService::class.java)
            }
            tileType == TileType.END_GAME -> {
                return appContext.getBean(DayWhitecrowTileService::class.java)
            }
        }
        return appContext.getBean(OtherTileService::class.java)
    }
}