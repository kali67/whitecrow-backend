package whitecrow.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import whitecrow.repository.interfaces.IUserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import whitecrow.exceptions.UserAlreadyExistsException
import whitecrow.service.interfaces.IUserService
import javax.transaction.Transactional

@Service
@Transactional
class UserServiceImpl @Autowired constructor(val userRepositoryImpl: IUserRepository) : IUserService {

    @Throws(UserAlreadyExistsException::class)
    override fun save(persisted: whitecrow.model.User) {
        val user = userRepositoryImpl.findByUserName(persisted.userName)
        if (user == null) {
            persisted.password = hashPassword(persisted.password!!)
            userRepositoryImpl.save(persisted)
        } else {
            throw UserAlreadyExistsException()
        }
    }

    override fun delete(deleted: whitecrow.model.User) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findAll(): List<whitecrow.model.User> {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Int): whitecrow.model.User {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    private fun hashPassword(rawPassword: String): String {
        return BCryptPasswordEncoder().encode(rawPassword)
    }
}