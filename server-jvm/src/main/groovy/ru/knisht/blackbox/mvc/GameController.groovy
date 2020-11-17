package ru.knisht.blackbox.mvc

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import java.nio.charset.StandardCharsets

@RestController
@Newify(pattern = /[A-Z].*/)
class GameController {

    private static buildQuery(number) {
        "https://oeis.org/search?q=id:A${number}&fmt=json"
    }

    private static buildHumanReadableQuery(number) {
        "https://oeis.org/search?q=id:A${number}"
    }

    private static getRequestResult(url) {
        JsonSlurper().parseText new URL(url).getText(StandardCharsets.UTF_8.displayName())
    }

    @CrossOrigin("*")
    @RequestMapping("/api/game")
    String getGame() {
        def sequenceId = Math.abs(new Random().nextInt()) % 1000
        def requestString = buildQuery sequenceId
        def response = getRequestResult(requestString).results
        def array = (response.data[0] as String).split ','
        def startIndex = 0
        def endIndex = Math.min(10, array.size() - 2)
        println array[endIndex + 1]
        return JsonOutput.toJson(
                sequence: array[startIndex..endIndex],
                result: array[endIndex + 1],
                name: response.name,
                link: buildHumanReadableQuery(sequenceId))
    }
}
