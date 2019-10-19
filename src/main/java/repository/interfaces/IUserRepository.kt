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

    fun update(user: User)
}