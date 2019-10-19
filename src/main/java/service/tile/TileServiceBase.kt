package whitecrow.service.tile

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.*
import whitecrow.service.interfaces.*

@Service
abstract class TileServiceBase {

    @Autowired
    protected lateinit var gameSharedServiceImpl: GameSharedServiceImpl

    @Autowired
    protected lateinit var gameRepository: IGameRepository


    /**
     * Updates a players attributes from the actions to be taken
     * on the tile that has been landed on
     *
     * To be overridden by any extending class, see [whitecrow.service.tile.MailTileService]
     * for an example of how this method works.
     *
     * @param player player to apply action from tile to
     * @param game current game for the player
     * @param tile board tile the player has landed on
     */
    abstract fun applyTileAction(player: Player, game: Game, tile: BoardTile?): TurnResult
}