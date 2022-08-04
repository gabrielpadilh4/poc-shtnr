package com.gabrielpadilh4.pocshtnr.infrastructure.security.service

import com.gabrielpadilh4.pocshtnr.domain.service.infrastructure.AuthService
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl: AuthService {
    override fun getCurrentUserName(): String {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        if (authentication !is AnonymousAuthenticationToken) {
            return authentication.name
        }
        return "USER_NOT_FOUND"
    }
}