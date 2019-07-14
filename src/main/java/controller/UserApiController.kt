package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.User
import whitecrow.service.interfaces.IUserService

@RestController
@ControllerAdvice
class UserApiController @Autowired constructor(val userServiceImpl: IUserService) {

    @CrossOrigin(origins = ["https://whitecrow-frontend.herokuapp.com", "http://localhost:3000"])
    @PostMapping("/user/create")
    fun createUser(@RequestBody user: User): String {
        userServiceImpl.save(user)
        return "done"
    }
}