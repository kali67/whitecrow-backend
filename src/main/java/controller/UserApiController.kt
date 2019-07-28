package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.dto.*
import whitecrow.model.User
import whitecrow.service.interfaces.IUserService
import java.util.*

@RestController
@ControllerAdvice
class UserApiController @Autowired constructor(val userServiceImpl: IUserService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/user/create")
    fun create(@RequestBody user: User): UUID {
        return userServiceImpl.save(user)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PutMapping("/user")
    fun update(@RequestBody user: UserDto) {
        return userServiceImpl.update(user)
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @GetMapping("/user")
    fun findUserDetailsByLoggedInUser(): UserDto {
        return userServiceImpl.findLoggedInUser()
    }

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PutMapping("/user/password")
    fun updatePassword(@RequestBody password: String) {
        userServiceImpl.updatePassword(password)
    }
}