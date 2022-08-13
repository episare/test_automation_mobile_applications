package ru.gb.mobile_autotest;

import org.testng.annotations.Test;
import ru.gb.mobile_autotest.base.BaseTest;

public class ScreenShootTest extends BaseTest {
    @Test
    public void createScreen() {
        openApp().checkScreenshot();
    }
}
