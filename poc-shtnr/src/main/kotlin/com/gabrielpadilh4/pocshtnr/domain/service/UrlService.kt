package com.gabrielpadilh4.pocshtnr.domain.service

import com.gabrielpadilh4.pocshtnr.domain.model.Url

interface UrlService {
    fun generateShortLink(url: Url): Url
    fun getEncodedUrl(urlLink: String): Url
    fun removeShortLink(url: Url)
}