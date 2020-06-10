package com.testing.ozon.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;

import static org.testng.Assert.*;
import static com.testing.ozon.util.TestSetup.*;

public class CartDataProcessing {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public CartDataProcessing(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @Step("Check price for 1 juicer")
    public void checkSqueezerPrice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div/div/div[3]/div[4]/div[1]/div[1]/div/div[2]/div[3]/div[3]/div[1]/div/span")));
        WebElement price = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div/div/div[3]/div[4]/div[1]/div[1]/div/div[2]/div[3]/div[3]/div[1]/div/span"));
        WebElement total = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/section/div[2]/div[4]/span[2]"));

        assertEquals(
                Integer.parseInt(deleteNotNumber(price.getText())),
                Integer.parseInt(deleteNotNumber(total.getText()))
        );
    }
}
