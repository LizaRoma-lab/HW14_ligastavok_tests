package ru.ligastavok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.ligastavok.ru";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "--user-data-dir=/tmp/chrome-profile-" + UUID.randomUUID()  // Динамический путь
        );

        System.setProperty("selenide.remote", "http://localhost:4444/wd/hub");
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        if (WebDriverRunner.hasWebDriverStarted()) {  // Проверяем, что драйвер существует
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
