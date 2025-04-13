package com.mvmt.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;


public class Base {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties prop;
    public static final Logger log = Logger.getLogger(Base.class);
    public static boolean initialized = false;
    public boolean createdChromeDriver = false;
    public boolean createdFirefoxDriver = false;

    public Base(){
        if(!initialized){
            System.setProperty("webdriver.chrome.silentOutput", "true");
            try{
                FileInputStream fis = new FileInputStream("/Users/topb/Desktop/Automation Testing/Web Testing/MVMT_Automation/src/main/java/com/mvmt/config/config.properties");
                prop = new Properties();
                prop.load(fis);
                initialized = true;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @Parameters("browser")
    public void initialization(String browser){
        WebDriver webDriver;
        String selectedUrl = prop.getProperty("url");
        log.info(browser+" Browser is up and ready to be loaded");
        if(browser.equals("chrome")){
            createdChromeDriver = true;
            System.setProperty("webdriver.chrome.driver","/Users/topb/Documents/seleniumDrivers/chromedriver");
            webDriver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            createdFirefoxDriver = true;
            System.setProperty("webdriver.gecko.driver","/Users/topb/Documents/seleniumDrivers/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-private");  // Open in private browsing mode
            webDriver = new FirefoxDriver(options);
        }else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Setting up the WebDriver for the current thread (test case)
        driver.set(webDriver);

        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Opening website "+selectedUrl+" for automation testing");
        webDriver.get(selectedUrl);
    }
}
