package pages;

import com.codeborne.selenide.SelenideElement;

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

    public RegistrationPage openPage() {
        open("/registration");
        return this;
    }

    public RegistrationPage setMobilePhone(String value) {
        mobilePhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String value) {
        birthDateInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public RegistrationPage setAgeOfMajority() {
        ageOfMajority.click();
        return this;
    }

    public RegistrationPage clickContinueButton() {
        continueButton.scrollIntoView(true);
        continueButton.shouldBe(visible);
        sleep(5000);
        continueButton.click();
        sleep(5000);
        return this;
    }

    public RegistrationPage setCheckResult(String value) {
        checkResult.shouldHave(text(value), Duration.ofSeconds(5));;
        return this;
    }

}
