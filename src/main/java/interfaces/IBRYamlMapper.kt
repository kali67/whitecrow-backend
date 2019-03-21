package whitecrow.interfaces

interface IBRYamlMapper<T> {

    fun parseStaticYamlObjects(): Map<*, *>

    fun mapToLocalisedObject(yamlMap: Map<*, *>) : T

}