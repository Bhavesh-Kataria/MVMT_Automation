package com.mvmt.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mvmt.util.TestUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectListener implements ITestListener{
    private ExtentReports extent;
    private ExtentTest test;
    private String browserName;

    @Override
    public void onTestStart(ITestResult result) {
        // listener outputs
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        System.out.println("Test started: " + result.getName()+" on "+browser);
        //report outputs
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // This method will be invoked when the test passes
    @Override
    public void onTestSuccess(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        System.out.println("Test passed: " + result.getName()+" on "+browser);
        test.pass(result.getMethod().getMethodName()+" passed");
    }

    // This method will be invoked when the test fails
    @Override
    public void onTestFailure(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        System.out.println("Test failed: " + result.getName()+" on "+browser);
        String screenshotPath = TestUtil.takeScreenshot(result);
        test.addScreenCaptureFromPath(screenshotPath);
        test.fail(result.getThrowable());
    }

    // This method will be invoked when the test is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        System.out.println("Test skipped: " + result.getName()+" on "+browser);
        test.skip(result.getMethod().getMethodName() + " skipped.");
    }

    // This method will be invoked after all tests are executed
    @Override
    public void onFinish(ITestContext context) {
        String browser = context.getCurrentXmlTest().getParameter("browser");
        System.out.println("Test execution finished."+" on "+browser);
        extent.flush();
    }

    // This method will be invoked when the test suite is started
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started.");
        browserName = context.getCurrentXmlTest().getParameter("browser");
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String pathOfReport = "/Users/topb/Desktop/Automation Testing/Web Testing/MVMT_Automation/test-output/ExtentReport_"+browserName+"_"+timestamp;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(pathOfReport);
        sparkReporter.config().setDocumentTitle("MVMT Automation Report");
        sparkReporter.config().setReportName("MVMT Test Results");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Project", "MVMT Automation");
        extent.setSystemInfo("Tester", "Bhavesh Kataria");
        extent.setSystemInfo("Browser", browserName);
    }

}
