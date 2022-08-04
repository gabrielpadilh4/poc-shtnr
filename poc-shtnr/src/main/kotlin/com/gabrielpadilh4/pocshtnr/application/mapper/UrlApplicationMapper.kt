package com.gabrielpadilh4.pocshtnr.application.mapper

import com.gabrielpadilh4.pocshtnr.application.request.GenerateUrlRequest
import com.gabrielpadilh4.pocshtnr.application.response.GeneratedUrlResponse
import com.gabrielpadilh4.pocshtnr.domain.model.Url

object UrlApplicationMapper {
    fun mapRequestToDomain(generateUrlRequest: GenerateUrlRequest): Url {
        return Url(
            urlId = null,
            originalLink = generateUrlRequest.url,
            shortLink = null,
            creationDate = null,
            expirationDate = generateUrlRequest.expirationDate
        )
    }

    fun mapDomainToResponse(url: Url): GeneratedUrlResponse{
        return GeneratedUrlResponse(
            originalUrl = url.originalLink,
            url = url.shortLink!!,
            expirationDate = url.expirationDate!!
        )
    }
}