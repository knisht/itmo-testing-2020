package ru.knisht.blackbox.controllers.game

import org.springframework.stereotype.Service

@Service
class RandomGenerator {
    int generateRandomNumber() {
        new Random().nextInt().abs() % 1000
    }
}
