package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationPage {

    private final SelenideElement mobilePhoneInput = $("#mobilePhone"),
            birthDateInput = $("#birthDate"),
            emailInput = $("#email"),
            passwordInput = $("#password"),
            ageOfMajority = $("#ageOfMajority"),
            continueButton = $(byText("Продолжить")),
            checkResult = $(".verification__message-wrapper-A70e");

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/registration");
        return this;
    }

    @Step("Ввести номер мобильного телефона: {value}")
    public RegistrationPage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);
        return this;
    }

    @Step("Ввести дату рождения: {value}")
    public RegistrationPage setBirthDate(String value) {
        birthDateInput.setValue(value);
        return this;
    }

    @Step("Ввести email: {value}")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Ввести пароль: {value}")
    public RegistrationPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("Подтвердить совершеннолетие")
    public RegistrationPage setAgeOfMajority() {
        ageOfMajority.click();
        return this;
    }

    @Step("Нажать кнопку 'Продолжить'")
    public RegistrationPage clickContinueButton() {
        continueButton.scrollIntoView(true);
        continueButton.shouldBe(visible);
        sleep(5000);
        continueButton.click();
        sleep(5000);
        return this;
    }

    @Step("Проверить результат: {value}")
    public RegistrationPage setCheckResult(String value) {
        checkResult.shouldHave(text(value), Duration.ofSeconds(5));;
        return this;
    }

}
