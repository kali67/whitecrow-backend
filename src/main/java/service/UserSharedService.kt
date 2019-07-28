package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import whitecrow.authentication.*
import whitecrow.facade.IAuthenticationFacade
import whitecrow.repository.interfaces.IUserRepository
import whitecrow.service.interfaces.IUserSharedService
import java.util.*
import javax.persistence.NoResultException
import javax.transaction.Transactional

@Service
@Transactional
class UserSharedService @Autowired constructor(private val userRepositoryImpl: IUserRepository) : IUserSharedService {

    @Autowired
    lateinit var authenticationFacadeImpl: IAuthenticationFacade

    override fun update(user: whitecrow.model.User) {
        userRepositoryImpl.update(user)
    }

    override fun currentUser(): whitecrow.model.User {
        val userDetails = authenticationFacadeImpl.authentication().name
        return userRepositoryImpl.findByUserName(userDetails) ?: throw NoResultException() // todo
    }

    override fun loadUserDetByUsername(username: String): whitecrow.model.User {
        val user = userRepositoryImpl.findByUserName(username)
        return user!!
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepositoryImpl.findByUserName(username)
        user?.let {
            val authorities = Arrays.asList(SimpleGrantedAuthority("user"))
            return User(it.userName, it.password, authorities)
        }
        throw UsernameNotFoundException("User is not found")
    }

    override fun loadUserByUUID(uuid: UUID): UserDetails {
        val user = userRepositoryImpl.findOne(uuid)
        val authorities = Arrays.asList(SimpleGrantedAuthority("user"))
        return User(user.userName, user.password, authorities)
    }


}