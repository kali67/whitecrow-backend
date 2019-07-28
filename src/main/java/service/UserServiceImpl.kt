package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import whitecrow.dto.*
import whitecrow.exceptions.UserAlreadyExistsException
import whitecrow.mappers.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*
import whitecrow.service.interfaces.*
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class UserServiceImpl @Autowired constructor(
    val userRepositoryImpl: IUserRepository, val userSharedService: IUserSharedService, val
    languageRepositoryImpl: ILanguageRepository
) :
    IUserService {

    private val userDtoMapper = UserMapperDTO()

    @Throws(UserAlreadyExistsException::class)
    override fun save(persisted: User): UUID {
        val user = userRepositoryImpl.findByUserName(persisted.userName)
        if (user == null) {
            persisted.password = hashPassword(persisted.password)
            val persistedUser = userRepositoryImpl.save(persisted)
            return persistedUser.id
        }
        throw UserAlreadyExistsException()
    }

    override fun findOne(id: UUID): UserDto {
        val user = userRepositoryImpl.findOne(id)
        return userDtoMapper.to(user)
    }

    override fun findByUsername(username: String): UserDto {
        val user = userRepositoryImpl.findByUserName(username)!!
        return userDtoMapper.to(user)
    }

    override fun findLoggedInUser(): UserDto {
        val user = userSharedService.currentUser()
        return userDtoMapper.to(user)
    }

    override fun update(userDto: UserDto) {
        val user = userSharedService.currentUser()
        user.language = languageRepositoryImpl.findByCode(userDto.languageCode)
        user.userName = userDto.username
        userRepositoryImpl.update(user)
    }

    override fun updatePassword(password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun hashPassword(rawPassword: String): String {
        return BCryptPasswordEncoder().encode(rawPassword)
    }
}