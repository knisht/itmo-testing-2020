package ru.knisht.blackbox.unit

import org.junit.Assert
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import ru.knisht.blackbox.controllers.game.GameController
import ru.knisht.blackbox.controllers.game.RandomGenerator
import ru.knisht.blackbox.controllers.game.UrlClient

class GameControllerTests {

    @Mock
    UrlClient mockedClient

    @Mock
    RandomGenerator generator

    @Test
    void 'test external service'() {
        MockitoAnnotations.initMocks(this)
        Mockito.when(generator.generateRandomNumber()).thenReturn(42)
        Mockito.when(mockedClient.getRequestResult("https://oeis.org/search?q=id:A42&fmt=json"))
                .thenReturn([results: [data: ["1,3,4,5,6,7"], name: 'test']])
        def controller = new GameController(mockedClient, generator)
        def result = controller.getGame()
        Assert.assertEquals('{"sequence":["1","3","4","5","6"],"result":"7","name":"test","link":"https://oeis.org/search?q=id:A42"}', result)
    }
}
