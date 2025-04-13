package com.mvmt.tests;

import com.mvmt.base.Base;
import com.mvmt.pages.CreateAccountPage;
import com.mvmt.pages.HomePage;
import com.mvmt.pages.LogInPage;
import com.mvmt.util.TestUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class LogInPageTests extends Base {
    private WebDriver webDriver;
    private LogInPage loginPage;

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

//    @Test
//    public void multiUserFillLoginFormTest() throws InterruptedException {
//        String userName;
//        String password;
//        if(loginPage == null){
//            initialization();
//            cleanUp();
//            loginPage = new LogInPage();
//        }
//        try {
//            FileInputStream fis = new FileInputStream("/Users/topb/Desktop/Automation Testing/Web Testing/MVMT_Automation/src/main/java/com/mvmt/testdata/MVMT_DATA.xlsx");
//            Workbook workbook = new XSSFWorkbook(fis);
//            Sheet selectedSheet = workbook.getSheet("LoginPage");
//            Iterator<Row> iterator = selectedSheet.iterator();
//            iterator.next();
//            Row currentRow;
//            boolean flag = false;
//            int count = 0;
//            while (iterator.hasNext()) {
//                currentRow = iterator.next();
//                userName = currentRow.getCell(0).getStringCellValue();
//                password = currentRow.getCell(1).getStringCellValue();
//                //already logged in then has to logout first
//                if(flag){
//                    WebElement accDropDownElement = driver.findElement(By.xpath("//div[@aria-label='dropdownMenu Account']"));
//                    TestUtil.hoverOperation(accDropDownElement);
//                    driver.findElement(By.xpath("//a[@href='https://www.mvmt.com/logout']")).click();
//                    driver.navigate().to("https://www.mvmt.com/login?action=register");
//                    Thread.sleep(5000);
//                    driver.findElement(By.xpath("//a[@href='#login']")).click();
//                    Thread.sleep(5000);
//                }
//                homePage =  loginPage.fillLoginForm(userName, password);
//                Thread.sleep(5000);
//                driver.navigate().to("https://www.mvmt.com/home");
//                if(count==0){
//                    driver.findElement(By.xpath("//div[@id='ltkpopup-close-button']/a")).click();
//                }
//                HomePageTests testObj = new HomePageTests();
//                testObj.gotoMensWatchesTest();
//                count++;
//                flag = true;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (IOException ie) {
//            ie.getStackTrace();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
