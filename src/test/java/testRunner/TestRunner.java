package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "stepDefinitions",
                "hooks"
        },
        tags = "@Login",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "tech.grasshopper.extentreports.cucumber7.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        publish = true
)
public class TestRunner {
}
