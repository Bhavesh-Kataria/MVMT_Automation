package com.mvmt.runners;

import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/addtocart_flow.feature",  // Path to your .feature file or folder
        glue = {"com.mvmt.stepdefs"},  // Package where your step definition classes are located
        plugin = {"pretty", "html:target/cucumber-report.html"},  // Output formats (console and HTML report)
        monochrome = true  // Clean console output
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests{
}
