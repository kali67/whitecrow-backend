package whitecrow.service.interfaces

import java.io.Serializable

interface IDataService<T, ID : Serializable> {

    fun update(obj: T)

    fun findOne(id: ID): T

    fun save(persisted: T)
}