package whitecrow.authentication

import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import java.io.Serializable
import io.jsonwebtoken.Claims
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.function.Function


@Component
class JwtTokenUtil : Serializable {

    companion object {
        const val JWT_TOKEN_VALIDITY = 5 * 60 * 60
    }

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    fun findUsername(token: String): String {
        return findClaim(token, Function { it.subject })
    }

    fun findExpirationDate(token: String): Date {
        return findClaim(token, Function { it.expiration })
    }

    fun <T> findClaim(token: String, claimsResolver: java.util.function.Function<Claims, T>): T {
        val claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
        return claimsResolver.apply(claims)
    }

    private fun isTokenExpired(token: String): Boolean {
        val expiration = findExpirationDate(token)
        return expiration.before(Date())
    }

    fun generateToken(userDetails: UserDetails): String {
        val claims = HashMap<String, Any>()
        return Jwts.builder().apply {
            setClaims(claims)
            setSubject(userDetails.username)
            setIssuedAt(Date(System.currentTimeMillis()))
            setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            signWith(SignatureAlgorithm.HS512, secret)
        }.compact()
    }

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = findUsername(token)
        return username == userDetails.username && !isTokenExpired(token)
    }
}