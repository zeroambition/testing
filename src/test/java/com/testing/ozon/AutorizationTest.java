package com.testing.ozon;

import com.testing.ozon.listeners.TestListener;
import com.testing.ozon.pages.CatalogDataProcessing;
import com.testing.ozon.util.TestSetup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class AutorizationTest extends TestSetup {

    @Test
    public void firstTest() {
        CatalogDataProcessing pageObjectMain = new CatalogDataProcessing(driver, webDriverWait);
        pageObjectMain.clickLogin();
        pageObjectMain.inputPhoneNumber();
        pageObjectMain.inputCode();
        pageObjectMain.checkSettings();
    }
}