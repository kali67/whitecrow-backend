package whitecrow.authentication

import org.springframework.security.core.userdetails.*
import java.util.*

interface JwtUserDetails : UserDetails {

    var uuid: UUID
}