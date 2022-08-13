package ru.gb.mobile_autotest;

import org.testng.annotations.Test;
import ru.gb.mobile_autotest.base.BaseTest;

public class LoginTest extends BaseTest {

    public static final String EXPECTED_ERR_MSG_EMAIL = "Please enter a valid email address";
    public static final String EXPECTED_ERR_MSG_PASSWORD = "Please enter at least 8 characters";
    public static final String SUCCESS_LOGIN = "Success";
    public static final String YOU_ARE_LOGGED_IN = "You are logged in!";
    public static final String WRONG_EMAIL = "test$mail.ru";
    public static final String CORRECT_EMAIL = "test@mail.ru";
    public static final String WRONG_PASSWORD = "12345";
    public static final String CORRECT_PASSWORD = "12345678";

    @Test
    public void checkEmptyEmail() {
        openApp()
                .clickLoginMenuButton()
                .setPassword(CORRECT_PASSWORD)
                .clickLoginButton()
                .checkFirstLoginErrorMessage(EXPECTED_ERR_MSG_EMAIL);
    }

    @Test
    public void checkNotValidEmail() {
        openApp()
                .clickLoginMenuButton()
                .setEmail(WRONG_EMAIL)
                .setPassword(CORRECT_PASSWORD)
                .clickLoginButton()
                .checkFirstLoginErrorMessage(EXPECTED_ERR_MSG_EMAIL);
    }

    @Test
    public void checkNotValidPassword() throws InterruptedException {
        openApp()
                .clickLoginMenuButton()
                .setEmail(CORRECT_EMAIL)
                .setPassword(WRONG_PASSWORD)
                .clickLoginButton()
                .checkFirstLoginErrorMessage(EXPECTED_ERR_MSG_PASSWORD);

    }

    @Test
    public void checkNotValidEmailAndPassword() throws InterruptedException {
        openApp()
                .clickLoginMenuButton()
                .setEmail(WRONG_EMAIL)
                .setPassword(WRONG_PASSWORD)
                .clickLoginButton()
                .checkFirstLoginErrorMessage(EXPECTED_ERR_MSG_EMAIL)
                .checkSecondLoginErrorMessage(EXPECTED_ERR_MSG_PASSWORD);

    }

    @Test
    public void checkCorrectLogin() throws InterruptedException {

        openApp()
                .clickLoginMenuButton()
                .setEmail(CORRECT_EMAIL)
                .setPassword(CORRECT_PASSWORD)
                .clickLoginButton()
                .checkSuccessFrameWasOpened()
                .checkSuccessPageTitle(SUCCESS_LOGIN)
                .checkSuccessPageLoggedInText(YOU_ARE_LOGGED_IN)
                .clickOkButton()
                .checkSuccessFrameWasClosed();
    }

}
