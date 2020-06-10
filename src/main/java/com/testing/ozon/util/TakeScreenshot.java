package com.testing.ozon.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshot {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] takeScreenshot(){
        return ((TakesScreenshot) TestSetup.driver).getScreenshotAs(OutputType.BYTES);
    }
}
