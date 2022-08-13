package ru.gb.mobile_autotest.pages;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import io.qameta.allure.Step;
import ru.gb.mobile_autotest.locators.MainPageLocators;

import java.awt.image.BufferedImage;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class MainPage {

    @Step("Кликаем по кнопке логина в меню и переходим на новую страницу логина")
    public LoginPage clickLoginMenuButton() {
        $(locator().loginButton()).click();
        return new LoginPage();
    }

    private MainPageLocators locator() {
        return new MainPageLocators();
    }

    @Step("Делаем скриншот главной страницы и сравниваем с требованием.")
    public MainPage checkScreenshot() {
// Загружаем ожидаемое изображения для сравнения.
        BufferedImage expectedImage =
                ImageComparisonUtil.readImageFromResources("screenshots/expect/MainPageFault.png");
// Делаем актуальный скриншот, используя элемент и игнорируя другие части экрана.
        File actualScreenshot = $(locator().homeScreen()).screenshot();
// Загружаем актуальный скриншот.
        BufferedImage actualImage =
                ImageComparisonUtil.readImageFromResources("screenshots/actual/" +
                        actualScreenshot.getName());
// Где будем хранить скриншот с различиями в случае падения теста.
        File resultDestination = new
                File("diff/diff_CheckMainPageScreenshot.png");
// Сравниваем.
        ImageComparisonResult imageComparisonResult = new
                ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
        assertEquals(ImageComparisonState.MATCH,
                imageComparisonResult.getImageComparisonState());
        return this;
    }

    public void makeScreen(){
        $(locator().homeScreen()).screenshot();
    }


}
