package whitecrow.authentication

import org.springframework.beans.factory.annotation.*
import org.springframework.security.authentication.*
import org.springframework.security.core.*
import org.springframework.security.crypto.bcrypt.*
import org.springframework.stereotype.*
import whitecrow.service.*
import java.util.ArrayList
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken



@Component
class BasicAuthenticationProvider : AuthenticationProvider {

    @Autowired
    private lateinit var userSharedService: UserSharedService


    override fun authenticate(authentication: Authentication?): Authentication? {
        authentication?.let {
            val name = it.name
            val password = it.credentials.toString()
            val user = userSharedService.loadUserByUsername(name)
            if (BCryptPasswordEncoder().matches(password, user.password)) {
                return UsernamePasswordAuthenticationToken(
                    name, password, ArrayList()
                )
            }
        }
        return null

    }

    override fun supports(authentication: Class<*>?): Boolean {
        return authentication!! == UsernamePasswordAuthenticationToken::class.java
    }

}