package ru.ligastavok;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutorisationTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.ligastavok.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/registration");
        $("#mobilePhone").setValue("9543456723");
        $("#birthDate").setValue("28021999");
        $("#email").setValue("test@qa.ru");
        $("#password").setValue("Qwerty123");
        $("#ageOfMajority").click();

        $(byText("Продолжить")).scrollIntoView(true);
        $(byText("Продолжить")).shouldBe(visible);
        sleep(5000);
        $(byText("Продолжить")).click();
        sleep(5000);
        $(".verification__message-wrapper-A70e")
                .shouldHave(text("Подтвердите номер телефона:"), Duration.ofSeconds(5));
    }

}
