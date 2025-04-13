package com.mvmt.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static WebDriver driver;
    private static Properties prop = new Properties();;

    public static Properties getProperties(){
        try{
            FileInputStream fis = new FileInputStream("/Users/topb/Desktop/Automation Testing/Web Testing/MVMT_Automation/src/main/java/com/mvmt/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return prop;
    }

    public static WebDriver getDriver(){
        if(driver==null){
            System.setProperty("webdriver.chrome.driver", "/Users/topb/Documents/seleniumDrivers/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void firstSteps(){
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }
}
