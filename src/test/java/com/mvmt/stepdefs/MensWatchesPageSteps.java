package com.mvmt.stepdefs;

import com.mvmt.pages.MensWatchesPage;
import com.mvmt.util.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MensWatchesPageSteps {
    private MensWatchesPage mensWatchesPage;
    private WebDriver driver;

    @When("user selects a watch with the name \"Bourbon Blue\" and adds it to cart")
    public void searchAndSelectWatch() throws InterruptedException {
        driver = DriverFactory.getDriver();
        mensWatchesPage = new MensWatchesPage(driver);
        mensWatchesPage.selectAndAddToCart();
    }

    @Then("the cart should contain the product \"Bourbon Blue\"")
    public void checkingTheCart(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'Bourbon Blue')]")
            ));
            WebElement watch = driver.findElement(By.xpath("//p[contains(text(),'Color: Bourbon Blue')]"));
            Assert.assertTrue(watch.isDisplayed(),"Watch is not displayed");
        } catch (Exception e) {
            Assert.fail("Exception occurred while checking the watch visibility: " + e.getMessage());
        }
    }
}
