//package stepDefinations;
package stepdefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import factory.Driverfactory;
import io.cucumber.java.en.Given; 
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class registersteps {
	
	WebDriver driver;
	    RegisterPage registrationPage;
  
	    @Given("User open DSPortal home page")
	    public void user_open_dsportal_home_page() {
	    driver=Driverfactory.getDriver();
   	registrationPage=new RegisterPage(driver);

	    	registrationPage.getintohomepage();
	    }

	    @When("the user clicks on Register button link")
	    public void the_user_clicks_on_register_button_link() {
 //       RegistrationPage = new RegisterPage(driver);
	       registrationPage.clickRegisterLink();
	    }

	    @Then("The register page should be displayed")
	    public void the_register_page_should_be_displayed() {
	  //      Assert.assertTrue(registrationPage.isRegistrationPageDisplayed());
	    }

	    @Given("the user is in registration page")
	    public void the_user_is_in_registration_page() {
	    //    RegistrationPage = new RegisterPage(driver);
	        driver.get("https://dsportal.com/register"); // replace if needed
	    }
	    
	    
 @When("the user fills out all registration fields correctly")
	    public void the_user_fills_out_all_registration_fields_correctly() {
	        registrationPage.enterUsername("testuser");
	        registrationPage.enterPassword("Test@1234");
	        registrationPage.enterConfirmPassword("Test@1234");
	        registrationPage.clickRegisterButton();
	    }

	    @Then("The user should see a sucess message")
	    public void the_user_should_see_a_sucess_message() {
	   //     Assert.assertTrue(registrationPage.isSuccessMessageDisplayed());
	    }

	    @When("the user enters 12345 into the passwordfield")
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
	//        );
	    }

	    @When("the user leaves password field empty")
	    public void the_user_leaves_password_field_empty() {
	        registrationPage.enterPassword("");
	        registrationPage.enterConfirmPassword("");
	        registrationPage.clickRegisterButton();
	    }

	    @Then("the system displays password fied empty")
	    public void the_system_displays_password_fied_empty() {
	   //     Assert.assertEquals(
//	                "Password field empty",
//	                registrationPage.getPasswordErrorMessage()
	//        );
	    }
	}
    
	   
       
   


   
       



