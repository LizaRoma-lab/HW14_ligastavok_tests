package ru.ligastavok;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationTest extends TestBase {

    @Test
    @DisplayName("Проверка регистрации пользователя")
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
            sleep(10000);
        });
        step("Проверяем страницу подтверждения номера телефона", () -> {
            $(".verification__message-wrapper-A70e")
                    .shouldHave(text("Подтвердите номер телефона:"), Duration.ofSeconds(5));
        });
    }

}
