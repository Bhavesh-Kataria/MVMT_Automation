package com.mvmt.tests;

import com.mvmt.base.Base;
import com.mvmt.pages.CheckoutPage;
import com.mvmt.pages.MensWatchesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MensWatchesPageTests extends Base {
    private MensWatchesPage mensWatchesPage;

    @BeforeMethod
    public void  setUp(){
        mensWatchesPage = new MensWatchesPage();
    }

    @Test(dependsOnMethods = "com.mvmt.tests.HomePageTests.gotoMensWatchesTest")
    public void selectAndAddToCartTest() throws InterruptedException {
        log.info("Mens Watches Page Tests Method running....");
        mensWatchesPage.selectAndAddToCart();
    }
}
