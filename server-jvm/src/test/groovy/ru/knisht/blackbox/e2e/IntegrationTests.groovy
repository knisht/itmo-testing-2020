package ru.knisht.blackbox.e2e

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selectors
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static com.codeborne.selenide.Condition.text
import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Selectors.byLinkText
import static com.codeborne.selenide.Selectors.byText
import static com.codeborne.selenide.Selenide.*

abstract class IntegrationTests {

    protected String browser = null

    @BeforeEach
    void setUp() {
        Configuration.browser = browser
        assert browser != null
        Configuration.fastSetValue = false
        Configuration.headless = true
    }

    @Test
    void typeWrongAnswer() {
        open('http://localhost:8080/guess')
        $('#input_form').value = '12345'
        $('#incorrect_answer') shouldHave text("No, you're wrong.")
    }

    @Test
    void successfulLogin() {
        open('http://localhost:8080/login')
        $('#username-input').value = 'admin'
        $('#password-input').value = 'admin'
        $('#login-button') click()
        $('#secure') shouldHave text('You have successfully logged in')
        $(byLinkText('Logout')) click()
        $('#login') shouldBe visible
    }
}
