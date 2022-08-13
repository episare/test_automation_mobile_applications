package ru.gb.mobile_autotest.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.mobile_autotest.locators.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private LoginPageLocators locator() {
        return new LoginPageLocators();
    }

    @Step("Кликаем по кнопке \"логин\" в форме")
    public LoginPage clickLoginButton() {
        $(locator().buttonLogin()).click();
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage setPassword(String pwd) {
        $(locator().inputPassword()).setValue(pwd);
        return this;
    }

    @Step("Вводим Email")
    public LoginPage setEmail(String email) {
        $(locator().inputEmail()).setValue(email);
        return this;
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkFirstLoginErrorMessage(String errText) {
        $(locator().firstLoginErrorText()).shouldHave(Condition.text(errText));
        return this;
    }

    @Step("Проверяем текст ошибки")
    public LoginPage checkSecondLoginErrorMessage(String errText) {
        $(locator().secondLoginErrorText()).shouldHave(Condition.text(errText));
        return this;
    }

    @Step("Проверяем, что фрейм alert открыт")
    public SuccessLoggingPage checkSuccessFrameWasOpened() {
        $(locator().successLoginFrame()).shouldBe(Condition.exist);
        return new SuccessLoggingPage();
    }

    @Step("Проверяем, что фрейм alert закрыт")
    public LoginPage checkSuccessFrameWasClosed() {
        $(locator().successLoginFrame()).shouldNotBe(Condition.exist);
        return this;
    }
}
