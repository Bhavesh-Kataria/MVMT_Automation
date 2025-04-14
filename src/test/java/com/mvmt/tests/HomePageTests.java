package com.mvmt.tests;


import com.mvmt.base.Base;
import com.mvmt.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends Base { ;
    private HomePage homePage;

//    @BeforeMethod
//    public void setUp(){
//        homePage = new HomePage();
//    }

//    @Test(dependsOnMethods = "com.mvmt.tests.LogInPageTests.fillLoginFormTest")
//    @Test(dependsOnMethods = "com.mvmt.tests.LogInPageTests.multiUserFillLoginFormTest")
    public void gotoMensWatchesTest() throws InterruptedException {
        Thread.sleep(5000);
        log.info("Home Page Tests Method running....");
        Thread.sleep(5000);
        homePage = new HomePage();
        homePage.gotoMensWatches();
    }
}
