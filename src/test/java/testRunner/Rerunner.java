
package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters; 

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "@target/failed_scenarios.txt",   //  failed scenarios
    glue = { "stepDefinitions", "hooks" },
    tags = "@Home",

    plugin = {
        "pretty",
        "html:target/cucumber-reports/rerun-cucumber.html",
        "json:target/cucumber-reports/rerun-cucumber.json"
    },

    monochrome = true,
    publish = true
)
public class Rerunner extends AbstractTestNGCucumberTests {
	@BeforeTest
	@Parameters("browserName")
	public void browserSetup(@Optional("chrome") String browserName, ITestContext context) {
	    context.setAttribute("browserName", browserName);
	}
}

	


