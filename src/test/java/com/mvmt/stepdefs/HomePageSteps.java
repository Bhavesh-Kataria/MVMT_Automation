package com.mvmt.stepdefs;

import com.mvmt.pages.HomePage;
import com.mvmt.util.DriverFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class HomePageSteps {
    private HomePage homePage;
    private WebDriver driver;

    @When("user navigates to the \"Men's Watches\" category")
    public void navigateToMensWatches() throws InterruptedException {
        Thread.sleep(5000);
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.gotoMensWatches();
    }
}
