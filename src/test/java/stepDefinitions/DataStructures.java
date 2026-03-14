package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DataStructuresPages;

public class DataStructures{
	
	WebDriver driver ;
	 DataStructuresPages DSintro;
	 public DataStructures() {
	        driver = DriverFactory.getDriver();
	        DSintro = new DataStructuresPages(driver);
	    }
	
	
@Given("User login and clicks the DataStructures-Intoduction module from the home page")
public void user_login_and_clicks_the_data_structures_intoduction_module_from_the_home_page() {
	DSintro.DSClickIntro();
	
	
//---------------------------------------------	
    
}

@When("User clicks {string} link")
public void user_clicks_link(String topic) {
	//DSintro.DSClickIntro();
	DSintro.DSClickTimeComplexity();
	DSintro.DSClickPracticeQ();
	   	
}

@Then("User should be redirected to {string}")
public void user_should_be_redirected_to(String page) {
   
}
//-----------------------------------------------code
@Given("User is on {string} page")
public void user_is_on_page(String page) {
	//DSintro.DSClickTimeComplexity();
	if(page.equals("Time Complexity")) {
        DSintro.DSClickTimeComplexity();
    }
	
	
}

@When("User clicks Try here gives the {string} and clicks Run button")
public void user_clicks_try_here_gives_the_and_clicks_run_button(String Code) {
	//DSintro.DSClickTimeComplexity();
	DSintro.DSClickTryhere();
	//if(button.equals("Try here>>>")) {
      // DSintro.DSClickTryhere();
    //}
    


//@When("User enters {string} in the editor")
//public void user_enters_print_in_the_editor(String Code) {
	DSintro.enterCode(Code);
	DSintro.clickRunButton();
	//DSintro.enterCode("print(\"Numpy\")");
}



@Then("User should see {string}")
public void user_should_see(String Results) {
	//DSintro.getOutput();
	DSintro.getResult();
}


    
}



