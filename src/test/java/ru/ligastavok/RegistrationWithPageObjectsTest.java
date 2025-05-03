package ru.ligastavok;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    FakeData fakeData = new FakeData();

    String userEmail = fakeData.userEmail,
            userNumber = fakeData.userNumber,
            userDateOfBirth = fakeData.userDateOfBirth,
            userPassword = fakeData.userPassword,
            valueResult = "Подтвердите номер телефона";

    @Test

    void fillFormWithFakeDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setMobilePhone(userNumber)
                .setBirthDate(userDateOfBirth)
                .setEmail(userEmail)
                .setPassword(userPassword)
                .setAgeOfMajority()
                .clickContinueButton();

        registrationPage.setCheckResult(valueResult);

    }
}
