package stepDefinitions;
               
    import java.time.Duration;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.aventstack.extentreports.util.Assert;

	import factory.DriverFactory;
	import io.cucumber.java.en.Given; 
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utilities.ExcelReader;

	public class RegisterSteps {
	    LoginPage loginPage = new LoginPage();

		WebDriver driver;
		    RegisterPage registrationPage;
		    private static final Logger logger = LogManager.getLogger(RegisterSteps.class); 

		    static Map<String, Map<String, String>> RtestData;


		    public RegisterSteps() {
		        driver = DriverFactory.getDriver();
		        registrationPage = new RegisterPage(driver); 
		    }
	 // ---------------------scenario-0-----------------------------R00//
		    @Given("User open DSPortal home page")
		    public void user_open_dsportal_home_page() {
		    	logger.info("*********Registration**********");
		    
		    }

		    @When("the user clicks on Register button link")
		    public void the_user_clicks_on_register_button_link() {
		       registrationPage.clickRegisterLink();
		    }

		    @Then("the register page should be displayed")
		    public void the_register_page_should_be_displayed() {
		    	/*logger.info("Checking if the registration page is displayed...");
		        
		        boolean isDisplayed = registrationPage.isRegistrationPageDisplayed();
		        logger.info("Registration page displayed: {}", isDisplayed);
		        
		        Assert.assertTrue(isDisplayed, "Registration page is not displayed");
		        
		        logger.info("Registration page verification completed successfully.");*/
		    	Assert.assertTrue(registrationPage.isRegistrationPageDisplayed());
		    }
		    
//-------------------------scenario-1----------------------------R01//
		    @Given("the user is in registration page")
		    public void the_user_is_in_registration_page() {
		    	
		    	 registrationPage.clickRegisterLink();
		    
		    }
		    
		    

@When("the user enters username {string} password {string} and  confirmPassword {string}")
public void the_user_enters_username_password_and_confirm_password(String username, String password, String confirmpassword) {
		        registrationPage.enterUsername(username);
		        registrationPage.enterPassword(password);
		        registrationPage.enterConfirmPassword(confirmpassword);  
		        registrationPage.clickRegisterButton(); 
		        
		    }

@Then("the user should see a {string} message")
public void the_user_should_see_a_message(String destinationTitle) {
		    	
		    	
		    	registrationPage.clickAlertR();
		    	
		    	
		    }
//--------------------------scenario-2==============================R02//
		    @Given("the user is on the registration page")
		    public void the_user_is_on_the_registration_page() { 
		    	
			       registrationPage.clickRegisterLink();

		        
		    }

		    @When("the user enters {string} and {string} and confirmPassword {string}")
		    public void the_user_enters_and_and_confirm_password(String username, String password, String confirmpassword) {
		    	registrationPage.enterUsername(username);
		        registrationPage.enterPassword(password);
		        registrationPage.enterConfirmPassword(confirmpassword);
		        registrationPage.clickRegisterButton();
		      
		    }
		    @Then("the system displays {string}")
		    public void the_system_displays(String message) {
		    	registrationPage.getConfirmPasswordValidationMessage();
		    	registrationPage.getPasswordValidationMessage();
		    	registrationPage.getUsernameValidationMessage();
		    	
		    }
//-------------------------Register login multi[le]
		   
		    @Given("Login data on Registerpage")
		    public void login_data_on_registerpage() {
			       registrationPage.clickRegisterLink();

		    	registrationPage.LoginClick();
		    	if (RtestData == null) {
		            RtestData = ExcelReader.getLoginData();
		        }
		    	
		    }

		    @When("Enters username and password on Registerpage {string} and clicks login button")
		    public void enters_username_and_password_on_registerpage_and_clicks_login_button(String testcaseName) {
		    	String username = RtestData.get(testcaseName).get("Username");
		        String password = RtestData.get(testcaseName).get("Password");
		        loginPage.enterUsername(username);
		        loginPage.enterPassword(password);
		        loginPage.clickLogin();
		        
		        
		       
		    }

		    @Then("Login results should be as expected for the testcasename {string}")
		    public void login_results_should_be_as_expected_for_the_testcasename(String testCaseName) {
		    	 String expectedResult = RtestData.get(testCaseName).get("ExpectedResult");
		         if (expectedResult.equalsIgnoreCase("success")) {
		             Assert.assertTrue(loginPage.isLoginSuccessful());
		         } else {
		             Assert.assertTrue(loginPage.isLoginErrorDisplayed());
		         }

		    }



		   
		}
	    
		   
	       
	   


	   
	       


