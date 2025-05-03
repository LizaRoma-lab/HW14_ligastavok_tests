package ru.ligastavok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {
//    @BeforeAll
//    static void beforeAll() {
//        //Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://www.ligastavok.ru";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 5000; // default 4000
//    }

    @Test
    public void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем страницу регистрации", () -> {
            open("/registration");
                });
        step("Заполняем поля тестовыми данными", () -> {
                    $("#mobilePhone").setValue("9543456712");
                    $("#birthDate").setValue("28021999");
                    $("#email").setValue("test123@qa.ru");
                    $("#password").setValue("Qwerty123");
                    $("#ageOfMajority").click();
                });
        step("Кликаем по кнопке [Продолжить]", () -> {
                    $(byText("Продолжить")).scrollIntoView(true);
                    $(byText("Продолжить")).shouldBe(visible);
                    sleep(5000);
                    $(byText("Продолжить")).click();
                    sleep(5000);
                });
        step("Проверяем страницу подтверждения номера телефона", () -> {
            $(".verification__message-wrapper-A70e")
                    .shouldHave(text("Подтвердите номер телефона:"), Duration.ofSeconds(5));
        });
    }

}
