package whitecrow.repository

import com.esotericsoftware.yamlbeans.YamlReader
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Repository
import whitecrow.repository.interfaces.IGameBoardRepository
import whitecrow.static_objects.BoardTile
import whitecrow.static_objects.GameBoard
import whitecrow.static_objects.TileType
import java.io.BufferedReader
import java.io.InputStreamReader

@Repository
class YAMLGameBoardRepository : IGameBoardRepository {

    override fun find(): GameBoard {
        val resource = ClassPathResource("board-descriptor.yml").inputStream
        val reader = YamlReader(BufferedReader(InputStreamReader(resource)))

        lateinit var tiles: Iterable<*>
        lateinit var days: List<String>
        lateinit var boardTitle: String
        lateinit var boardDescription: String
        while (true) {
            val boardTile = reader.read() ?: break
            val boardMap = boardTile as Map<*, *>
            boardTitle = boardMap["boardTitle"] as String
            boardDescription = boardMap["boardDescription"] as String
            tiles = boardMap["tiles"] as Iterable<*>
            days = (boardMap["days"] as List<*>).map { it as String }
        }

        tiles = tiles.map { tile ->
            tile as Map<*, *>
            BoardTile(
                Integer.parseInt(tile["date"] as String),
                TileType.valueOf(tile["type"] as String),
                (tile["cost"] as String).toFloat(),
                tile["titleResourceString"] as String,
                tile["descriptionResourceString"] as String,
                tile["actionResourceString"] as String,
                tile["color"] as String,
                tile["dateColor"] as String,
                tile["dateTextColor"] as String,
                tile["descriptionColor"] as String
            )
        }.sortedBy { it.date }
        return GameBoard(boardTitle, boardDescription, days, tiles)
    }
}