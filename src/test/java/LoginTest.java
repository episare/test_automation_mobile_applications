import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    public static final String EXPECTED_ERR_MSG_EMAIL = "Please enter a valid email address";

    public static final String EXPECTED_ERR_MSG_PASSWORD = "Please enter at least 8 characters";
    public static final String SUCCESS_LOGIN = "Success";
    public static final String YOU_ARE_LOGGED_IN = "You are logged in!";

    public static final String WRONG_EMAIL = "test$mail.ru";
    public static final String CORRECT_EMAIL = "test@mail.ru";

    public static final String WRONG_PASSWORD = "12345";
    public static final String CORRECT_PASSWORD = "12345678";

    MobileDriver driver = null;


    @BeforeMethod
    void initDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("app","D:\\_GeekBrains\\Download\\Android-NativeDemoApp-0.2.1.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

    @Test
    public void checkEmptyEmail() throws InterruptedException {

        Thread.sleep(1000);

        MobileElement menuLoginButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        menuLoginButton.click();
        Thread.sleep(1000);

        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(CORRECT_PASSWORD);
        Thread.sleep(1000);

        MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        buttonLogin.click();

        Thread.sleep(1000);
        MobileElement errorEmailMessage = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorEmailMessage.getText(), EXPECTED_ERR_MSG_EMAIL);
    }

    @Test
    public void checkNotValidEmail() throws InterruptedException {

        Thread.sleep(1000);
        MobileElement menuLoginButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        menuLoginButton.click();

        Thread.sleep(1000);
        MobileElement emailInput = (MobileElement) driver.findElementByAccessibilityId("input-email");
        emailInput.sendKeys(WRONG_EMAIL);

        Thread.sleep(1000);
        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(CORRECT_PASSWORD);

        Thread.sleep(1000);
        MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        buttonLogin.click();

        Thread.sleep(1000);
        MobileElement errorEmailMessage = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorEmailMessage.getText(), EXPECTED_ERR_MSG_EMAIL);
    }

    @Test
    public void checkNotValidPassword() throws InterruptedException {

        Thread.sleep(1000);
        MobileElement menuLoginButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        menuLoginButton.click();

        Thread.sleep(1000);
        MobileElement emailInput = (MobileElement) driver.findElementByAccessibilityId("input-email");
        emailInput.sendKeys(CORRECT_EMAIL);

        Thread.sleep(1000);
        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(WRONG_PASSWORD);

        Thread.sleep(1000);
        MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        buttonLogin.click();

        Thread.sleep(2000);
        MobileElement errorEmailMessage = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorEmailMessage.getText(), EXPECTED_ERR_MSG_PASSWORD);
    }

    @Test
    public void checkCorrectLogin() throws InterruptedException {

        Thread.sleep(1000);
        MobileElement menuLoginButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        menuLoginButton.click();

        Thread.sleep(1000);
        MobileElement emailInput = (MobileElement) driver.findElementByAccessibilityId("input-email");
        emailInput.sendKeys(CORRECT_EMAIL);

        Thread.sleep(1000);
        MobileElement passwordInput = (MobileElement) driver.findElementByAccessibilityId("input-password");
        passwordInput.sendKeys(CORRECT_PASSWORD);

        Thread.sleep(1000);
        MobileElement buttonLogin = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        buttonLogin.click();

        Thread.sleep(1000);
        MobileElement alertFrame = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout");
        MobileElement successLoginMessage = (MobileElement) driver.findElementById("android:id/alertTitle");
        MobileElement youAreLoginMessage = (MobileElement) driver.findElementById("android:id/message");

        Assert.assertEquals(successLoginMessage.getText(), SUCCESS_LOGIN);
        Assert.assertEquals(youAreLoginMessage.getText(), YOU_ARE_LOGGED_IN);
    }

}
