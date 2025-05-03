package ru.ligastavok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.ligastavok.ru";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
        Selenide.closeWebDriver();
    }
}
