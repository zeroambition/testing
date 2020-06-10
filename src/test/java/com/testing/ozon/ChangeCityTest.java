package com.testing.ozon;

import com.testing.ozon.listeners.TestListener;
import com.testing.ozon.pages.CatalogDataProcessing;
import com.testing.ozon.util.TestSetup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class ChangeCityTest extends TestSetup {

    @Test
    public void secondTest() {
        CatalogDataProcessing catalog = new CatalogDataProcessing(driver, webDriverWait);
        catalog.clickCity();
        catalog.inputCity();
        catalog.checkCity();
    }
}