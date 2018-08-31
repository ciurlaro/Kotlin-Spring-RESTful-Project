package edu.unito.it.application.exceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class UserNotFoundException : RuntimeException()