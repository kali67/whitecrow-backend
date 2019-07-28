package whitecrow.authentication

import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import org.springframework.web.filter.*
import whitecrow.service.interfaces.*
import javax.servlet.*
import javax.servlet.http.*
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import java.util.*

@Component
class JwtRequestFilter : OncePerRequestFilter() {

    @Autowired
    private lateinit var userSharedService: IUserSharedService

    @Autowired
    private lateinit var jwtTokenUtil: JwtTokenUtil

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val requestHeaderToken = request.getHeader("Authorization")
        var jwtToken: String? = null
        var uuid: UUID? = null
        if (requestHeaderToken != null && requestHeaderToken.startsWith("Bearer ")) {
            jwtToken = requestHeaderToken.substring(7)
        }
        try {
            uuid = jwtTokenUtil.findUuid(jwtToken!!)
        } catch (e: IllegalArgumentException) {
            println("Unable to get JWT Token")
        } catch (e: ExpiredJwtException) {
            println("JWT Token has expired")
        }

        if (uuid != null && SecurityContextHolder.getContext().authentication == null) {
            val userDetails = userSharedService.loadUserByUUID(uuid)
            if (jwtTokenUtil.validateToken(jwtToken!!, uuid)) {

                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }
        filterChain.doFilter(request, response)
    }

}