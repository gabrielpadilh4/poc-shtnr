package com.gabrielpadilh4.pocshtnr.domain.interactor.url

import com.gabrielpadilh4.pocshtnr.domain.model.Url

interface GenerateShortLinkInteractor {
    fun execute(url: Url): Url
}