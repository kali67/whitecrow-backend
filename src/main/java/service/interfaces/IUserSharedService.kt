package whitecrow.service.interfaces

import org.springframework.security.core.userdetails.*
import whitecrow.authentication.*
import whitecrow.model.User
import java.util.*

interface IUserSharedService : UserDetailsService {

    fun currentUser(): User

    fun update(user: User)

    fun loadUserByUUID(uuid: UUID): UserDetails

    fun loadUserDetByUsername(username: String): User
}