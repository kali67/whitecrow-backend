package whitecrow.controller

import com.esotericsoftware.yamlbeans.YamlReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.FileReader





data class BoardTile(var date: Int,
                     var title: String,
                     var description: String,
                     var action: String,
                     var color: String,
                     var dateColor: String,
                     var dateTextColor: String,
                     var descriptionColor: String)


@RestController
class BoardApiController {

    @Autowired
    lateinit var messageSource: MessageSource


    @CrossOrigin(origins = ["http://localhost:3000"])
    @GetMapping("/board")
    fun getBoardTiles() : MutableList<BoardTile> {
        val reader = YamlReader(FileReader(this::class.java.classLoader.getResource("board-descriptor.yml").file))
        val tiles: MutableList<BoardTile> = mutableListOf()
        while (true) {
            val boardTile = reader.read() ?: break
            val boardMap = boardTile as Map<*, *>
            tiles.add(BoardTile(Integer.parseInt(boardMap["date"] as String),
                        translate(boardMap["titleResourceString"] as String),
                        translate(boardMap["descriptionResourceString"] as String),
                        translate(boardMap["actionResourceString"] as String),
                        (boardMap["color"] as String),
                        (boardMap["dateColor"] as String),
                        (boardMap["dateTextColor"] as String),
                        (boardMap["descriptionColor"] as String)))
        }


        tiles.sortBy { it.date }
        return tiles
    }

    private fun translate(code: String): String {
        if (code == "~") return ""
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale())
    }

}