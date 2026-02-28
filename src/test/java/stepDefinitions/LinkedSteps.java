
package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.StackPage;
import pageObjects.TryEditorPage;
import pageObjects.linkedlistpages;


public class LinkedSteps {
	
	//linkedlistpages.clickGetStartedLlinkedlist();
//}
	LoginPage loginPage;
	WebDriver driver = DriverFactory.getDriver();
	linkedlistpages linkedlistpage = new linkedlistpages(driver);
    TryEditorPage tryEditorPage = new TryEditorPage(driver);

    List<Map<String, String>> loginTestData;
    List<Map<String, String>> linkedlistTestData;
	
	@Given("User is logged in to the portal and on linkedlist page")
	public void user_is_logged_in_to_the_portal_and_on_linkedlist_page() {
		linkedlistpage.clickGetStartedLlinkedlist();
	}

	@When("User clicks {string} link in linkedlist page")
	public void user_clicks_link_in_linkedlist_page(String topic) 
 {
		linkedlistpage.clickTopic(topic);
	}

	@Then("User should be redirected to {string} linkedlist page")
	public void user_should_be_redirected_to_linkedlist_page(String destinationPage)  {
	//	Assert.assertTrue(driver.getTitle().toLowerCase()
    //            .contains(destinationPage.toLowerCase()));
		
	}
	//002
	@Given("User is on {string} page in linkedlist module")
	public void user_is_on_page_in_linkedlist_module(String string) {
	   
	}

	@Then("User should be redirected to Try Editor page with Run button in the respective link of linkedlist module")
	public void user_should_be_redirected_to_try_editor_page_with_run_button_in_the_respective_link_of_linkedlist_module() {
	    
	}



}


       