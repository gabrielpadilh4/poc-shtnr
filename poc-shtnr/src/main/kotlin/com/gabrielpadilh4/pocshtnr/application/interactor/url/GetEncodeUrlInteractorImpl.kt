package com.gabrielpadilh4.pocshtnr.application.interactor.url

import com.gabrielpadilh4.pocshtnr.domain.interactor.url.GetEncodedUrlInteractor
import com.gabrielpadilh4.pocshtnr.domain.model.Url
import com.gabrielpadilh4.pocshtnr.domain.service.application.UrlService
import org.springframework.stereotype.Component

@Component
class GetEncodeUrlInteractorImpl(
    private val urlService: UrlService
): GetEncodedUrlInteractor {
    override fun execute(urlLink: String): Url {
        return urlService.getEncodedUrl(urlLink)
    }
}