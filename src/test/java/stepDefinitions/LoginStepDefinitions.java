package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utilities.ExcelReader;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;

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
    
    @Given("Login data for the sheet {string}")
    public void login_data_for_the_sheet(String sheetName) {
    	if (testData == null) {
            testData = ExcelReader.getDataForSheet(sheetName);
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

        endTime = System.currentTimeMillis(); // ⏱ End time

        long responseTime = (endTime - startTime) / 1000;

        System.out.println("Login Response Time: " + responseTime + " seconds");

        Assert.assertTrue(
                "Login response time exceeded acceptable limit!",
                responseTime <= maxSeconds
        );
    }
//                        // load testing//
//    @Given("Multiple users are accessing the Login page")
//    public void multiple_users_are_accessing_the_login_page() {
//
//        // Conceptual step
//        // In real scenario this is handled by performance tools
//        System.out.println("Multiple users are accessing the Login page");
//    }
//
//    @When("1000 users attempt to login simultaneously")
//    public void thousand_users_attempt_to_login_simultaneously() {
//
//        try {
//            // Example: simulate multiple login attempts
//            for (int i = 1; i <= 1000; i++) {
//               loginService.login("user" + i, "password");
//            }
//        } catch (Exception e) {
//            loginStatus = false;
//        }
//    }
//
//    @Then("System should allow successful login without failures")
//    public void system_should_allow_successful_login_without_failures() {
//
//        Assert.assertTrue(
//                "Login failed under heavy load",
//                loginStatus
//        );
//    }
    


}
