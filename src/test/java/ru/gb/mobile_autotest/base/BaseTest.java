package ru.gb.mobile_autotest.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import ru.gb.mobile_autotest.pages.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public MainPage openApp() {
        WebDriverRunner.setWebDriver(getAndroidDriver());
        return new MainPage();
    }

    private WebDriver getAndroidDriver(){
        AppiumDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Pixel");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("app","D:\\_GeekBrains\\Download\\Android-NativeDemoApp-0.2.1.apk");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        Configuration.reportsFolder = "screenshots/actual";

        return driver;
    }

    @AfterTest
    public void setDown(){
        closeWebDriver();
    }
}
