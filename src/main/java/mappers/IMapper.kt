package whitecrow.mappers

interface IMapper<T, R> {

    fun to(from: T): R

    fun from(from: R): T
}