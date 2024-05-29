package com.task.bot.config

import com.task.bot.exception.ApiException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.reactive.function.client.WebClientResponseException

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(ApiException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleApiException(ex: ApiException) {
        log.warn("api exception: ${ex.message}")
    }

    @ExceptionHandler(WebClientResponseException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleWebClientException(ex: WebClientResponseException) {
        log.warn("client error: ${ex.responseBodyAsString}")
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleException(ex: Exception) {
        log.warn("error: ${ex.message}")
    }
}
