package com.kite.wealfyservice.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class EntityValidationException(val message: String) extends RuntimeException(message)
