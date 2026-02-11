package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class graphpages {

    WebDriver driver;
    WebDriverWait wait;

    // Example locator for home page element (update as per your app)
    By homePageBanner = By.id("home-banner");

    public graphpages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForHomePageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageBanner));
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(homePageBanner).isDisplayed();
    }
}
