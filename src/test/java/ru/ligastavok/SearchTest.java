package ru.ligastavok;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @ValueSource(strings = {
            "Соболенко",
            "Атман",
            "Качмазов"
    })
    @ParameterizedTest
    void successfulSearchTest(String searchQuery) {
        open("https://www.ligastavok.ru/");
        $(".search-U5Xg").click();
        $(".base-input__component-input_yDi9.sm_Rp8N").setValue(searchQuery);
        $(".team-name_Tw9j").shouldHave(text(searchQuery));

    }

}

