package ru.ligastavok;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testutils.FakeData;


@Feature("Регистрация пользователя")
@Story("Регистрация с фейковыми данными")
public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakeData fakeData = new FakeData();

    String userEmail = fakeData.userEmail;
    String userNumber = fakeData.userNumber;
    String userDateOfBirth = fakeData.userDateOfBirth;
    String userPassword = fakeData.userPassword;
    String valueResult = "Подтвердите номер телефона";

    @Test
    @DisplayName("Проверка регистрации пользователя с фейковыми данными")
    void fillFormWithFakeDataTest() {
        // Открытие страницы
        registrationPage.openPage();

        // Заполнение формы
        registrationPage.setMobilePhone(userNumber);
        registrationPage.setBirthDate(userDateOfBirth);
        registrationPage.setEmail(userEmail);
        registrationPage.setPassword(userPassword);
        registrationPage.setAgeOfMajority();

        // Подтверждение
        registrationPage.clickContinueButton();

        // Проверка результата
        registrationPage.setCheckResult(valueResult);
    }
}