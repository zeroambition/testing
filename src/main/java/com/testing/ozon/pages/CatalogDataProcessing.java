package com.testing.ozon.pages;

import com.testing.ozon.util.TestSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class CatalogDataProcessing {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public CatalogDataProcessing(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    private WebElement city;

    @Step("Click login button")
    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[1]/div[2]/div[2]/div/button"));
        assertEquals(loginButton.getText(), "Вход или регистрация");
        loginButton.click();
    }

    @Step("Input phone number")
    public void inputPhoneNumber() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input")));
        WebElement phoneInput = driver.findElement(By.xpath(
                "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input"));
        phoneInput.sendKeys(TestSetup.PHONE);
        phoneInput.sendKeys(Keys.ENTER);
    }

    @Step("Input code")
    public void inputCode() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input")));
        WebElement codeInput = driver.findElement(By.xpath(
                "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input"));
        codeInput.sendKeys(TestSetup.CODE);
    }

    @Step("Check settings")
    public void checkSettings() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[4]/div[1]/a")));
        WebElement settings = driver.findElement(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[4]/div[1]/a"));
        assertEquals(settings.getAttribute("href"), "https://www.ozon.ru" + "/my/main");
    }

    @Step("Click city")
    public void clickCity() {
        city = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[1]/div/button/span"));
        city.click();
    }

    @Step("Input city")
    public void inputCity() {
        WebElement cityInput = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[2]/div/div/div/div/div/label/div/input"));
        cityInput.click();
        cityInput.sendKeys("Вольск");
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[2]/div/div/div/div/ul/li[1]/a"), "Вольск, Саратовская область"));
        cityInput.sendKeys(Keys.DOWN);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step("Checking city")
    public void checkCity() {
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[1]/div/button/span"), "Вольск"));
        city = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[1]/div/button/span"));
        assertEquals(city.getText(), "Вольск");
    }

    @Step("Click catalog")
    public void clickCatalog() {
        WebElement catalog = driver.findElement(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[2]/div/div[1]/button"));
        catalog.click();
    }

    @Step("Click aplliances")
    public void clickAppliances() {
        WebElement appliance = driver.findElement(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[1]/div/a[11]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(appliance).build().perform();
    }

    @Step("Click squeezers")
    public void clickSqueezerLabel() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[6]")));
        WebElement squeezer = driver.findElement(By.xpath(
                "/html/body/div[1]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[6]"));
        squeezer.click();
    }
}
