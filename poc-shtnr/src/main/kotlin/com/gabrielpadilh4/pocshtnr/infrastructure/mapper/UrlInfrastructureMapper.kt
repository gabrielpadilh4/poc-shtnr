package com.gabrielpadilh4.pocshtnr.infrastructure.mapper

import com.gabrielpadilh4.pocshtnr.domain.model.Url
import com.gabrielpadilh4.pocshtnr.infrastructure.entity.UrlEntity

object UrlInfrastructureMapper {
    fun mapEntityToDomain(urlEntity: UrlEntity): Url {
        return Url(
            urlId = urlEntity.urlId,
            originalLink = urlEntity.originalLink,
            shortLink = urlEntity.shortLink,
            creationDate = urlEntity.creationDate,
            expirationDate = urlEntity.expirationDate,
            createdBy = urlEntity.createdBy
        )
    }

    fun mapDomainToEntity(url: Url): UrlEntity {
        return UrlEntity(
            urlId = url.urlId!!,
            originalLink = url.originalLink,
            shortLink = url.shortLink!!,
            creationDate = url.creationDate!!,
            expirationDate = url.expirationDate,
            createdBy = url.createdBy
        )
    }
}