package ru.knisht.blackbox.e2e

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.clearBrowserCookies
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage
import static com.codeborne.selenide.Selenide.sleep
import static com.codeborne.selenide.Selenide.refresh
import static com.codeborne.selenide.Selenide.open
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted

abstract class IntegrationTests {

    String browser = null

    @BeforeEach
    void setUp() {
        Configuration.browser = 'firefox'
        Configuration.fastSetValue = false
        if (hasWebDriverStarted()) {
            clearBrowserCookies()
            clearBrowserLocalStorage()
            refresh()
        }
        else {
            open('localhost:8080/guess')
        }
    }

    @Test
    void typeWrongAnswer() {
        sleep(1000)
        $('#input_form').value = '12345'
        $('#incorrect_answer').shouldHave text("No, you're wrong.")
    }
}
