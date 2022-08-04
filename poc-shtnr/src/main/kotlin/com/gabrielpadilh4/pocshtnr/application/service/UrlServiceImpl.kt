package com.gabrielpadilh4.pocshtnr.application.service

import com.gabrielpadilh4.pocshtnr.domain.exception.url.ExpiredUrlException
import com.gabrielpadilh4.pocshtnr.domain.exception.url.InvalidUrlException
import com.gabrielpadilh4.pocshtnr.domain.model.Url
import com.gabrielpadilh4.pocshtnr.domain.service.UrlService
import com.gabrielpadilh4.pocshtnr.infrastructure.mapper.UrlInfrastructureMapper
import com.gabrielpadilh4.pocshtnr.infrastructure.repository.UrlRepository
import com.google.common.hash.Hashing
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.time.LocalDateTime
import java.util.*

@Service
class UrlServiceImpl(
    private val urlRepository: UrlRepository
) : UrlService {
    override fun generateShortLink(url: Url): Url {
        if (!url.originalLink.isNullOrBlank()) {

            var urlToSave: String = url.originalLink

            if (!urlToSave.contains("http://") && !urlToSave.contains("https://")) {
                urlToSave = "https://$urlToSave"
            }

            val encodedUrl = encodeUrl(urlToSave)

            val urlPersist = Url(
                urlId = UUID.randomUUID(),
                originalLink = urlToSave,
                shortLink = encodedUrl,
                creationDate = LocalDateTime.now(),
                expirationDate = LocalDateTime.now().plusSeconds(60)
            )

            val urlEntity = urlRepository.save(UrlInfrastructureMapper.mapDomainToEntity(urlPersist))

            return UrlInfrastructureMapper.mapEntityToDomain(urlEntity)

        }

        throw InvalidUrlException("The link sent to be shorted is invalid")
    }

    override fun getEncodedUrl(urlLink: String): Url {
        if (urlLink.isNullOrBlank()) {
            throw InvalidUrlException("The short link provided is invalid")
        }

        val originalUrl =
            urlRepository.findByShortLink(urlLink) ?: throw InvalidUrlException("The url requested not exists")

        if (originalUrl.expirationDate?.isBefore(LocalDateTime.now()) == true) {
            urlRepository.delete(originalUrl)
            throw ExpiredUrlException("The link already expired")
        }

        return UrlInfrastructureMapper.mapEntityToDomain(originalUrl)
    }

    override fun removeShortLink(url: Url) {
        TODO("Not yet implemented")
    }

    private fun encodeUrl(url: String): String {
        val time = LocalDateTime.now()

        return Hashing.murmur3_32_fixed()
            .hashString("${url}${time}", StandardCharsets.UTF_8)
            .toString()
    }
}