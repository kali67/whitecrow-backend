package whitecrow.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import whitecrow.authentication.*
import whitecrow.model.User
import whitecrow.service.interfaces.*

@RestController
@CrossOrigin
class AuthenticationApiController {

    @Autowired
    private lateinit var authenticationServiceImpl: IAuthenticationService


    @Throws(Exception::class)
    @PostMapping("/authenticate")
    fun createAuthenticationToken(@RequestBody user: User): ResponseEntity<*> {
        val token = authenticationServiceImpl.authenticate(user.userName, user.password)
        return ResponseEntity.ok<Any>(JwtResponse(token))
    }
}