package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.User
import java.util.*

@NoRepositoryBean
interface IUserRepository : IBaseRepository<User, UUID> {

    fun findByUserName(username: String): User?

    fun update(user: User)
}