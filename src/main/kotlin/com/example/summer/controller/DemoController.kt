package com.example.summer.controller

import mu.KLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.i18n.LocaleContextHolder.getLocale
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/demo")
class DemoController {

    companion object: KLogging()

    @Autowired
    private val messageSource: ResourceBundleMessageSource? = null

    @GetMapping("")
    fun demo(): String {
        return messageSource!!.getMessage("welcome", null, getLocale())
    }

}