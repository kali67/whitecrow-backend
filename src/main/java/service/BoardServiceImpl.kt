package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.interfaces.IBRBoard
import whitecrow.interfaces.IBoardService
import whitecrow.static_objects.GameBoard

@Service
class BoardServiceImpl @Autowired constructor(private val brBoard: IBRBoard) : IBoardService {

    override fun load(): GameBoard {
        val boardMap = brBoard.parseStaticYamlObjects()
        return brBoard.mapToLocalisedObject(boardMap)
    }
}