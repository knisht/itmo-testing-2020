package ru.knisht.blackbox.e2e

import com.codeborne.selenide.Browsers

class ChromiumIntegrationTest extends IntegrationTests {
    {
        browser = Browsers.CHROME
    }
}
