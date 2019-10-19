package whitecrow.model

/**
 * Abstracted die rolling to separate object
 * as to allow for ease of mocking
 */
interface IRandomDieRoller {

    val size: Int

    /**
     * Rolls a [size] sided die.
     * @return int value of die roll
     */
    fun rollDie(): Int

}