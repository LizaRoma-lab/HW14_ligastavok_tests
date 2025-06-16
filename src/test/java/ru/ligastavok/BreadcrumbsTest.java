package ru.ligastavok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BreadcrumbsTest extends TestBase {
    @Test
    @DisplayName("Проверка отображения хлебных крошек")
    void successfulBreadcrumbsTest() {
        step("Открываем главную страницу", () -> {
            open("/");
        });
        step("Переходим в каталог", () -> {
            $(".desktop-catalogue-switcher-uKF9").click();
        });
        step("Выбираем вид спорта", () -> {
            $(byText("Футбол")).click();
        });
        step("Выбираем категорию", () -> {
            $(byText("Россия")).click();
        });
        step("Выбираем чемпионат", () -> {
            $(byText("Российская Премьер-Лига")).click();
        });
        step("Проверяем хлебные крошки", () -> {
            step("Проверяем элемент 'Главная'", () -> {
                $(".breadcrumbs__crumb_WLni").shouldHave(text("Главная"));
            });

            step("Проверяем элемент 'Футбол'", () -> {
                $(".breadcrumbs__crumb_WLni", 1).shouldHave(text("Футбол"));
            });

            step("Проверяем элемент 'Россия'", () -> {
                $(".breadcrumbs__crumb_WLni", 2).shouldHave(text("Россия"));
            });

            step("Проверяем элемент 'Российская Премьер-Лига'", () -> {
                $(".breadcrumbs__crumb_WLni", 3).shouldHave(text("Российская Премьер-Лига"));
            });
        });

        screenshot("final_page");
    }
}

