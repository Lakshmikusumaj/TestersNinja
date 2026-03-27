package stepDefinitions;


import java.util.Map;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginStepDefinitions {
    WebDriver driver;
    long startTime;
    long endTime;
    boolean loginStatus = true;
    
    private static final Logger logger = LogManager.getLogger(LoginStepDefinitions.class);
    
    // Excel related
    static Map<String, Map<String, String>> testData;
    LoginPage loginPage;


    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
    	loginPage = new LoginPage();
    	loginPage.clickSignIn();
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
        	logger.info("login is successful.");  
        	Assert.assertTrue(loginPage.isLoginSuccessful());
        } else {
        	logger.info("login failed."); 
            Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        }

    }
    
    @When("User enters username and password and clicks login button")
    public void user_enters_username_and_password_and_clicks_login_button() {
        loginPage.successfulLogin();
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
    	logger.info("login is successful."); 
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

        logger.info("Expected time is {} seconds.", maxSeconds); 
        logger.info("Actual time is {} seconds.", responseTime);

        Assert.assertTrue(
                responseTime <= maxSeconds
        );
    }
    
             // LOGIN BUTTON ENABLE SCENARIO
    

    @When("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("Testuser");
        loginPage.enterPassword("testpassword");
    }

    @Then("Login button should be enabled")
    public void login_button_should_be_enabled() {

        boolean isEnabled = loginPage.isLoginButtonEnabled();
        logger.info("login button is enabled."); 

        Assert.assertTrue(isEnabled);
    }

    
            // PASSWORD MASK SCENARIO
    

    @When("User enters password")
    public void user_enters_password() {
        loginPage.enterPassword("Sample@123");
    }

    @Then("Password should be displayed in masked format")
    public void password_should_be_displayed_in_masked_format() {

        String fieldType = loginPage.getPasswordFieldType();
        logger.info("password field is masked."); 

        Assert.assertEquals(fieldType, "password", "Password field is not masked");
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
        logger.info("login error message displayed."); 

        Assert.assertTrue(isErrorDisplayed);
    }
}
    
