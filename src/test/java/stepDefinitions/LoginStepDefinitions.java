package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utilities.ExcelReader;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    WebDriver driver;
    LoginPage loginPage;

    // Excel related
    static List<Map<String, String>> testData;

    @Given("User launches the browser and navigates to the login page")
    public void user_launches_the_browser_and_navigates_to_the_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        
        loginPage.openPortal();
        loginPage.clickGetStarted();
        loginPage.clickSignIn();
    }

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        if (testData == null) {
            testData = ExcelReader.getDataForSheet("LoginData");
        }
    }

    @When("User enters username and password from row {int} and clicks login button")
    public void user_enters_username_and_password_from_row_and_clicks_login_button(Integer rowNumber) {        
        String username = testData.get(rowNumber).get("Username");
        String password = testData.get(rowNumber).get("Password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("Login result should be as expected for the row {int}")
    public void login_result_should_be_as_expected_for_that_row(Integer rowNumber) {
        String expectedResult = testData.get(rowNumber).get("ExpectedResult");
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
            Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        }
    }
}
