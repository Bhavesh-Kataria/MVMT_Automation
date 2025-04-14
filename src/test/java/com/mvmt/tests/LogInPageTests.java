package com.mvmt.tests;

import com.mvmt.base.Base;

import com.mvmt.pages.LogInPage;
import com.mvmt.util.ExcelUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.time.Duration;

public class LogInPageTests extends Base {
    private WebDriver webDriver;
    private LogInPage loginPage;
    private boolean flag = true;

    public LogInPageTests(){
        super();
    }

    public void cleanUp() throws InterruptedException {
        webDriver.findElement(By.xpath("//button[contains(text(),'CONTINUE ANYWAY')]")).click();
        Thread.sleep(10000);
        webDriver.findElement(By.xpath("//a[@href='#login']")).click();
        Thread.sleep(5000);
    }

    public void setUp(){
        loginPage = new LogInPage();
        webDriver = getDriver();
    }

    @Test(dependsOnMethods = "com.mvmt.tests.CreateAccountPageTests.fillFormTest")
    @Parameters("browser")
    public void fillLoginFormTest(String browser) throws InterruptedException {
        Thread.sleep(5000);
        String email;
        String password;
        if(browser.equals("chrome")){
            email = prop.getProperty("email");
            password = prop.getProperty("password");
        }else{
            email = prop.getProperty("fireemail");
            password = prop.getProperty("firepassword");
        }
        log.info("Login Page Tests Method running....");
//        if(!createdChromeDriver || !createdFirefoxDriver){
//            System.out.println("here");
//            initialization(browser);
//            log.info("Login Page Tests Method running....");
//            cleanUp();
//        }
        Thread.sleep(5000);
        setUp();
        loginPage.fillLoginForm(email,password);
        try{
            webDriver.navigate().to("https://www.mvmt.com/home");
            Thread.sleep(5000);
            webDriver.findElement(By.xpath("//div[@id='ltkpopup-close-button']/a")).click();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @DataProvider(name = "loginUsers")
    public Object[][] getUsers() {
        return ExcelUtil.getLoginData();
    }

    @Test(dataProvider = "loginUsers")
    public void multiUserFillLoginFormTest(String username, String password) throws InterruptedException {
        if(webDriver == null){
            initialization("chrome");
            webDriver = getDriver();
            cleanUp();
            loginPage = new LogInPage();
            webDriver.navigate().to("https://www.mvmt.com/login?action=login");
        }
        Thread.sleep(5000);
        loginPage.fillLoginForm(username, password);
        Thread.sleep(5000);
        webDriver.navigate().to("https://www.mvmt.com/home");
        if (flag){
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='ltkpopup-close-button']/a")
            ));
            webDriver.findElement(By.xpath("//div[@id='ltkpopup-close-button']/a")).click();
            flag = false;
        }


        HomePageTests homePageTests = new HomePageTests();
        homePageTests.gotoMensWatchesTest();

        MensWatchesPageTests mensWatchesPageTests = new MensWatchesPageTests();
        mensWatchesPageTests.selectAndAddToCartTest();
        webDriver.navigate().to("https://www.mvmt.com/login?action=login");


    }
}
