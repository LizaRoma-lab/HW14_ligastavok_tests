package ru.ligastavok;

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
    void fillFormTest() {
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
