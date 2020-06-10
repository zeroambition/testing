package com.testing.ozon.util;

import com.testing.ozon.listeners.DriverCommunication;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestSetup {

    public static EventFiringWebDriver driver;
    public static WebDriverWait webDriverWait;

    public static String PHONE = "9061515989";     // в этом поле указывается номер телефона при авторизации
    public static String CODE = "8779";            // в этом поле указывается код при верификации

    public static String deleteNotNumber(String string) {
        return string.replaceAll("[^\\d]*", "");
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lengsel\\Desktop\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        DriverCommunication eventListener = new DriverCommunication();
        driver.register(eventListener);
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get("https://www.ozon.ru");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}