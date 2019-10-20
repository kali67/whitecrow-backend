package whitecrow.service.tile

import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import whitecrow.model.Player
import whitecrow.model.TileType
import org.springframework.beans.factory.annotation.Autowired

@Service
class TileServiceFactory {

    @Autowired
    private lateinit var appContext: ApplicationContext

    /**
     * Factory pattern to construct correct tile service based on
     * the type of tile that has been landed on.
     * @param player player to build service tile for
     * @param tileType type of tile the player has landed on and the
     * type of tile service to be created.
     */
    fun invoke(player: Player, tileType: TileType): TileServiceBase {
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
                return appContext.getBean(WhitecrowTileService::class.java)
            }
        }
        return appContext.getBean(OtherTileService::class.java)
    }
}