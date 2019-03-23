package whitecrow.interfaces

import java.io.Serializable

interface IDataService<T, ID : Serializable> {

    fun delete(deleted: T)

    fun findAll(): List<T>

    fun findOne(id: ID): T

    fun save(persisted: T): T

}