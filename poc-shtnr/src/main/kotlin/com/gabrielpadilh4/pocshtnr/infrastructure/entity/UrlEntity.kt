package com.gabrielpadilh4.pocshtnr.infrastructure.entity

import nonapi.io.github.classgraph.json.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document("url")
class UrlEntity(
    @Id
    val urlId: UUID,
    val originalLink: String,
    val shortLink: String,
    val creationDate: LocalDateTime,
    val expirationDate: LocalDateTime?
)