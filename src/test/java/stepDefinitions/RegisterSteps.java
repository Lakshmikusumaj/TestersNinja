package stepDefinitions;
               
    import java.time.Duration;

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
		    
		    public RegisterSteps() {
		        driver = DriverFactory.getDriver();
		        registrationPage = new RegisterPage(driver); 
		    }
	 // ---------------------scenario-0-----------------------------R00//
		    @Given("User open DSPortal home page")
		    public void user_open_dsportal_home_page() {
		    //driver=DriverFactory.getDriver();
	   //	registrationPage=new RegisterPage(driver);

		    	//registrationPage.getintohomepage();
		    }

		    @When("the user clicks on Register button link")
		    public void the_user_clicks_on_register_button_link() {
	 //       RegistrationPage = new RegisterPage(driver);
		       registrationPage.clickRegisterLink();
		    }

		    @Then("the register page should be displayed")
		    public void the_register_page_should_be_displayed() {
		        //Assert.assertTrue(registrationPage.isRegistrationPageDisplayed());
		    }
//-------------------------scenario-1----------------------------R01//
		    @Given("the user is in registration page")
		    public void the_user_is_in_registration_page() {
		    	 registrationPage.clickRegisterLink();
		    //    RegistrationPage = new RegisterPage(driver);
		        //driver.get("https://dsportal.com/register"); // replace if needed
		    }
		    
		    

@When("the user enters username {string} password {string} and  confirmPassword {string}")
public void the_user_enters_username_password_and_confirm_password(String username, String password, String confirmpassword) {
		        registrationPage.enterUsername(username);
		        registrationPage.enterPassword(password);
		        registrationPage.enterConfirmPassword(confirmpassword);  
		        registrationPage.clickRegisterButton(); 
		        //String message = username.getAttribute("validationMessage");

		        //Assert.assertTrue(message.contains("Please fill out this field"));
		    }

		    @Then("the user should see a success message")
		    public void the_user_should_see_a_sucess_message() {
		    	registrationPage.clickAlertR();
		    	//registrationPage.getPasswordValidationMessage();
		    	//String message = username.getAttribute("validationMessage");

		        //Assert.assertTrue(message.contains("Please fill out this field"));
		       // Assert.assertTrue(registrationPage.isSuccessMessageDisplayed());
		    }
//--------------------------scenario-2==============================R02//
		    @Given("the user is on the registration page")
		    public void the_user_is_on_the_registration_page() { 
			       registrationPage.clickRegisterLink();

		        
		    }

		    @When("the user enters {string} and {string} and  confirmPassword {string}")
		    public void the_user_enters_and_and_confirm_password(String username, String password, String confirmpassword) {
		    	registrationPage.enterUsername(username);
		        registrationPage.enterPassword(password);
		        registrationPage.enterConfirmPassword(confirmpassword);
		        registrationPage.clickRegisterButton();
		       // String message = username.getAttribute("validationMessage");
		    	//System.out.println(message);
		    }
		    @Then("the system displays {string}")
		    public void the_system_displays(String message) {
		    	registrationPage.getConfirmPasswordValidationMessage();
		    	registrationPage.getPasswordValidationMessage();
		    	registrationPage.getUsernameValidationMessage();
		    	//String message = username.getAttribute("validationMessage");
		    	//System.out.println(message);
		   // String actualMessage = registrationPage.getPasswordErrorMessage();
		      //  Assert.assertTrue(actualMessage.contains(message));
		    	//Assert.assertTrue(registrationPage.getPasswordErrorMessage().contains(message));
		    	
		    }

		    
		   /* @When("the user enters 12345 into the passwordfield")
		    public void the_user_enters_12345_into_the_passwordfield() {
		        registrationPage.enterPassword("12345");
		        registrationPage.enterConfirmPassword("12345");
		        registrationPage.clickRegisterButton();
		    }

		    @Then("the system displays password too weak")
		    public void the_system_displays_password_too_weak() {
		  //      Assert.assertEquals(
		//                "Password too weak",
		 //               registrationPage.getPasswordErrorMessage()
		//        );}*/
		    
//==================================scenario-4============================R03//
		   /* @When("the user enters {string} and  {string} into the password field")
		    public void the_user_enters_and_into_the_password_field(String username, String password) {
		    	registrationPage.enterUsername(username);
		        registrationPage.enterPassword(password);
		        registrationPage.enterConfirmPassword(password);
		        registrationPage.clickRegisterButton();
		        //String message = username.getAttribute("validationMessage");
		    	//System.out.println(message);
		    }

		    @Then("the system displays password fied empty")
		    public void the_system_displays_password_fied_empty() {
		    	//String message = username.getAttribute("validationMessage");
		    	//System.out.println(message);
		        Assert.assertEquals(
		                "Password field empty",
		                registrationPage.getPasswordErrorMessage()
		       );
		    }*/
		}
	    
		   
	       
	   


	   
	       


