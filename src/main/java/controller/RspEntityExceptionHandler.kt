package whitecrow.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import whitecrow.exceptions.UserAlreadyExistsException
import java.lang.RuntimeException

@ControllerAdvice
class RspEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [UserAlreadyExistsException::class])
    protected fun handleGeneric(request: WebRequest, ex: RuntimeException): ResponseEntity<Any> {
        val bodyOfResponse = "This should be application specific"
        return handleExceptionInternal(ex, bodyOfResponse, HttpHeaders(), HttpStatus.CONFLICT, request)
    }
}