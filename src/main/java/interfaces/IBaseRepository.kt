package whitecrow.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.io.Serializable


@NoRepositoryBean // This ensures that Spring Data JPA doesn’t try to create an implementation for our base repository interface.
interface IBaseRepository<T, ID : Serializable> : Repository<T, ID> {

    fun delete(deleted: T)

    fun findAll(): List<T>

    fun findOne(id: ID): T

    fun save(persisted: T): T

}