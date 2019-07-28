package whitecrow.service.interfaces

import whitecrow.dto.*
import whitecrow.model.*
import java.util.*

interface IUserService {

    fun save(persisted: User): UUID

    fun findOne(id: UUID): UserDto

    fun findByUsername(username: String): UserDto

    fun findLoggedInUser(): UserDto

    fun update(userDto: UserDto)

    fun updatePassword(password: String)
}