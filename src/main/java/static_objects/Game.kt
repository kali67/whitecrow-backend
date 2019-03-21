package whitecrow.static_objects

data class GameBoard constructor(
    var title: String,
    var description: String,
    var days: List<String>,
    var tiles: List<BoardTile>
)

data class BoardTile(
    var date: Int, var title: String,
    var description: String,
    var action: String,
    var color: String,
    var dateColor: String,
    var dateTextColor: String,
    var descriptionColor: String
)
