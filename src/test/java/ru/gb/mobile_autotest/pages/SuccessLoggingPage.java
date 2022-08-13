package ru.gb.mobile_autotest.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.mobile_autotest.locators.SuccessLoggingPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SuccessLoggingPage {

    private SuccessLoggingPageLocators locator() {
        return new SuccessLoggingPageLocators();
    }

    @Step("Проверяем текст заголовка")
    public SuccessLoggingPage checkSuccessPageTitle(String titleText) {
        $(locator().alertTitleText()).shouldHave(Condition.text(titleText));
        return this;
    }

    @Step("Проверяем текст сообщения об успешной авторизации")
    public SuccessLoggingPage checkSuccessPageLoggedInText(String successText) {
        $(locator().loggedInText()).shouldHave(Condition.text(successText));
        return this;
    }

    @Step("Кликаем по кнопке ОК в окне alert-сообщения и возвращаемся на страницу логина")
    public LoginPage clickOkButton() {
        $(locator().okButton()).click();
        return new LoginPage();
    }

}
