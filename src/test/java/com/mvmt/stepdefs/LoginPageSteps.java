package com.mvmt.stepdefs;

import com.mvmt.pages.LogInPage;
import com.mvmt.util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class LoginPageSteps {
    private Properties prop;
    private LogInPage logInPage;
    private WebDriver driver;

    @Given("user logs in")
    public void login() throws InterruptedException {
        Thread.sleep(5000);
        prop = DriverFactory.getProperties();
        driver = DriverFactory.getDriver();
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        logInPage = new LogInPage(driver);
        Thread.sleep(5000);
        logInPage.fillLoginForm(email,password);
    }

    @When("user navigates to the homepage")
    public void navigateToHome(){
        try{
            driver.navigate().to("https://www.mvmt.com/home");
            Thread.sleep(8000);
            driver.findElement(By.xpath("//div[@id='ltkpopup-close-button']/a")).click();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
