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
        val mailGreen = "#549A8B"
        tiles.add(BoardTile(1, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#E3613A", "",""))
        tiles.add(BoardTile(3, translate("mail_title"),"",
            translate("mail_action"), mailGreen, "#D14873", "",""))
        tiles.add(BoardTile(5, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#DC402E", "",""))
        tiles.add(BoardTile(11, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#DC402E", "",""))
        tiles.add(BoardTile(16, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#FFFFFF", "",""))
        tiles.add(BoardTile(19, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#5D3172", "#FFFFFF",""))
        tiles.add(BoardTile(24, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#977F6B", "",""))
        tiles.add(BoardTile(26, translate("mail_title"), "",
            translate("mail_action"), mailGreen, "#DC402E", "#FFFFFF",""))
    }

    private fun buildOpportunityTiles(tiles: MutableList<BoardTile>) {
        val opportunityGreen = "#96B94F"
        tiles.add(BoardTile(4, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#632C7F", "#FFFFFF",""))
        tiles.add(BoardTile(9, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#D14873", "",""))
        tiles.add(BoardTile(12, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#32356F", "#FFFFFF",""))
        tiles.add(BoardTile(17, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#632C7F", "#FFFFFF",""))
        tiles.add(BoardTile(23, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#D14873", "",""))
        tiles.add(BoardTile(27, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#8E325B", "#FFFFFF",""))
        tiles.add(BoardTile(30, translate("opportunity_title"), translate("opportunity_description"),
            "", opportunityGreen, "#E6933E", "",""))
    }


    private fun buildRestDayTiles(tiles: MutableList<BoardTile>) {
        val restDayBlue = "#69A0CB"
        tiles.add(BoardTile(7, translate("restday_title"), "",
            "", restDayBlue, "#E3613A", "",""))
        tiles.add(BoardTile(14, translate("restday_title"), "",
            "", restDayBlue, "#F2F1E7", "",""))
        tiles.add(BoardTile(21, translate("restday_title"), "",
            "", restDayBlue, "#32356F", "#FFFFFF",""))
        tiles.add(BoardTile(28, translate("restday_title"),"",
            "", restDayBlue, "#F2F1E7", "",""))
    }

    private fun buildExpenseTiles(tiles: MutableList<BoardTile>) {
        val expenseOrange = "#E69043"
        tiles.add(BoardTile(6, translate("expense_title"), translate("expense_description_6"),
            translate("expense_action_6"), expenseOrange, "#32356F", "#FFFFFF",""))
        tiles.add(BoardTile(13, translate("expense_title"), translate("expense_description_13"),
            translate("expense_action_13"), expenseOrange, "#8E325B", "#FFFFFF",""))
        tiles.add(BoardTile(18, translate("expense_title"), translate("expense_description_18"),
            translate("expense_action_18"), expenseOrange, "#DC402E", "",""))
        tiles.add(BoardTile(22, translate("expense_title"), translate("expense_description_22"),
            translate("expense_action_22"), expenseOrange, "#F2EB67", "",""))
    }

    private fun buildBonusTiles(tiles: MutableList<BoardTile>) {
        val bonusPurple = "#612E73"
        tiles.add(BoardTile(2, translate("bonus_title"), translate("bonus_description_2"),
            translate("bonus_action_2"), bonusPurple, "#F2EB67", "",""))
        tiles.add(BoardTile(8, translate("bonus_title"), translate("bonus_description_8"),
            translate("bonus_action_8"), bonusPurple, "#F2EB67", "",""))
        tiles.add(BoardTile(15, translate("bonus_title"), translate("bonus_description_15"),
            translate("bonus_action_15"), bonusPurple, "#99BB52", "",""))
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