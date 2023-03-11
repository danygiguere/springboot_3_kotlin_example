package com.example.summer.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*


@Configuration
public class Internationalization {

    @Bean
    fun acceptHeaderLocaleResolver(): AcceptHeaderLocaleResolver? {
        val resolver: AcceptHeaderLocaleResolver = AcceptHeaderLocaleResolver()
        resolver.setDefaultLocale(Locale.ENGLISH)
        return resolver
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource? {
        val messageSource: ResourceBundleMessageSource = ResourceBundleMessageSource()
        messageSource.setBasenames("messages")
        return messageSource
    }
}