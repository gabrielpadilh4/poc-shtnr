package com.gabrielpadilh4.pocshtnr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication(scanBasePackages = ["com.gabrielpadilh4.pocshtnr.*"])
@EnableWebSecurity
class PocShtnrApplication

fun main(args: Array<String>) {
	runApplication<PocShtnrApplication>(*args)
}
