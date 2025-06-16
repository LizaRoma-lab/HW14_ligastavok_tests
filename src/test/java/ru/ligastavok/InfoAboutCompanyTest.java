package ru.ligastavok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class InfoAboutCompanyTest extends TestBase {
    @Test
    @DisplayName("Проверка отображения раздела 'О компании'")
    void successfulAboutCompanyTest() {
        step("Открываем главную страницу", () -> {
            open("/");
        });
        step("Переходим в личный кабинет", () -> {
            $("[data-l-id='nav-menu-profile']").click();
        });
        step("Раскрываем меню пользователя", () -> {
            $("[data-state='shrinked']").click();
        });
        step("Выбираем раздел 'О компании'", () -> {
            $(".accordion__list-item-qbHx").click();
        });
        step("Проверяем отображение заголовка раздела", () -> {
            $(".desktop-about-company-WY3P").shouldHave(text("Компания"));
        });
    }
}
