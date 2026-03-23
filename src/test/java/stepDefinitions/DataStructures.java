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
import pageObjects.ArrPage;
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
	
	
//---------------------------------------------	scenario1
    
}

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
        //DSintro.DSClickPracticeQ();
        break;
    default:
        throw new IllegalArgumentException("Unknown topic: " + topic);
}
}


@Then("User should be redirected to {string}")
public void user_should_be_redirected_to(String destinationTitle) {
	logger.info("****TITLE****"  , destinationTitle );

	String expectedTitle =destinationTitle;
    String actualTitle =DSintro.getPageTitle();
    Assert.assertEquals(expectedTitle ,actualTitle);
	
   
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
	    System.out.println("Alert text: " + alertText);
	    alert.accept();

	    Assert.assertTrue(alertText.contains(Title));
	    

	} catch (NoAlertPresentException e) { 
	    String actualOutput = DSintro.getOutput();
	    Assert.assertEquals(actualOutput.trim(), Title);
	}
		
		
	}

}


    




