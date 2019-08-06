package whitecrow.service

import org.springframework.beans.factory.annotation.*
import org.springframework.security.authentication.*
import org.springframework.security.core.context.*
import org.springframework.stereotype.*
import whitecrow.authentication.*
import whitecrow.service.interfaces.*

@Service
class AuthenticationServiceImpl : IAuthenticationService {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var jwtTokenUtil: JwtTokenUtil

    @Autowired
    private lateinit var userDetailsService: UserSharedService

    override fun authenticate(username: String, password: String): String {
        try {
            val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(username, password)
            authenticationManager.authenticate(usernamePasswordAuthenticationToken)
            SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
        } catch (e: DisabledException) {
            throw Exception("USER_DISABLED", e)
        } catch (e: BadCredentialsException) {
            throw Exception("INVALID_CREDENTIALS", e)
        }
        val userDetails = userDetailsService.loadUserDetByUsername(username)
        return jwtTokenUtil.generateToken(userDetails.id)
    }

}