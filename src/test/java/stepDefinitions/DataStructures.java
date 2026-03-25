package stepDefinitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrayPage;
import pageObjects.DataStructuresPages;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;

public class DataStructures{
    private static final Logger logger = LogManager.getLogger(DataStructures.class); 
    static Map<String, Map<String, String>> DSTestData;

	WebDriver driver ;
	 DataStructuresPages DSintro;

	 public DataStructures() {
	        driver = DriverFactory.getDriver();
	        DSintro = new DataStructuresPages(driver);
	    }

	
@Given("User login and clicks the DataStructures-Intoduction module from the home page")
public void user_login_and_clicks_the_data_structures_intoduction_module_from_the_home_page() {
	logger.info("************DATASTRUCTURE-INTRODUCTION************");
	DSintro.DSClickIntro();
	
}
//------------------------------scenario01
@Then("User should see page title {string}")
public void user_should_see_page_title(String Titleh4) {
	
String actualTitle = DSintro.isTitleDisplayed();
Assert.assertEquals(actualTitle.trim(), Titleh4.trim());
logger.info("==*==expectedtitle=*==*", Titleh4+"*====*actualtitle*===*" ,actualTitle);
}
    
//---------------------------------------------	scenario
@Then("User should see {string} logo")
public void user_should_see_logo(String logo) {
	String actualTitle = DSintro.islogoDisplayed();
	Assert.assertEquals(actualTitle.trim(), logo.trim());
	logger.info("==*==expectedtitle=*==*", logo+"*====*actualtitle*===*" ,actualTitle);
	} 


@Then("User should see {string} dropdown")
public void user_should_see_dropdown(String Dropdown) {
	String actualTitle = DSintro.isdropdownDisplayed();
	Assert.assertEquals(actualTitle.trim(), Dropdown.trim());
	logger.info("==*==expectedtitle=*==*", Dropdown+ "*====*actualtitle*===*" ,actualTitle);
	}


@Then("User should see {string} link")
public void user_should_see_link(String userLink) {
	String actualTitle = DSintro.islinkDisplayed();
	Assert.assertEquals(actualTitle.trim(), userLink.trim());
	logger.info("==*==expectedtitle=*==*", userLink+"*====*actualtitle*===*" ,actualTitle);
	}


@Then("User should see {string} button")
public void user_should_see_button(String userlogout) {
	String actualTitle = DSintro.isbuttonDisplayed();
	Assert.assertEquals(actualTitle.trim(), userlogout.trim());
	logger.info("==*==expectedtitle=*==*", userlogout+ "*====*actualtitle*===*" ,actualTitle);
	
}   
//----------------------------------------scenario3

@When("User clicks {string} link")
public void user_clicks_link(String topic) {
	switch(topic.trim()) {
    case "Data Structures-Introduction":
        DSintro.DSClickIntro();
        break;
    case "Time Complexity":
        DSintro.DSClickTimeComplexity();
        break;
    case "Practice Questions":
        DSintro.DSClickPracticeQ();
        break;
    default:
        throw new IllegalArgumentException("Unknown topic: " + topic);
}
}


@Then("User should be redirected to {string}")
public void user_should_be_redirected_to(String expectedTitle) {

    String actualTitle =DSintro.getPageTitle();
    Assert.assertEquals(expectedTitle ,actualTitle);
    
	logger.info("****ExpectedTITLE****", expectedTitle + "****ActualTitle****" + actualTitle);
   
}
//------------------------------4scenario
@Given("User navigates to Time Complexity page")
public void user_navigates_to_time_complexity_page() {
    DSintro.DSClickTimeComplexity();

	
}

@Then("User should see page title Time Complexity {string}")
public void user_should_see_page_title_time_complexity(String expectedTitle) {
	String actualTitle =DSintro.getPageTitle();
    Assert.assertEquals(expectedTitle ,actualTitle);
    
	logger.info("****ExpectedTITLE****", expectedTitle + "****ActualTitle****" + actualTitle);
   
}
//---------------------------------5Scenario
@Given("user navigates to the practice questions")
public void user_navigates_to_the_practice_questions() {
    //DSintro.DSClickTimeComplexity();
    DSintro.DSClickPracticeQ();


}

@Then("user should see empty page")
public void user_should_see_empty_page() {
	DSintro.getPageTitle();
}

@Then("User should see in practice Questions {string} logo")
public void user_should_see_in_practice_questions_logo(String NumpyNinja) {
	String actualTitle = DSintro.islogoDisplayed();
	Assert.assertEquals(actualTitle.trim(), NumpyNinja.trim());
	logger.info("==*==expectedtitle=*==* {}, {}, {} ",
			NumpyNinja, "*====*actualtitle*===*", actualTitle);
    
}

@Then("User should see on practice {string} dropdown")
public void user_should_see_on_practice_dropdown(String  PDropdown) {
	String actualTitle = DSintro.isdropdownDisplayed();
	Assert.assertEquals(actualTitle.trim(), PDropdown.trim());
	logger.info("==*==expectedtitle=*==* {}, {}, {} ",
			PDropdown, "*====*actualtitle*===*", actualTitle);
}

@Then("User should see on practice Question {string} link")
public void user_should_see_on_practice_question_link(String PuserLink) {
	String actualTitle = DSintro.islinkDisplayed();
	Assert.assertEquals(actualTitle.trim(), PuserLink.trim());
	logger.info("==*==expectedtitle=*==* {}, {}, {} ",
			PuserLink, "*====*actualtitle*===*", actualTitle);
}

@Then("User should see on practice Question {string} button")
public void user_should_see_on_practice_question_button(String Puserlogout) {
	String actualTitle = DSintro.isbuttonDisplayed();
	Assert.assertEquals(actualTitle.trim(), Puserlogout.trim());
	logger.info("==*==expectedtitle=*==* {}, {}, {} ",
			Puserlogout, "*====*actualtitle*===*", actualTitle);
}




//-----------------------------------------------code
@Given("User is on {string} page")
public void user_is_on_page(String page) {
        DSintro.DSClickTimeComplexity();
        DSintro.DSClickTryhere();	
	
}

@When("User clicks Try here gives the {string} and clicks Run button")
public void user_clicks_try_here_gives_the_and_clicks_run_button(String Code) {
	
logger.info("********EXCEL DATA DRIVEN********", Code);
	DSTestData = ExcelReader.getDataForSheet("ArrayData");	
    String pythonCode = DSTestData.get(Code).get("PythonCode");     
	DSintro.enterCode(pythonCode); 
	DSintro.clickRunButton();

}

@Then("User should see {string}")
public void user_should_see(String Title) {
	
	logger.info("Alert text:" ,"*******" +Title ,"*********");
	
	try {
	    Alert alert = driver.switchTo().alert();
	    String alertText = alert.getText();
	   logger.info("****Alert text:**** " + alertText);
	    alert.accept();

	    Assert.assertTrue(alertText.contains(Title));
	    

	} catch (NoAlertPresentException e) { 
	    String actualOutput = DSintro.getOutput();
	    Assert.assertEquals(actualOutput.trim(), Title);
	}
		
		
	}

}


    




