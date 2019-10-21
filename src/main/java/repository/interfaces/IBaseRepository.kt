package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.io.Serializable

@NoRepositoryBean // This ensures that Spring Data JPA doesn’t try to save an implementation for our base repository interface.
interface IBaseRepository<T, ID : Serializable> : Repository<T, ID> {

    /**
     * Finds an object of type [T] within persistence implementation
     *
     * @param id id of object to find
     * @return object of type [T] from persistence
     */
    fun findOne(id: ID): T

    /**
     * Saves an object of type [T] to the persistence implementation
     *
     * @param persisted object to save
     * @return saved object
     */
    fun save(persisted: T): T
}