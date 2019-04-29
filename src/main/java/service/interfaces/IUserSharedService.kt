package whitecrow.service.interfaces

import org.springframework.security.core.userdetails.UserDetailsService
import whitecrow.model.User

interface IUserSharedService : UserDetailsService {

    fun currentUser(): User

    fun update(user: User)

}