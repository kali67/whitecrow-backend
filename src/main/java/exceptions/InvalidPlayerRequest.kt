package whitecrow.exceptions

import org.springframework.http.*
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Players request was not valid")
class InvalidPlayerRequestException : RuntimeException()