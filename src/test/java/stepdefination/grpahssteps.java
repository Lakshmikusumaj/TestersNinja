package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.graphpages;

import static org.junit.Assert.assertTrue;

public class grpahssteps {

    WebDriver driver;
    graphpages homePage;

    @Given("user navigate to page")
    public void user_navigate_to_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://your-ds-portal-url.com");
        homePage = new graphpages(driver);
    }

    @When("the pges finish loading")
    public void the_pges_finish_loading() {
        homePage.waitForHomePageToLoad();
    }

    @Then("the home page should displayed sucessfully")
    public void the_home_page_should_displayed_sucessfully()  {
        assertTrue(homePage.isHomePageDisplayed());
        driver.quit();
    }
}
