package com.testing.ozon;

import com.testing.ozon.pages.CartDataProcessing;
import com.testing.ozon.pages.SqueezerDataProcessing;
import com.testing.ozon.pages.CatalogDataProcessing;
import com.testing.ozon.util.TestSetup;
import org.testng.annotations.Test;

public class AdjustPowerTest extends TestSetup {

    @Test
    public void fourthTest(){
        CatalogDataProcessing pageObjectMain = new CatalogDataProcessing(driver, webDriverWait);
        SqueezerDataProcessing squeezerDataProcessing = new SqueezerDataProcessing(driver, webDriverWait);
        CartDataProcessing cartDataProcessing = new CartDataProcessing(driver, webDriverWait);
        pageObjectMain.clickCatalog();
        pageObjectMain.clickAppliances();
        pageObjectMain.clickSqueezerLabel();
        squeezerDataProcessing.inputMinPrice();
        squeezerDataProcessing.checkRangeWithMinPrice();
        squeezerDataProcessing.inputMaxPrice();
        squeezerDataProcessing.checkRangeWithMinAndMaxPrice();
        squeezerDataProcessing.inputMinPower();
        squeezerDataProcessing.checkRangeWithMinPower();
        squeezerDataProcessing.sortingMin();
        squeezerDataProcessing.putJuicerPowerInCart();
        cartDataProcessing.checkSqueezerPrice();
    }
}
