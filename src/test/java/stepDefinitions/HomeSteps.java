
package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory; 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 
import pageObjects.HomePages;  

public class HomeSteps { 
	 private static final Logger logger = LogManager.getLogger(HomeSteps.class); 
	 WebDriver driver = DriverFactory.getDriver();
	//Alert alert = driver.switchTo().alert();

	HomePages HomeDS=new HomePages(driver); 
	
	@Given("user is on the DS Portal home page")
	public void user_is_on_the_ds_portal_home_page() { 
	//HomeDS.clickLaunchStartR(); 
		logger.info("********HOME PAGE************");
	    
		 
	}
                                               //----------------------------Register Link---------------------//
	@When("user clicks on {string} link")
	public void user_clicks_on_link(String string) {
		logger.info("*********Registerlink********");
		HomeDS.clickRegisterR();
	    
	}

	@Then("user should be navigated to Register page")
	public void user_should_be_navigated_to_register_page() {
		String expectedTitle = "Registration";
      String actualTitle = HomeDS.getPagesTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
	}
	                                        //--------------------------Drop Down--------------------------//

	@When("user clicks on {string} dropdown")
	public void user_clicks_on_dropdown(String topic) {
		logger.info("**********DROP DOWN*********");
		  HomeDS.clickDDArrayBS();
		 // HomeDS.clickModule(topic);
 
 
	} 

	@Then("user should see topics of dropdown")
	public void user_should_see_topics_of_dropdown() {
		String expectedTitle = "NumpyNinja"; 
       String actualTitle = HomeDS.getPagesTitle();
        Assert.assertEquals(expectedTitle ,actualTitle); 
		logger.info("*********EXPECTED TITLE********* {} ,{} ,{} ", expectedTitle,"******ACTUAL TITLE******",actualTitle);

	}


                                   //-------------------------DROPDOWN SElECT ARRAY BEFORE SIGN IN--------------------//03

	@When("user clicks on the array  {string}")
	public void user_clicks_on_the_array(String string) {
		
	  HomeDS.clickDDArrayBS();
	  HomeDS.clickArrayR(); 
	}
	


	@Then("user should see {string} message")
	public void user_should_see_message(String topicTitle) {
		
		String actualMessage = HomeDS.getMessage();
	    Assert.assertEquals(actualMessage, topicTitle);
		logger.info("*********EXPECTED TITLE********* {} ,{} ,{} ", topicTitle,"******ACTUAL TITLE******",actualMessage);

		
	}   
	                                 //------------------------SIGN IN LINK---------------------------------

	@Then("user should be navigated to Login page")
	public void user_should_be_navigated_to_login_page() {
		HomeDS.clickSignInlinkR(); 
		String expectedTitle = "Login";  
	    String actualTitle = HomeDS.getPagesTitle();  
	    Assert.assertEquals(actualTitle, expectedTitle);
		logger.info("*********EXPECTED TITLE********* {} ,{} ,{} ", expectedTitle,"******ACTUAL TITLE******",actualTitle);

	}  

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) {	
		HomeDS.clickSignInlinkR();
		HomeDS.clickUserPassR(username,password);
	}

	@When("user clicks on Login button") 
	public void user_clicks_on_login_button() {
	    HomeDS.ClickLoginR();
	}

	@Then("user should see {string} successfully")
	public void user_should_see_successfully(String seeAlert) {
		
		String actualMessage = HomeDS.getMessage();
	    Assert.assertEquals(actualMessage, seeAlert);
        //HomeDS.clickAlertR();
		logger.info("*********message*********  {}", seeAlert);

        
		
	}
	//-----------------------------------DATA STRUCTURE DROP DOWN AFTER SIGN IN------------------------------

	@When("user clicks on {string} dropdown after sign in")
	public void user_clicks_on_dropdown_after_sign_in(String topic) {  
        HomeDS.clickModule(topic);
	
	    
	}
	@Then("user should be navigated to {string} page")
	public void user_should_be_navigated_to_page(String expectedTitle ) {
	
        String actualTitle =HomeDS.getPagesTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
		logger.info("*********message********* {}", expectedTitle);


	}

	
}