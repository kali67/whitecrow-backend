package whitecrow.service.interfaces

interface IAuthenticationService {

    /**
     * Authenticates user with given username and password
     * returns access token - that can take many implementations i.e. jwt
     */
    fun authenticate(username: String, password: String) : String

}