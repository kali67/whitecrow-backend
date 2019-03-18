package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController



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
        val tiles = buildTileObjects()
        tiles.sortBy { it.date }
        return tiles
    }


    private fun buildMailTiles(tiles: MutableList<BoardTile>) {
        val mailTilesMap: Map<Int, Map<String, String>> = mapOf(
            1 to mapOf("dateColor" to "#E3613A", "dateTextColor" to ""),
            3 to mapOf("dateColor" to "#D14873", "dateTextColor" to ""),
            5 to mapOf("dateColor" to "#DC402E", "dateTextColor" to ""),
            11 to mapOf("dateColor" to "#DC402E", "dateTextColor" to ""),
            16 to mapOf("dateColor" to "#FFFFFF", "dateTextColor" to ""),
            19 to mapOf("dateColor" to "#5D3172", "dateTextColor" to "#FFFFFF"),
            24 to mapOf("dateColor" to "#977F6B", "dateTextColor" to ""),
            26 to mapOf("dateColor" to "#DC402E", "dateTextColor" to "#FFFFFF"))

        mailTilesMap.forEach {
            tiles.add(BoardTile(it.key, translate("mail_title"), "", translate("mail_action"),
                "#549A8B", it.value.getOrDefault("dateColor", ""),
                it.value.getOrDefault("dateTextColor", ""), ""))
        }
    }

    private fun buildOpportunityTiles(tiles: MutableList<BoardTile>) {
        val opportunityTilesMap: Map<Int, Map<String, String>> = mapOf(
            4 to mapOf("dateColor" to "#632C7F", "dateTextColor" to "#FFFFFF"),
            9 to mapOf("dateColor" to "#D14873", "dateTextColor" to ""),
            12 to mapOf("dateColor" to "#32356F", "dateTextColor" to "#FFFFFF"),
            17 to mapOf("dateColor" to "#632C7F", "dateTextColor" to "#FFFFFF"),
            23 to mapOf("dateColor" to "#D14873", "dateTextColor" to ""),
            27 to mapOf("dateColor" to "#8E325B", "dateTextColor" to "#FFFFFF"),
            30 to mapOf("dateColor" to "#E6933E", "dateTextColor" to ""))

        opportunityTilesMap.forEach {
           tiles.add(BoardTile(it.key, translate("opportunity_title"), translate("opportunity_description"),
               "", "#96B94F", it.value.getOrDefault("dateColor", ""),
               it.value.getOrDefault("dateTextColor", ""),""))
        }
    }


    private fun buildRestDayTiles(tiles: MutableList<BoardTile>) {
        val restDayTileMap: Map<Int, Map<String, String>> = mapOf(
            7 to mapOf("dateColor" to "#E3613A", "dateTextColor" to ""),
            14 to mapOf("dateColor" to "#F2F1E7", "dateTextColor" to ""),
            21 to mapOf("dateColor" to "#32356F", "dateTextColor" to "#FFFFFF"),
            28 to mapOf("dateColor" to "#F2F1E7", "dateTextColor" to ""))

        restDayTileMap.forEach {
            tiles.add(BoardTile(it.key, translate("restday_title"), "",
                "", "#69A0CB", it.value.getOrDefault("dateColor", ""),
                it.value.getOrDefault("dateTextColor", ""),""))
        }
    }

    private fun buildExpenseTiles(tiles: MutableList<BoardTile>) {
        tiles.add(BoardTile(6, translate("expense_title"), translate("expense_description_6"),
            translate("expense_action_6"), "#E69043", "#32356F", "#FFFFFF",""))
        tiles.add(BoardTile(13, translate("expense_title"), translate("expense_description_13"),
            translate("expense_action_13"), "#E69043", "#8E325B", "#FFFFFF",""))
        tiles.add(BoardTile(18, translate("expense_title"), translate("expense_description_18"),
            translate("expense_action_18"), "#E69043", "#DC402E", "",""))
        tiles.add(BoardTile(22, translate("expense_title"), translate("expense_description_22"),
            translate("expense_action_22"), "#E69043", "#F2EB67", "",""))
    }

    private fun buildBonusTiles(tiles: MutableList<BoardTile>) {
        tiles.add(BoardTile(2, translate("bonus_title"), translate("bonus_description_2"),
            translate("bonus_action_2"), "#612E73", "#F2EB67", "",""))
        tiles.add(BoardTile(8, translate("bonus_title"), translate("bonus_description_8"),
            translate("bonus_action_8"), "#612E73", "#F2EB67", "",""))
        tiles.add(BoardTile(15, translate("bonus_title"), translate("bonus_description_15"),
            translate("bonus_action_15"), "#612E73", "#99BB52", "",""))
    }

    private fun buildTileObjects() : MutableList<BoardTile>{
        val tiles: MutableList<BoardTile> = mutableListOf()
        tiles.add(BoardTile(0, translate("start_title"), "",
            "", "#181517", "", "",""))
        buildMailTiles(tiles)
        buildOpportunityTiles(tiles)
        buildExpenseTiles(tiles)
        buildBonusTiles(tiles)
        buildRestDayTiles(tiles)
        tiles.add(BoardTile(10, translate("gamble_title"), translate("gamble_description"),
            translate("gamble_action"), "#D63D82", "#632C7F", "#FFFFFF",""))
        tiles.add(BoardTile(20, translate("change_title"), translate("change_description"),
            "", "#D63D82", "#F2EB67", "",""))
        tiles.add(BoardTile(25, translate("ceo_title"), translate("ceo_description"),
            translate("ceo_action"), "#D63D82", "#F0A45A", "",""))
        tiles.add(BoardTile(29, "", translate("suitcase_description"),
            "", "#F8DA56", "#5D3172", "#FFFFFF","#000000"))
        tiles.add(BoardTile(31, "", translate("whitecrow_description"), translate("whitecrow_action"),
            "#181517", "#632C7F", "#FFFFFF",""))
        tiles.add(BoardTile(32, "", "", "", "#c1bdbd", "", "#c1bdbd",""))
        tiles.add(BoardTile(33, "", translate("moneypot_description"),
            translate("moneypot_action"), "#A53B37", "", "#A53B37",""))
        tiles.add(BoardTile(34, "", "", "", "#A53B37", "", "#A53B37",""))
        return tiles
    }

    private fun translate(code: String): String {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale())
    }

}