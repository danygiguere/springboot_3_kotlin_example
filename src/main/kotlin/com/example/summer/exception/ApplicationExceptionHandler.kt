package com.example.summer.exception

import mu.KLogging
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ApplicationExceptionHandler: ResponseEntityExceptionHandler() {

    companion object: KLogging()

    override fun handleMethodArgumentNotValid(
        e: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {

        val errorMap: MutableMap<String, ArrayList<String>> = HashMap()
        e.bindingResult.fieldErrors
            .forEach { error ->
                val message = error.defaultMessage
                if (message != null) {
                    errorMap.getOrPut(error.field, defaultValue = { ArrayList() }).add(message)
                }
            }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(errorMap)
    }

    @ExceptionHandler(java.lang.Exception::class)
    fun handleAllExceptions(e: java.lang.Exception, request: WebRequest): ResponseEntity<Any> {
        logger.info("An Exception has occurred: ${e.message} on request: $request", e)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(e.message)
    }

}