package whitecrow.facade

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AuthenticationFacadeImpl : IAuthenticationFacade {

    override fun authentication(): Authentication {
        return SecurityContextHolder.getContext().authentication // hide static behind facade so that it can be mocked etc
    }
}