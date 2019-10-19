package whitecrow.service.interfaces

interface IAuthenticationService {

    /**
     * Authenticates user with given username and password
     * @return access token - that can take many implementations i.e. jwt
     */
    fun authenticate(username: String, password: String) : String

}