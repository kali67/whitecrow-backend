package whitecrow.model

interface IRandomDieRoller {

    val size: Int

    fun rollDie(): Int

}