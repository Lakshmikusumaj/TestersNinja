package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrPage;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;


public class ArraySteps  { 
  
    private static final Logger logger = LogManager.getLogger(ArraySteps.class); 

		 ArrPage arrayPage;
	  	 WebDriver driver = DriverFactory.getDriver();
	  	 TryEditorPage tryEditorPage = new TryEditorPage(driver);

	   

	    static Map<String, Map<String, String>> ArrayTestData;
		
		 public ArraySteps() {
		        arrayPage = new ArrPage(driver);
		    } 
 
     
        @Given("user clicks on Array from the home page")
		public void user_clicks_on_array_from_the_home_page() {
        	
        	logger.info("********************ARRAY MODULE*******************");
	        arrayPage.clickGetStartesArr();
	        
		}
        
 //===========================scenario-01===================       
        @When("user clicks on {string} in Arrays page")
        public void user_clicks_on_in_arrays_page(String topiclist) {
        	
          logger.info("***********TOPIC NAME:*************" +topiclist);
        	    switch(topiclist) {

        	        case "Arrays in Python":
        	            arrayPage.clickArraysInPython();
        	            break;

        	        case "Arrays Using List":
        	            arrayPage.clickArraysUsingList();
        	            break;

        	        case "Basic Operations in Lists":
        	            arrayPage.clickBasicOperationsInLists();
        	            break;

        	        case "Applications of Array":
        	            arrayPage.clickApplicationsOfArray();
        	            break;
        	    }
        	}
        	
      
        @Then("user is navigated to {string} page")
        public void user_is_navigated_to_page(String topiclist) {
        	String expectedTitle =topiclist;
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);//getpageoob
        }
  //============scenario-2==================
        @When("user clicks on {string}")
        public void user_clicks_on(String question) {
        	arrayPage.clickArraysInPython();
            arrayPage.clickPracticeQuestions();
            arrayPage.clickQuestion(question); 
        }

        @Then("user is navigated to the {string} page")
        public void user_is_navigated_to_the_page(String Destination) {
        	String expectedTitle =Destination;
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
        }

//==================Scenario3//=====================================

        @Given("user is on {string} practice question page")
        public void user_is_on_practice_question_page(String question) {
        	
        arrayPage.clickArraysInPython();
        arrayPage.clickPracticeQuestions();
        arrayPage.clickQuestion(question); 
        }

        @When("user enters {string} in try editor fixes indentation and clicks submit button Run button")
        public void user_enters_in_try_editor_fixes_indentation_and_clicks_submit_button_run_button(String code){        
        	
        arrayPage.clearEdit();
        ArrayTestData = ExcelReader.getDataForSheet("ArrayTry");	
        String pythonCode = ArrayTestData.get(code).get("PythonCode");       	    
    	tryEditorPage.enterCode(pythonCode);  
    	tryEditorPage.clickRun();
        	   
        }        
      		
	//===============Scenario4=====================================================//	
        @Given("Array Try Editor data")
        public void array_try_editor_data() {
        	
        ArrayTestData = ExcelReader.getDataForSheet("ArrayData");		
			
        }
		 
		@When("User enters python code in TryEditor for {string} and clicks Run")
		public void user_enters_python_code_in_try_editor_for_and_clicks_run(String testCaseName) {
			
	    arrayPage.clickApplicationsOfArray();
	    arrayPage.clickTryHere();
	        
	    String pythonCode = ArrayTestData.get(testCaseName).get("PythonCode");
	    	
	    tryEditorPage.enterCode(pythonCode);
	    tryEditorPage.clickRun();								 
		
		}     
		@Then("User should see the expected output for {string}")
		public void user_should_see_the_expected_output_for(String testCaseName) {
			
	    logger.info("*************Alert text:**********"  +testCaseName);
		arrayPage.getOutput(); 
		
		}


		  
}   



