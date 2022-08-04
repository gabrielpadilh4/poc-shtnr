package com.gabrielpadilh4.pocshtnr.api

object Endpoints {
    const val API = "api/v1"

    object Url  {
        const val GENERATE = "$API/generate"
        const val REDIRECT_SHORT_LINK = "$API/shtnr/{shortLink}"
    }
}