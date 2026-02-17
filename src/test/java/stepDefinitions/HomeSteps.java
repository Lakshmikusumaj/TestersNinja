
package stepDefinitions;

import java.time.Duration;

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
	
	//WebDriver driver;
	 WebDriver driver = DriverFactory.getDriver();
		//Alert alert = driver.switchTo().alert();

	HomePages HomeDS=new HomePages(driver); 
	
	@Given("user is on the DS Portal home page")
	public void user_is_on_the_ds_portal_home_page() { 
	//HomeDS.clickLaunchStartR();  
	    
		
	}
                                               //----------------------------Register Link---------------------//
	@When("user clicks on {string} link")
	public void user_clicks_on_link(String string) {
		HomeDS.clickRegisterR();
	    
	}

	@Then("user should be navigated to Register page")
	public void user_should_be_navigated_to_register_page() {
		String expectedTitle = "Registration";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
	}
	                                        //--------------------------Drop Down--------------------------//

	@When("user clicks on {string} dropdown")
	public void user_clicks_on_dropdown(String topic) {
		  HomeDS.clickDDArrayBS();
 
 
	} //-------------------------DROPDOWN SElECT ARRAY BEFORE SIGN IN--------------------//


	@Then("user should see topics of dropdown")
	public void user_should_see_topics_of_dropdown() {
		String expectedTitle = "NumpyNinja"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
	}


                                   //-------------------------DROPDOWN SElECT ARRAY BEFORE SIGN IN--------------------//

	@When("user clicks on the array  {string}")
	public void user_clicks_on_the_array(String string) {
		
	  HomeDS.clickDDArrayBS();
	  HomeDS.clickArrayR();
	}
	/*@When("user clicks on {string}")
	public void user_clicks_on(String module) {
	    HomeDS.clickModule(module);
	}*/


	@Then("user should see {string} message")
	public void user_should_see_message(String string) {
    	
	  HomeDS.clickAlertR();
		
	}   
	                                 //------------------------SIGN IN LINK---------------------------------

	@Then("user should be navigated to Login page")
	public void user_should_be_navigated_to_login_page() {
		HomeDS.clickSignInlinkR();
	 
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

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
       HomeDS.clickAlertR();
		/*String expectedTitle = "NumpyNinja";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);*/
	}

	//@Then("user should see logout option")
	//public void user_should_see_logout_option() {
		 // HomeDS.ClickLoginR();
	
 
      //HomeDS.ClickLogoutR();  
      

	   
	//} 
	//-----------------------------------DATA STRUCTURE DROP DOWN AFTER SIGN IN------------------------------

	@When("user clicks on {string} dropdown after sign in")
	public void user_clicks_on_dropdown_after_sign_in(String topic) { 
        HomeDS.clickModule(topic);
	 // HomeDS.clickArrayR();
	 // HomeDS.clickLinkedlistR();
	 // HomeDS.clickQueueR();
	 // HomeDS.clickStackR();
	  //HomeDS.clickTreeR();
	    
	}
	@Then("user should be navigated to {string} page")
	public void user_should_be_navigated_to_page(String topic) {
	   //Assert.assertTrue(driver.getTitle().contains(topic));
	   // String expected = topic.toLowerCase().replace(" ", "-");
        //Assert.assertTrue(driver.getCurrentUrl().contains(expected));

	}




	/*@Then("user should be navigated to {string} dropdown after sign in")
	public void user_should_be_navigated_to_dropdown_after_sign_in(String string) {
       // HomeDS.clickDSdropdwR();

	   // HomeDS.clickArrayR(); 
	}
	                                
                                
	@When("user clicks on {string}")
	public void user_clicks_on(String string) {
		//HomeDS.clickDSdropdwR();
		//HomeDS.clickUserPassR(string, string);
		 HomeDS.clickArrayR();
	}

	@Then("user should be navigated to Arrays page")
	public void user_should_be_navigated_to_arrays_page() {
		String expectedTitle = "Array"; 
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
	}

	@Then("user should be navigated to Linked List page")  
	public void user_should_be_navigated_to_linked_list_page() {
		//HomeDS.clickDSdropdwR();
		HomeDS.clickLinkedlistR();
       // Assert.assertTrue(driver.getTitle().contains("Linked List"));

	}

	@Then("user should be navigated to Stack page")
	public void user_should_be_navigated_to_stack_page() {
		//HomeDS.clickDSdropdwR();
		HomeDS.clickStackR();
        //Assert.assertTrue(driver.getTitle().contains("Stack"));

	}

	@Then("user should be navigated to Queue page")
	public void user_should_be_navigated_to_queue_page() {
		//HomeDS.clickDSdropdwR();
		HomeDS.clickQueueR();
	}

	@Then("user should be navigated to Tree page")
	public void user_should_be_navigated_to_tree_page() {
		//HomeDS.clickDSdropdwR();
		HomeDS.clickTreeR();
	}

	@Then("user should be navigated to Graph page")
	public void user_should_be_navigated_to_graph_page() {
		HomeDS.clickDSdropdwR();
		//HomeDS.*/
	



	
}