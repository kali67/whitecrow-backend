package whitecrow.controller

import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.*
import org.springframework.web.bind.annotation.RequestBody
import whitecrow.authentication.*
import whitecrow.model.User
import whitecrow.service.*

@RestController
@CrossOrigin
class AuthenticationApiController {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var jwtTokenUtil: JwtTokenUtil

    @Autowired
    private lateinit var userDetailsService: UserSharedService

    @Throws(Exception::class)
    @PostMapping("/authenticate")
    fun createAuthenticationToken(@RequestBody user: User): ResponseEntity<*> {
        authenticate(user.userName, user.password)
        val userDetails = userDetailsService.loadUserDetByUsername(user.userName)
        val token = jwtTokenUtil.generateToken(userDetails.id)
        return ResponseEntity.ok<Any>(JwtResponse(token))
    }

    @Throws(Exception::class)
    private fun authenticate(username: String, password: String) {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }

    }
}