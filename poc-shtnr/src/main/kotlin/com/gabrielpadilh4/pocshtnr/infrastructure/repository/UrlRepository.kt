package com.gabrielpadilh4.pocshtnr.infrastructure.repository

import com.gabrielpadilh4.pocshtnr.infrastructure.entity.UrlEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UrlRepository : MongoRepository<UrlEntity, UUID> {
    @Query("{shortLink:'?0'}")
    fun findByShortLink(shortLink: String?): UrlEntity?
}