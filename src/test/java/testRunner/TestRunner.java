package testRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/test/resources/features",
	glue = { "stepDefinitions", "hooks" },
	tags = "@Array", 
	plugin = { "pretty", 
			  "html:target/cucumber-reports/cucumber.html",
			  // "json:target/cucumber-reports/cucumber.json",
			  //"com.aventstack.chaintest.plugins.ChainTestCucumberListener:target/chaintest-report",
			  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			},
	monochrome = true, 
	publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeTest
	@Parameters("browser")
	public void browserSetup(@Optional("chrome") String browser) {
		DriverFactory.setBrowser(browser);
	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios(); 
	}
}
