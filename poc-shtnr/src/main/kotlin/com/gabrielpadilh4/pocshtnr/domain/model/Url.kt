package com.gabrielpadilh4.pocshtnr.domain.model

import java.time.LocalDateTime
import java.util.*

class Url(
    val urlId: UUID?,
    val originalLink: String,
    val shortLink: String?,
    val creationDate: LocalDateTime?,
    val expirationDate: LocalDateTime?
)