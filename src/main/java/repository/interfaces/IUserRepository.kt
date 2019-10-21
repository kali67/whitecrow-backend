package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.*
import java.util.*

@NoRepositoryBean
interface IUserRepository : IBaseRepository<User, UUID> {

    /**
     * Finds a user by a username. User names are unique so only
     * one user will match the criteria
     * @param username username of user
     * @return user object if one exists with the given username
     */
    fun findByUserName(username: String): User?

    /**
     * Updates a user object, must contain all updated parameters
     * @param user object to update to persistence
     */
    fun update(user: User)

    /**
     * Finds all users within the data source
     * @return list of users
     */
    fun findAll(): List<User>
}