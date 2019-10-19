package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.config.LocaleHelper
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.repository.interfaces.IGameBoardRepository
import whitecrow.service.tile.*
import whitecrow.model.BoardTile
import whitecrow.model.GameBoard

@Service
class GameBoardServiceImpl
@Autowired
constructor(private val gameBoardRepository: IGameBoardRepository) {

    @Autowired
    private lateinit var localeHelper: LocaleHelper

    @Autowired
    lateinit var tileServiceFactory: TileServiceFactory

    /**
     * Loads game board
     */
    fun load(): GameBoard {
        val gameBoard = gameBoardRepository.load()
        gameBoard.description = localeHelper.translate(gameBoard.description)
        gameBoard.title = localeHelper.translate(gameBoard.title)
        gameBoard.days = gameBoard.days.map { localeHelper.translate(it) }
        gameBoard.tiles = gameBoard.tiles.map {
            it.action = localeHelper.translate(it.action)
            it.description = localeHelper.translate(it.description)
            it.title = localeHelper.translate(it.title)
            it
        }
        return gameBoard
    }

    fun findTileByDate(date: Int): BoardTile {
        val gameBoard = gameBoardRepository.load()
        return gameBoard.tiles.first { date == it.date }
    }

    fun applyTileActionToPlayer(player: Player, game: Game): TurnResult {
        val tile = findTileByDate(player.currentDay.rem(NUMBER_DAYS_MONTH + 1))
        val service = tileServiceFactory.invoke(player, tile.type)
        return service.applyTileAction(player, game, tile)
    }

    companion object {
        const val NUMBER_DAYS_MONTH = 31
    }
}