package com.mvmt.pages;

import com.mvmt.base.Base;
import com.mvmt.util.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Base {
    private WebDriver webDriver ;

    // Object Repository
    @FindBy(id = "registration-form-fname")
    WebElement firstNameElement;

    @FindBy(id = "registration-form-lname")
    WebElement lastNameElement;

    @FindBy(id = "registration-form-phone")
    WebElement phoneNumberElement;

    @FindBy(id = "registration-form-email")
    WebElement emailElement;

    @FindBy(id = "registration-form-email-confirm")
    WebElement emailConfirmElement;

    @FindBy(id = "registration-form-password")
    WebElement passwordElement;

    @FindBy(id = "registration-form-password-confirm")
    WebElement passwordConfirmElement;

    @FindBy(xpath = "//button[contains(text(),'Create Account')][last()]")
    WebElement createAccountElement;

    public CreateAccountPage(){
        webDriver = driver.get();
        PageFactory.initElements(webDriver,this);
    }

    public CreateAccountPage(WebDriver webDriver){;
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void fillForm(String firstName , String lastName , String phoneNumber , String email , String password) throws InterruptedException {
        webDriver.findElement(By.xpath("//button[contains(text(),'CONTINUE ANYWAY')]")).click();
        Thread.sleep(5000);
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        phoneNumberElement.sendKeys(phoneNumber);
        emailElement.sendKeys(email);
        emailConfirmElement.sendKeys(email);
        passwordElement.sendKeys(password);
        passwordConfirmElement.sendKeys(password);
        createAccountElement.click();
//        webDriver.navigate().to("https://www.mvmt.com/login?action=register");
        Thread.sleep(5000);
    }

}
