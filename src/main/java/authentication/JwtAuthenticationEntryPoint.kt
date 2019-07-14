package whitecrow.authentication

import org.springframework.security.core.*
import org.springframework.security.web.*
import org.springframework.stereotype.*
import java.io.Serializable
import javax.servlet.http.*

@Component
class JwtAuthenticationEntryPoint : AuthenticationEntryPoint, Serializable {

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        response!!.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
    }

}