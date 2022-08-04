package com.gabrielpadilh4.pocshtnr.application.interactor.url

import com.gabrielpadilh4.pocshtnr.domain.interactor.url.GenerateShortLink
import com.gabrielpadilh4.pocshtnr.domain.model.Url
import com.gabrielpadilh4.pocshtnr.domain.service.UrlService
import org.springframework.stereotype.Component

@Component
class GenerateShortLinkImpl(
    private val urlService: UrlService
): GenerateShortLink {
    override fun execute(url: Url): Url {
        return urlService.generateShortLink(url)
    }
}