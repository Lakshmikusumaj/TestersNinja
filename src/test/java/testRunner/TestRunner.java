package testRunner;

import org.testng.ITestContext; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
  

@CucumberOptions(
	features = "src/test/resources/features",
	glue = { "stepDefinitions", "hooks" },

	tags = "@Home",
			 
	plugin = { "pretty", 
			  "html:target/cucumber-reports/cucumber.html",
			  "rerun:target/failed_scenarios.txt"  ,
 		 // "json:target/cucumber-reports/cucumber.json",
			//"com.aventstack.chaintest.plugins.ChainTestCucumberListener:target/chaintest-report",
			  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			 // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			 
			}, 
monochrome = true, 
	publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeTest
	@Parameters("browserName")
	// public void browserSetup(@Optional("chrome") String browserName)
	public void browserSetup(@Optional("chrome") String browserName, ITestContext context) {
		System.out.println("Inside the BeforeTest in runner");
		System.out.println("Browser from TestNG: " + browserName);

		if (browserName != null && !browserName.isBlank()) {
			context.setAttribute("browserName", browserName);
			System.out.println("Browser Name" + browserName);

		}
	
		
	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios(); 
	}
}
