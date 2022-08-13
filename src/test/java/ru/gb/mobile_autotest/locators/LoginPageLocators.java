package ru.gb.mobile_autotest.locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPageLocators {
    public By inputPassword(){
        return AppiumBy.accessibilityId("input-password");
    }

    public By inputEmail(){
        return AppiumBy.accessibilityId("input-email");
    }
    public By buttonLogin(){
        return AppiumBy.accessibilityId("button-LOGIN");
    }

    public By firstLoginErrorText(){
        return AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    }

    public By secondLoginErrorText(){
        return AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]");
    }

    public By successLoginFrame(){
        return AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout");
    }
}
