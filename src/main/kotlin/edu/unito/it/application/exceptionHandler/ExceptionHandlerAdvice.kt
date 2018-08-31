package edu.unito.it.application.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import javax.validation.ConstraintViolationException


@ControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler(ConstraintViolationException::class)
    fun methodArgumentTypeMismatchException(e: ConstraintViolationException): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Constraints Involved. Pay Attention To The Parameters")
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun articleNotFoundException(): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Custom 404 Page")
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun methodArgumentTypeMismatchException(e: MethodArgumentTypeMismatchException): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Operation Not Allowed")
    }

}