package com.mvmt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static com.mvmt.base.Base.driver;

public class LogInPage {
    private WebDriver webDriver ;

    @FindBy(id = "login-form-email")
    WebElement emailElement;

    @FindBy(id = "login-form-password")
    WebElement passwordElement;

    @FindBy(xpath = "//button[contains(text(),'Sign in')][2]")
    WebElement signInBtnElement;

    public LogInPage() {
        webDriver = driver.get();
        PageFactory.initElements(webDriver, this);
    }

    public LogInPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void fillLoginForm(String email, String password) throws InterruptedException {

        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
        signInBtnElement.click();
        Thread.sleep(5000);
    }
}
