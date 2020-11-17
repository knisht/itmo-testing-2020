package ru.knisht.blackbox.controllers.game

import groovy.json.JsonSlurper
import org.springframework.stereotype.Service

import java.nio.charset.StandardCharsets


@Newify(pattern = /[A-Z].*/)
@Service
class UrlClient {

    @SuppressWarnings('GrMethodMayBeStatic')
    Object getRequestResult(String url) {
        JsonSlurper().parseText new URL(url).getText(StandardCharsets.UTF_8.displayName())
    }
}
