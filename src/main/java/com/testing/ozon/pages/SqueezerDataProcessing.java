package com.testing.ozon.pages;

import static com.testing.ozon.util.TestSetup.deleteNotNumber;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class SqueezerDataProcessing {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public SqueezerDataProcessing(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    private WebElement chooseSorting;

    @Step("Input minimum price")
    public void inputMinPrice() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input")));
            try {
                WebElement close = driver.findElement(By.xpath("//*[@id=\"__ozon\"]/div/div[3]/div/button"));
                close.click();
            }
            catch(Exception e) {}
            WebElement priceMinInput = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input"));
            priceMinInput.sendKeys(Keys.CONTROL + "a");
            priceMinInput.sendKeys("3000");
            priceMinInput.sendKeys(Keys.ENTER);
        } catch (Exception ex) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input")));
            try {
                WebElement close = driver.findElement(By.xpath("//*[@id=\"__ozon\"]/div/div[3]/div/button"));
                close.click();
            }
            catch(Exception e) {}
            WebElement priceMinInput = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input"));
            priceMinInput.sendKeys(Keys.CONTROL + "a");
            priceMinInput.sendKeys("3000");
            priceMinInput.sendKeys(Keys.ENTER);
        }
    }

    @Step("Input maximum price")
    public void inputMaxPrice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input")));
        WebElement priceMaxInput = driver.findElement(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input"));
        priceMaxInput.sendKeys(Keys.CONTROL + "a");
        priceMaxInput.sendKeys("4000");
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("" +
                    "[class=\"dots dots-blue\"]")));
        }
        catch(NoSuchElementException e) {}
        priceMaxInput.sendKeys(Keys.ENTER);
    }

    @Step("Check range (mimimum)")
    public void checkRangeWithMinPrice() {
        final String minMaxPrice = "Цена: от 3 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")));

        assertTrue(driver.findElement(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")).getText().startsWith(minMaxPrice));
    }

    @Step("Check range (mimimum and maximum)")
    public void checkRangeWithMinAndMaxPrice() {
        final String minMaxPrice = "Цена: от 3 000 до 4 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span"), minMaxPrice));

        assertEquals(driver.findElement(By.xpath("" +
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span")).getText(), minMaxPrice);
    }

    @Step("Input minimum power")
    public void inputMinPower() {
        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("" +
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[8]/div[2]/div[2]/div[1]/input")));
            try {
                WebElement close = driver.findElement(By.xpath("" +
                        "//*[@id=\"__ozon\"]/div/div[3]/div/button"));
                close.click();
            }
            catch(Exception e) {}
            WebElement priceMinInput = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[8]/div[2]/div[2]/div[1]/input"));
            priceMinInput.sendKeys(Keys.CONTROL + "a");
            priceMinInput.sendKeys("1000");
            priceMinInput.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[8]/div[2]/div[2]/div[1]/input")));
            try {
                WebElement close = driver.findElement(By.xpath("//*[@id=\"__ozon\"]/div/div[3]/div/button"));
                close.click();
            }
            catch(Exception ex) {}

            WebElement priceMinInput = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[1]/div/aside/div[8]/div[2]/div[2]/div[1]/input"));
            priceMinInput.sendKeys(Keys.CONTROL + "a");
            priceMinInput.sendKeys("1000");
            priceMinInput.sendKeys(Keys.ENTER);
        }
    }

    @Step("Check range with minimum power")
    public void checkRangeWithMinPower() {
        final String minPower = "Мощность, Вт: от 1 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span")));

        assertTrue(driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span")).getText().startsWith(minPower));
    }

    @Step("Sorting by price (finding minimum)")
    public void sortingMin() {
        sortByPrice(2);
        WebElement firstJuicerPrice = getFirstJuicerPrice();
        assertTrue(Integer.parseInt(deleteNotNumber(firstJuicerPrice.getText())) > 3000);
    }

    @Step("Buy squeezer")
    public void putJuicerInCart() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[3]/div/div/button")));
        WebElement firstJuicerCart = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[3]/div/div/button"));
        firstJuicerCart.click();
        WebElement cart = driver.findElement(By.cssSelector("[data-widget=\"cart\"]"));
        cart.click();
    }

    @Step("Buy squeezer (power >1000)")
    public void putJuicerPowerInCart() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[3]/div/div/button")));
        WebElement firstJuicerCart = driver.findElement(By.xpath(
                "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[3]/div/div/button"));
        firstJuicerCart.click();
        WebElement cart = driver.findElement(By.cssSelector("[data-widget=\"cart\"]"));
        cart.click();
    }

    private void sortByPrice(int sendKeysNTimes) {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
                    "[class=\"dots dots-blue\"]")));
        }
        catch(NoSuchElementException e) {}

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[role=\"combobox\"]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role=\"combobox\"]")));
        chooseSorting = driver.findElement(By.cssSelector("[role=\"combobox\"]"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSorting));
        chooseSorting.click();
        chooseSorting.click();

        for(int i = 0; i < sendKeysNTimes; i++) {
            chooseSorting.sendKeys(Keys.ARROW_DOWN);
        }

        chooseSorting.sendKeys(Keys.ENTER);
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
                    "[class=\"dots dots-blue\"]")));
        }
        catch(NoSuchElementException e) {};
    }

    private WebElement getFirstJuicerPrice() {
        WebElement cheepestSqueezerPrice;

        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[4]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[1]/span")));
            cheepestSqueezerPrice = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[4]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[1]/span"));
        }
        catch(Exception e) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[2]/span")));
            cheepestSqueezerPrice = driver.findElement(By.xpath(
                    "//*[@id=\"__ozon\"]/div/div[1]/div[3]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[2]/span"));
        }

        return cheepestSqueezerPrice;
    }

}