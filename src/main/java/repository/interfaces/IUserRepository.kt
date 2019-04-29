package whitecrow.repository.interfaces

import org.springframework.data.repository.NoRepositoryBean
import whitecrow.model.User

@NoRepositoryBean
interface IUserRepository : IBaseRepository<User, Int> {

    fun findByUserName(username: String): User?

    fun update(user: User)
}