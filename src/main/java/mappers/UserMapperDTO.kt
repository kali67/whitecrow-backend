package whitecrow.mappers

import org.springframework.stereotype.*
import whitecrow.dto.*
import whitecrow.model.*

@Component
class UserMapperDTO : IMapper<User, UserDto> {

    override fun to(from: User): UserDto {
        return UserDto(from.userName, from.language.code)
    }

    override fun from(from: UserDto): User {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}