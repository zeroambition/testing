package com.testing.ozon;

import com.testing.ozon.pages.CartDataProcessing;
import com.testing.ozon.pages.SqueezerDataProcessing;
import com.testing.ozon.pages.CatalogDataProcessing;
import com.testing.ozon.util.TestSetup;
import org.testng.annotations.Test;

public class AdjustPriceTest extends TestSetup {

    @Test
    public void thirdTest(){
        CatalogDataProcessing catalog = new CatalogDataProcessing(driver, webDriverWait);
        SqueezerDataProcessing squeezer = new SqueezerDataProcessing(driver, webDriverWait);
        CartDataProcessing cartDataProcessing = new CartDataProcessing(driver, webDriverWait);
        catalog.clickCatalog();
        catalog.clickAppliances();
        catalog.clickSqueezerLabel();
        squeezer.inputMinPrice();
        squeezer.checkRangeWithMinPrice();
        squeezer.inputMaxPrice();
        squeezer.checkRangeWithMinAndMaxPrice();
        squeezer.sortingMin();
        squeezer.putJuicerInCart();
        cartDataProcessing.checkSqueezerPrice();
    }
}
