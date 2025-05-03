package ru.ligastavok;


import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends TestBase {
    @Story("Поиск")
    @DisplayName("Позитивные тесты на поиск")
    @Owner("emromanova")
    @ValueSource(strings = {
            "Рууд",
            "Буциге",
            "Мочизуки"
    })
    @ParameterizedTest
    void successfulSearchTest(String searchQuery) {
        open("https://www.ligastavok.ru/");
        $(".search-U5Xg").click();
        $(".base-input__component-input_yDi9.sm_Rp8N").setValue(searchQuery);
        $(".team-name_Tw9j").shouldHave(text(searchQuery));

    }

}

