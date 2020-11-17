package ru.knisht.blackbox.controllers.game

import groovy.json.JsonOutput
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Newify(pattern = /[A-Z].*/)
class GameController {

    private UrlClient client

    private RandomGenerator generator

    GameController(UrlClient client, RandomGenerator generator) {
        this.client = client
        this.generator = generator
    }

    private static buildQuery(number) {
        "https://oeis.org/search?q=id:A${number}&fmt=json"
    }

    private static buildHumanReadableQuery(number) {
        "https://oeis.org/search?q=id:A${number}"
    }


    @CrossOrigin("*")
    @RequestMapping("/api/game")
    String getGame() {
        def sequenceId = generator.generateRandomNumber()
        def requestString = buildQuery sequenceId
        def response = client.getRequestResult(requestString).results
        def array = (response.data[0] as String).split ','
        def startIndex = 0
        def endIndex = Math.min 10, array.size() - 2
        println array[endIndex + 1]
        return JsonOutput.toJson(
                sequence: array[startIndex..endIndex],
                result: array[endIndex + 1],
                name: response.name,
                link: buildHumanReadableQuery(sequenceId))
    }
}
