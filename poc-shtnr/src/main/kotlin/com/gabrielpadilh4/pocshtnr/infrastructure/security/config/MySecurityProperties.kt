package com.gabrielpadilh4.pocshtnr.infrastructure.security.config

import com.gabrielpadilh4.pocshtnr.infrastructure.security.BasicSecurityProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "security")
@PropertySource("classpath:infrastructure.properties")
class MySecurityProperties : BasicSecurityProperties()