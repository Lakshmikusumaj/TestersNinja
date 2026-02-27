package factory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.ConfigReader;

public class DriverFactory { 

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger logger = LogManager.getLogger(DriverFactory.class);


    //public static WebDriver getDriver() {
     //   return driver.get();
   // }

   /* public static void initDriver(String browser) {
    	if (browser == null) {
            browser = "chrome";
        }*/
public static void initDriver() {
	
    String browser = ConfigReader.getProperty("browser");
	String url =ConfigReader.getProperty("url").toString();
	logger.info("Running in :"+browser.toLowerCase()+">browsers");
    switch (browser.toLowerCase()) {

        case "chrome":
        	
            //WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            logger.info("launching chrome browser");
            break;

        case "edge":
           // WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
            logger.info("launching edge browser");
            break;

        case "firefox":
           // WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            break;

        default:
            throw new RuntimeException("Browser not supported: " + browser);
    }
    		

     
    		//driver.get(url);
getDriver().get(url);
getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    getDriver().manage().window().maximize();
    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
       
       /* else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
        }
       // else if (browser.equalsIgnoreCase("firefox")) {
         //   WebDriverManager.firefoxdriver().setup();
         //   driver.set(new FirefoxDriver());
       // }
        else {
            throw new RuntimeException("Browser not supported");
        }

        // VERY IMPORTANT → only after driver.set()
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }*/

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
   