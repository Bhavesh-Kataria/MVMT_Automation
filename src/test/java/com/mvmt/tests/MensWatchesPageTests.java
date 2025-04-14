package com.mvmt.tests;

import com.mvmt.base.Base;
import com.mvmt.pages.CheckoutPage;
import com.mvmt.pages.MensWatchesPage;
import com.mvmt.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MensWatchesPageTests extends Base {
    private MensWatchesPage mensWatchesPage;
    private WebDriver webDriver;

//    @BeforeMethod
//    public void  setUp(){
//        mensWatchesPage = new MensWatchesPage();
//    }

//    @Test(dependsOnMethods = "com.mvmt.tests.HomePageTests.gotoMensWatchesTest")
    public void selectAndAddToCartTest() {
        log.info("Mens Watches Page Tests Method running....");
        try {
            mensWatchesPage = new MensWatchesPage();
            mensWatchesPage.selectAndAddToCart();
            Thread.sleep(5000);
            webDriver = getDriver();
            webDriver.findElement(By.id("close-mini-cart")).click();
            TestUtil.logout(webDriver);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
