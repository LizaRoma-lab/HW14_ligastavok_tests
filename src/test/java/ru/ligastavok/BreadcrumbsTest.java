package ru.ligastavok;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BreadcrumbsTest extends TestBase {
    @Test
    void successfulBreadcrumbsTest() {
        open("https://www.ligastavok.ru/");
        $(".catalogue_title-isOk").click();
        $(byText("Футбол")).click();
        $(byText("Россия")).click();
        $(byText("Первая лига")).click();
        $(".breadcrumbs__crumb_WLni").shouldHave(text("Главная"));
        $(".breadcrumbs__crumb_WLni", 1).shouldHave(text("Футбол"));
        $(".breadcrumbs__crumb_WLni", 2).shouldHave(text("Россия"));
        $(".breadcrumbs__crumb_WLni", 3).shouldHave(text("Первая лига"));
        sleep(5000);
    }
}

