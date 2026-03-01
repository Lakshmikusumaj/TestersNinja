
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
//0003
	@Given("User is on the Introduction page")
	public void user_is_on_the_introduction_page() {
	    
	}

	@When("User click on Practice Questions")
	public void user_click_on_practice_questions() {
	   linkedlistpage.clickPractice();
	}

	@Then("User should redirected to Practice Questions")
	public void user_should_redirected_to_practice_questions() {
	   
	}
//0004
	@Given("User is on the Introduction page in linkedlist")
	public void user_is_on_the_introduction_page_in_linkedlist() {
	   
	}

	@When("User clicks Try Here and enter {string} on respective Introduction page in linkedlinst")
	public void user_clicks_try_here_and_enter_on_respective_introduction_page_in_linkedlinst(String here1) {
	 // String here1 =null;
		linkedlistpage.here(here1);
	    linkedlistpage.clickRunButton();
	    
	}

	@Then("User should be redirected to Try Editor page with Run button in the respective link of linkedlist")
	public void user_should_be_redirected_to_try_editor_page_with_run_button_in_the_respective_link_of_linkedlist() {
	   
	}


}


       