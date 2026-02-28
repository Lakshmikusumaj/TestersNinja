package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import utilities.ConfigReader;

public class Hooks {

	WebDriver driver;
	LoginPage loginPage = new LoginPage();

	@Before(order = 0)
	public void setUp() {
		ConfigReader.loadConfig();
		driver = DriverFactory.getDriver();
		//driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
	}

	@Before(value = "@LaunchHome", order = 1)
	public void LaunchHome() {
		loginPage.openPortal();
		loginPage.clickGetStarted();
		loginPage.clickSignIn();

	}

	@Before(value = "@ValidLogin", order = 2)
	public void validLogin() {
		loginPage.successfulLogin();
	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		DriverFactory.quitDriver();
	}
}
