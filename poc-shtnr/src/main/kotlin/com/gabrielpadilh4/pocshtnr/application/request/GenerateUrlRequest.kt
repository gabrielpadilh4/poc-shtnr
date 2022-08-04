package com.gabrielpadilh4.pocshtnr.application.request

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(title = "Generate short link")
class GenerateUrlRequest(
    @field:Schema(description = "Link of url to generate", nullable = false)
    val url: String,
    @field:Schema(description = "Expiration time for shortlink", nullable = true)
    val expirationDate: LocalDateTime?
)