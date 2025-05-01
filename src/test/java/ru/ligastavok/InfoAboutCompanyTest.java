package ru.ligastavok;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class InfoAboutCompanyTest {
    @Test
    void successfulAboutCompanyTest() {
        open("https://www.ligastavok.ru/");
        $("[data-l-id='nav-menu-profile']").click();
        $("[data-state='shrinked']").click();
        $(".accordion__list-item-qbHx").click();
        $(".desktop-about-company-WY3P").shouldHave(text("Компания"));

    }
}
