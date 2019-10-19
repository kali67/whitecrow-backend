package whitecrow.model

enum class TileType(value: String) {
    MAIL("MAIL"),
    END_GAME("END_GAME"),
    OPPORTUNITY("OPPORTUNITY"),
    EXPENSE("EXPENSE"),
    BONUS("BONUS"),
    SET_BACK("SET_BACK"),
    GAMBLE("GAMBLE"),
    COST_REDUCTION("COST_REDUCTION"),
    OTHER("OTHER")
}

data class GameBoard constructor(
    var title: String,
    var description: String,
    var days: List<String>,
    var tiles: List<BoardTile>
)

data class BoardTile(
    var date: Int,
    var type: TileType,
    var cost: Float,
    var title: String,
    var description: String,
    var action: String,
    var color: String,
    var dateColor: String,
    var dateTextColor: String,
    var descriptionColor: String
)
