package hooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.logging.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPage;

public class Hooks {

	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    WebDriver driver;
	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	 LoginPage loginPage; //= new LoginPage();

	@Before(order = 0)
	@Parameters("browser")

	public void setUp() {  
		
		logger.info("========== Test Started ==========");
		//ConfigReader.loadConfig();
		//String url =ConfigReader.getProperty("url").toString();
		//String browser =  ConfigReader.getProperty("browser");
        //driver = DriverFactory.getDriver();

		DriverFactory.initDriver(); 
		//String browser =  ConfigReader.getProperty("browser");

		//String browser =  ConfigReader.getProperty("browser");
       // driver = DriverFactory.getDriver();

		//driver = DriverFactory.getDriver();
		//driver.manage().window().maximize();
		//logger.info("the url is" +ConfigReader.getProperty("url"));
		//driver.get(url);
		logger.info("landed on to the dsalgo portal ");

	    loginPage = new LoginPage();

	}

	@Before(value = "@LaunchHome", order = 1)
	public void LaunchHome() {
		//loginPage.openPortal();
		loginPage.clickGetStarted();
		//loginPage.clickSignIn();
		logger.info("landed on to home page: ");

	}

	@Before(value = "@ValidLogin", order = 2)
	public void validLogin() {
		loginPage.clickSignIn();
		loginPage.successfulLogin();
		logger.info("successfull login landed on homepage: ");

	}

	@After
	public void tearDown(Scenario scenario) {
		logger.info("===== Test Finished =====");
       // tearDown();
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		DriverFactory.quitDriver();
	}
}
