package com.mvmt.stepdefs;

import com.mvmt.pages.CreateAccountPage;
import com.mvmt.util.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CreateAccountPageSteps {
    private CreateAccountPage createAccountPage;
    private WebDriver driver;
    private Properties prop;

    @Given("user creates an account")
    public void createAccount() throws InterruptedException {
        prop = DriverFactory.getProperties();
        driver = DriverFactory.getDriver();
        DriverFactory.firstSteps();
        String firstName = prop.getProperty("fName");
        String lastName = prop.getProperty("lName");
        String phone = prop.getProperty("phone");
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        createAccountPage = new CreateAccountPage(driver);
        createAccountPage.fillForm(firstName,lastName,phone,email,password);
    }
}
