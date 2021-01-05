package ru.knisht.blackbox.e2e

import com.codeborne.selenide.Browsers

class FirefoxIntegrationTest extends IntegrationTests {
    {
        browser = Browsers.FIREFOX
    }
}
