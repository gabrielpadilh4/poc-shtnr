package com.gabrielpadilh4.pocshtnr.application.response

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(title = "Generated short link response")
class GeneratedUrlResponse(
    @field:Schema(description = "Original link of url generated", nullable = false)
    val originalUrl: String,
    @field:Schema(description = "New url link", nullable = false)
    val url: String,
    @field:Schema(description = "Expiration time for short link", nullable = false)
    val expirationDate: LocalDateTime
)