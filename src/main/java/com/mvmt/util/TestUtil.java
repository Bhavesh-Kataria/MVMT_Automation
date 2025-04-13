package com.mvmt.util;

import com.mvmt.base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends Base {
    public static void hoverOperation(WebElement elementToHover, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        try {
            Thread.sleep(4000); // 4-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String takeScreenshot(ITestResult result){
        TakesScreenshot ts = (TakesScreenshot)getDriver();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "src/test/java/com/mvmt/resources/screenshots/screenshot_for_"+result.getName()+"_"+timestamp+".png";
        File destFile = new File(path);
        try{
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        }catch (IOException e){
            e.getStackTrace();
        }
        return path;
    }
}
