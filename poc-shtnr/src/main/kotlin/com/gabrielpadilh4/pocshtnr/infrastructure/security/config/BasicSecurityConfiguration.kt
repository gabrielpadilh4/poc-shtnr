package com.gabrielpadilh4.pocshtnr.infrastructure.security.config

import com.gabrielpadilh4.pocshtnr.infrastructure.security.BasicSecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import java.util.*

@Suppress("SpringConfigurationProxyMethods")
open class BasicSecurityConfiguration(open val securityProperties: BasicSecurityProperties) {
    @Bean
    open fun inMemoryUserDetailsManager(): UserDetailsService {
        val users = Properties()

        users[securityProperties.adminUsername] =
            "${bCryptPasswordEncoder().encode(securityProperties.adminPassword)},${securityProperties.adminRole},enabled"

        return InMemoryUserDetailsManager(users)
    }

    @Bean
    open fun bCryptPasswordEncoder(): BCryptPasswordEncoder = BCryptPasswordEncoder(securityProperties.strength!!)

    @Bean
    @Throws(java.lang.Exception::class)
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/actuator/**", "/swagger-ui/**").permitAll()
            .and()
            .authorizeRequests().anyRequest().authenticated()
            .and().httpBasic()
        return http.build()
    }

}