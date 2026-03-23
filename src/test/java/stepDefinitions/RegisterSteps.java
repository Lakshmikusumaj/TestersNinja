package stepDefinitions;
               
    import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.WebDriverWait;

	//import com.aventstack.extentreports.util.Assert;

	import factory.DriverFactory;
	import io.cucumber.java.en.Given; 
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import pageObjects.RegisterPage;

	public class RegisterSteps {
		
		WebDriver driver;
		    RegisterPage registrationPage;
		    private static final Logger logger = LogManager.getLogger(RegisterSteps.class); 
		    public RegisterSteps() {
		        driver = DriverFactory.getDriver();
		        registrationPage = new RegisterPage(driver); 
		    }
	 // ---------------------scenario-0-----------------------------R00//
		    @Given("User open DSPortal home page")
		    public void user_open_dsportal_home_page() {
		    	logger.info("*********Getstarted dsportal**********");
		    
		    }

		    @When("the user clicks on Register button link")
		    public void the_user_clicks_on_register_button_link() {
		       registrationPage.clickRegisterLink();
		    }

		    @Then("the register page should be displayed")
		    public void the_register_page_should_be_displayed() {
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

		    
		   
		}
	    
		   
	       
	   


	   
	       


