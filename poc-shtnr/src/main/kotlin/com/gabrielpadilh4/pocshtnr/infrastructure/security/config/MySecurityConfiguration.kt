package com.gabrielpadilh4.pocshtnr.infrastructure.security.config

import com.gabrielpadilh4.pocshtnr.infrastructure.security.BasicSecurityProperties
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class MySecurityConfiguration(
    override val securityProperties: BasicSecurityProperties
) : BasicSecurityConfiguration(securityProperties)