package com.gabrielpadilh4.pocshtnr.api.config.exceptionHandler

import com.gabrielpadilh4.pocshtnr.domain.exception.url.ExpiredUrlException
import com.gabrielpadilh4.pocshtnr.domain.exception.url.InvalidUrlException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@RestControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler
    fun handleExpiredUrlException(ex: ExpiredUrlException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleInvalidUrlException(ex: InvalidUrlException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}