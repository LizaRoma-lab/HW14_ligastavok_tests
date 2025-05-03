package ru.ligastavok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
        Configuration.remote = "https://user1:1234@selenoid.autotest.cloud/wd/hub";
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
}
