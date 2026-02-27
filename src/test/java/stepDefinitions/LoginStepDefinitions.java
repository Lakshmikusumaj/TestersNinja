package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.ExcelReader;

public class LoginStepDefinitions {
    WebDriver driver;
    long startTime;
    long endTime;
    boolean loginStatus = true;
    
    // Excel related
    static Map<String, Map<String, String>> testData;
    LoginPage loginPage;

//    @Given("User launches the browser and navigates to the login page")
//    public void user_launches_the_browser_and_navigates_to_the_login_page() {
//    	
//    }

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
    	loginPage = new LoginPage();
    }
    
    @Given("Login data")
    public void login_data() {
    	if (testData == null) {
            testData = ExcelReader.getLoginData();
        }
    }

    @When("Enters username and password for testcase {string} and clicks login button")
    public void enters_username_and_password_for_testcase_and_clicks_login_button(String testCaseName) {
    	String username = testData.get(testCaseName).get("Username");
        String password = testData.get(testCaseName).get("Password");
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("Login result should be as expected for the testcase {string}")
    public void login_result_should_be_as_expected(String testCaseName) {
        String expectedResult = testData.get(testCaseName).get("ExpectedResult");
        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
            Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        }
    }
    
    @When("User enters username and password and clicks login button")
    public void user_enters_username_and_password_and_clicks_login_button() {
    	//loginPage.enterUsername("Test_01");
       // loginPage.enterPassword("Sdet@2025");
        loginPage.successfulLogin();
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
    	Assert.assertTrue(loginPage.isLoginSuccessful());
    }
                     //performance testing//
    
    @When("User enters valid username and password and clicks login button")
    public void user_enters_valid_credentials_and_clicks_login() {
    	startTime = System.currentTimeMillis();
    	 loginPage.successfulLogin();
    }
    @Then("Login response time should be less than {int} seconds")
    public void login_response_time_should_be_less_than_seconds(Integer maxSeconds) {

        loginPage.waitForSuccessfulLogin(); // wait till login completes

        endTime = System.currentTimeMillis(); //  End time

        long responseTime = (endTime - startTime) / 1000;

        System.out.println("Login Response Time: " + responseTime + " seconds");

        Assert.assertTrue(
                "Login response time exceeded acceptable limit!",
                responseTime <= maxSeconds
        );
    }
    
 // LOGIN BUTTON ENABLE SCENARIO
    

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("Test_01");
        loginPage.enterPassword("Sdet@2025");
    }

    @Then("Login button should be enabled")
    public void login_button_should_be_enabled() {

        boolean isEnabled = loginPage.isLoginButtonEnabled();

        Assert.assertTrue("Login button is not enabled", isEnabled);
    }

    
    // PASSWORD MASK SCENARIO
    

    @When("User enters password")
    public void user_enters_password() {
        loginPage.enterPassword("Sample@123");
    }

    @Then("Password should be displayed in masked format")
    public void password_should_be_displayed_in_masked_format() {

        String fieldType = loginPage.getPasswordFieldType();

        Assert.assertEquals("Password field is not masked",
                "password",
                fieldType);
    }

    
    // INVALID LOGIN ERROR MESSAGE
    

    @When("User enters invalid username and invalid password and clicks login button")
    public void user_enters_invalid_credentials_and_clicks_login() {

        loginPage.enterUsername("wrongUser");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLogin();
    }

    @Then("Error message Invalid Username and Password should be displayed")
    public void error_message_invalid_username_and_password_should_be_displayed() {

        boolean isErrorDisplayed = loginPage.isLoginErrorDisplayed();

        Assert.assertTrue(
                "Expected error message not displayed",
                isErrorDisplayed
        );
    }
}
    



