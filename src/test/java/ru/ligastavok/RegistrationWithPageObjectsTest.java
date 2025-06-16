package ru.ligastavok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testutils.FakeData;

import static io.qameta.allure.Allure.step;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    FakeData fakeData = new FakeData();

    String userEmail = fakeData.userEmail,
            userNumber = fakeData.userNumber,
            userDateOfBirth = fakeData.userDateOfBirth,
            userPassword = fakeData.userPassword,
            valueResult = "Подтвердите номер телефона";

    @Test
    @DisplayName("Проверка регистрации пользователя с фейковыми данными")
    void fillFormWithFakeDataTest() {
        //SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу регистрации", () -> {
            registrationPage.openPage();
        });
        step("Заполняем форму регистрации", () -> {
            step("Вводим номер телефона: " + userNumber, () -> {
                registrationPage.setMobilePhone(userNumber);
            });
            step("Вводим дату рождения: " + userDateOfBirth, () -> {
                registrationPage.setBirthDate(userDateOfBirth);
            });
            step("Вводим email: " + userEmail, () -> {
                registrationPage.setEmail(userEmail);
            });
            step("Вводим пароль", () -> {
                registrationPage.setPassword(userPassword);
            });
            step("Подтверждаем совершеннолетие", () -> {
                registrationPage.setAgeOfMajority();
            });
        });
        step("Нажимаем кнопку 'Продолжить'", () -> {
            registrationPage.clickContinueButton();
        });
        step("Проверяем результат регистрации", () -> {
            registrationPage.setCheckResult(valueResult);
        });
    }
}
