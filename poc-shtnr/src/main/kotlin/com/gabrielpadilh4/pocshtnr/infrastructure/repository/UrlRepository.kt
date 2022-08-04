package com.gabrielpadilh4.pocshtnr.infrastructure.repository

import com.gabrielpadilh4.pocshtnr.infrastructure.entity.UrlEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UrlRepository : MongoRepository<UrlEntity, UUID> {
}