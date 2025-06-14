package ru.ligastavok;


import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class SearchTest extends TestBase {
    @Story("Поиск")
    @DisplayName("Позитивные тесты на ")
    @Owner("emromanova")
    @ValueSource(strings = {
            "Зверев",
            "Крюгер",
            "Смит"
    })
    @ParameterizedTest(name = "Поиск игрока по имени: {0}")
    void successfulSearchTest(String searchQuery) {
        step("Открываем главную страницу Лиги Ставок", () -> {
            open("https://www.ligastavok.ru/");
        });
        step("Открываем поле поиска", () -> {
            $(".search-U5Xg").click();
        });
        step("Вводим поисковый запрос: '" + searchQuery + "'", () -> {
            $(".base-input__component-input_yDi9.sm_Rp8N").setValue(searchQuery);
        });
        step("Проверяем результаты поиска", () -> {
            $(".team-name_Tw9j").shouldHave(text(searchQuery));
        });
    }
}

