package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.config.LocaleHelper
import whitecrow.repository.interfaces.IGameBoardRepository
import whitecrow.service.interfaces.IGameBoardService
import whitecrow.static_objects.BoardTile
import whitecrow.static_objects.GameBoard

@Service
class GameBoardServiceImpl @Autowired constructor(private val gameBoardRepository: IGameBoardRepository) :
    IGameBoardService {

    @Autowired
    private lateinit var localeHelper: LocaleHelper

    override fun load(): GameBoard {
        val gameBoard = gameBoardRepository.find()
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

    override fun findTileByDate(date: Int): BoardTile {
        val gameBoard = gameBoardRepository.find()
        return gameBoard.tiles.first { date == it.date }
    }

    companion object {
        const val NUMBER_DIE = 6
        const val NUMBER_DAYS_MONTH = 31
    }
}