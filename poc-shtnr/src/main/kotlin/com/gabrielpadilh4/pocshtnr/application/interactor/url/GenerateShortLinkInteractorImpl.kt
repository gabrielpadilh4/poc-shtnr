package com.gabrielpadilh4.pocshtnr.application.interactor.url

import com.gabrielpadilh4.pocshtnr.domain.interactor.url.GenerateShortLinkInteractor
import com.gabrielpadilh4.pocshtnr.domain.model.Url
import com.gabrielpadilh4.pocshtnr.domain.service.application.UrlService
import org.springframework.stereotype.Component

@Component
class GenerateShortLinkInteractorImpl(
    private val urlService: UrlService
): GenerateShortLinkInteractor {
    override fun execute(url: Url): Url {
        return urlService.generateShortLink(url)
    }
}