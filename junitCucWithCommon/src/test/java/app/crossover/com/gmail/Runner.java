package app.crossover.com.gmail;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".\\features\\validate_Sent_Email.feature" }, glue = { "StepDefinition" },plugin = {
"com.cucumber.listener.ExtentCucumberFormatter:./test-output/cucumber-reports/report.html" }, monochrome = true)
public class Runner {

@AfterClass
public static void writeExtentReport() throws InterruptedException {
Reporter.loadXMLConfig(".\\resources\\extent-config.xml");

}

}
