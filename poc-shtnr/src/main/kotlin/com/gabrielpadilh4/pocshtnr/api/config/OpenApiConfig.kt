package com.gabrielpadilh4.pocshtnr.api.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class OpenApiConfig : WebMvcConfigurer {
    @Bean
    open fun customOpenAPI(
        @Value("\${springdoc.version}") appVersion: String,
        @Value("\${springdoc.title}") appTitle: String,
        @Value("\${springdoc.description}") appDescription: String
    ): OpenAPI {
        return OpenAPI()
            .addSecurityItem(SecurityRequirement().addList(securitySchemeName))
            .components(
                Components()
                    .addSecuritySchemes(
                        securitySchemeName,
                        SecurityScheme()
                            .name(securitySchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("basic")
                    )
            )
            .info(
                getApiInfo(appVersion, appTitle, appDescription)
            )
    }

    private fun getApiInfo(appVersion: String, appTitle: String, appDescription: String): Info {
        return Info()
            .title(appTitle)
            .version(appVersion)
            .description(appDescription)
    }

    companion object {
        const val securitySchemeName = "Basic Authentication"
    }
}