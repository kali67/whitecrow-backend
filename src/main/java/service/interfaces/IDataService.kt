package whitecrow.service.interfaces

import java.io.Serializable

interface IDataService<T, R, ID : Serializable> {

    fun delete(deleted: T)

    fun findAll(): List<R>

    fun findOne(id: ID): R

    fun save(persisted: T)
}