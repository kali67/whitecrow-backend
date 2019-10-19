package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.*
import whitecrow.model.*
import whitecrow.service.interfaces.IUserService
import java.util.*

@RestController
@CrossOrigin
@ControllerAdvice
class UserApiController @Autowired constructor(val userServiceImpl: IUserService) {

    @PostMapping("/user/create")
    fun create(@RequestBody user: User): UUID {
        return userServiceImpl.save(user)
    }

    @PutMapping("/user")
    fun update(@RequestBody user: UserDto) {
        return userServiceImpl.update(user)
    }

    @GetMapping("/user")
    fun findUserDetailsByLoggedInUser(): UserDto {
        return userServiceImpl.findLoggedInUser()
    }

    @PutMapping("/user/password")
    fun updatePassword(@RequestBody password: String) {
        userServiceImpl.updatePassword(password)
    }

    @PutMapping("/user/pretest")
    fun updatePreTestStatus() {
//        userServiceImpl.updatePreTestStatus()
    }

}