package whitecrow.business_rules

import com.esotericsoftware.yamlbeans.YamlReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import whitecrow.config.LocaleHelper
import whitecrow.interfaces.IBRBoard
import whitecrow.interfaces.IBRYamlMapper
import whitecrow.static_objects.BoardTile
import whitecrow.static_objects.GameBoard
import java.io.FileReader

@Component
class BRBoard @Autowired constructor(var localeHelper: LocaleHelper) : IBRBoard, IBRYamlMapper<GameBoard> {


    override fun parseStaticYamlObjects(): Map<*, *> {
        val reader = YamlReader(FileReader(this::class.java.classLoader.getResource("board-descriptor.yml").file))
        lateinit var tiles: Iterable<*>
        lateinit var days: List<*>
        lateinit var boardTitle: String
        lateinit var boardDescription: String
        while (true) {
            val boardTile = reader.read() ?: break
            val boardMap = boardTile as Map<*, *>
            boardTitle = boardMap["boardTitle"] as String
            boardDescription = boardMap["boardDescription"] as String
            tiles = boardMap["tiles"] as Iterable<*>
            days = boardMap["days"] as List<*>
        }
        return mapOf(
            "boardTitle" to boardTitle,
            "boardDescription" to boardDescription,
            "tilesMap" to tiles,
            "days" to days
        )
    }

    override fun mapToLocalisedObject(yamlMap: Map<*, *>): GameBoard {
        val tiles: MutableList<BoardTile> = mutableListOf()
        (yamlMap["tilesMap"] as Iterable<*>).forEach { tile ->
            tile as Map<*, *>
            tiles.add(
                BoardTile(
                    Integer.parseInt(tile["date"] as String),
                    localeHelper.translate(tile["titleResourceString"] as String),
                    localeHelper.translate(tile["descriptionResourceString"] as String),
                    localeHelper.translate(tile["actionResourceString"] as String),
                    tile["color"] as String,
                    tile["dateColor"] as String,
                    tile["dateTextColor"] as String,
                    tile["descriptionColor"] as String
                )
            )
        }
        val localisedTitle = localeHelper.translate(yamlMap["boardTitle"] as String)
        val localisedDescription = localeHelper.translate(yamlMap["boardDescription"] as String)

        val days: List<String> = (yamlMap["days"] as Iterable<*>).map { day ->
            localeHelper.translate(day as String)
        }
        tiles.sortBy { it.date }
        return GameBoard(localisedTitle, localisedDescription, days, tiles)
    }
}