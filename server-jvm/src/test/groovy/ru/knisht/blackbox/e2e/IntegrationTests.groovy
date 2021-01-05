package ru.knisht.blackbox.e2e

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Selenide.*

abstract class IntegrationTests {

    protected String browser = null

    @BeforeEach
    void setUp() {
        Configuration.browser = browser
        assert browser != null
        Configuration.fastSetValue = false
        Configuration.headless = true
        open('http://localhost:8080/guess')
    }

    @Test
    void typeWrongAnswer() {
        sleep(1000)
        $('#input_form').value = '12345'
        $('#incorrect_answer').shouldHave text("No, you're wrong.")
    }
}
