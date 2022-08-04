package com.gabrielpadilh4.pocshtnr.infrastructure.security

import org.springframework.beans.factory.annotation.Value

open class BasicSecurityProperties {
    @Value("\${security.basic.admin.username}")
    var adminUsername: String? = null

    @Value("\${security.basic.admin.password}")
    val adminPassword: String? = null

    @Value("\${security.basic.admin.role}")
    val adminRole: String? = null

    @Value("\${security.basic.strength}")
    val strength: Int? = null
}