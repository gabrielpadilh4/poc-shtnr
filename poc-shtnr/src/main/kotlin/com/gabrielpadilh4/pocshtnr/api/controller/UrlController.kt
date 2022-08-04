package com.gabrielpadilh4.pocshtnr.api.controller

import com.gabrielpadilh4.pocshtnr.api.Endpoints
import com.gabrielpadilh4.pocshtnr.application.mapper.UrlApplicationMapper
import com.gabrielpadilh4.pocshtnr.application.request.GenerateUrlRequest
import com.gabrielpadilh4.pocshtnr.application.response.GeneratedUrlResponse
import com.gabrielpadilh4.pocshtnr.domain.exception.url.InvalidUrlException
import com.gabrielpadilh4.pocshtnr.domain.interactor.url.GenerateShortLink
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@Tag(name= "Url")
class UrlController(
    private val generateShortLink: GenerateShortLink
) {

    @PostMapping(Endpoints.Url.GENERATE)
    fun generateShortLink(@RequestBody generateUrlRequest: GenerateUrlRequest): ResponseEntity<GeneratedUrlResponse> {
        val urlToReturn = generateShortLink.execute(UrlApplicationMapper.mapRequestToDomain(generateUrlRequest))

        val response = UrlApplicationMapper.mapDomainToResponse(urlToReturn)

        return ResponseEntity(response, HttpStatus.CREATED)
    }
}