package whitecrow.facade

import org.springframework.security.core.Authentication

interface IAuthenticationFacade {

    fun authentication(): Authentication
}