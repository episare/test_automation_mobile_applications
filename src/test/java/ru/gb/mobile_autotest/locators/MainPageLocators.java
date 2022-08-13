package ru.gb.mobile_autotest.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class MainPageLocators {
    public By homeButton(){
        return AppiumBy.accessibilityId("Home");
    }

    public By webViewButton(){
        return AppiumBy.accessibilityId("WebView");
    }

    public By loginButton(){
        return AppiumBy.accessibilityId("Login");
    }

    public By formsButton(){
        return AppiumBy.accessibilityId("Forms");
    }

    public By swipeButton(){
        return AppiumBy.accessibilityId("Swipe");
    }
    public By homeScreen(){
        return AppiumBy.accessibilityId("Home-screen");
    }

}
