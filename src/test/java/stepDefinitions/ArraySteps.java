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
		// ArrPage arrayPage = new ArrPage();
	  	 WebDriver driver = DriverFactory.getDriver();
	  	 TryEditorPage tryEditorPage = new TryEditorPage(driver);

	   

	    static Map<String, Map<String, String>> ArrayTestData;
		
		 public ArraySteps() {
		        arrayPage = new ArrPage(driver);
		    } 
 
     
		 @Given("user clicks on Array from the home page")
		 public void user_clicks_on_array_from_the_home_page() {
        	
        	logger.info("**********ARRAY MODULE************");
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
        public void user_is_navigated_to_page(String expectedTitle) {
        	
        	
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        logger.info("*******ExpectedTitle******* {} ,{}, {}",expectedTitle , "*****actualTitle*****", actualTitle);

        	
        }
  //============scenario-2==================
        @When("user clicks on {string}")
        public void user_clicks_on(String question) {
        	arrayPage.clickArraysInPython();
            arrayPage.clickPracticeQuestions();
            arrayPage.clickQuestion(question); 
        }

        @Then("user is navigated to the {string} page")
        public void user_is_navigated_to_the_page(String expectedTitle) {
        	
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        logger.info("*******ExpectedTitle******* {} ,{}, {}",expectedTitle , "*****actualTitle*****", actualTitle);
        }

//==========3========Scenario3//=====================================

        @Given("user is on {string} practice question page")
        public void user_is_on_practice_question_page(String question) {
        	
        arrayPage.clickArraysInPython();
        arrayPage.clickPracticeQuestions();
        arrayPage.clickQuestion(question);
        
        }
        @When("user enters {string} in try editor fixes indentation and clicks submit button")
        public void user_enters_in_try_editor_fixes_indentation_and_clicks_submit_button(String code) {
        	
        ArrayTestData = ExcelReader.getDataForSheet("ArrayTry");
        String pythonCode = ArrayTestData.get(code).get("PythonCode");  
        
        arrayPage.clearEdit();
    	tryEditorPage.enterCode(pythonCode); 
    	tryEditorPage.submit();
    	logger.info("*******Code******* {}",pythonCode);    	   
        }	   
               
        @Then("user should see on the Array editor {string}")
        public void user_should_see_on_the_array_editor(String title) {
        	
        	String actual1=   arrayPage.getResultAfterSubmit();
       	    Assert.assertEquals(title, actual1);  
        	logger.info("*************RESULTS********* {},{},",actual1,title);

        	}
        
//--------4--------------DATA DRIVEN RUN BUTTON---------------------------------//  
        @Given("user is on Array {string} practice page")
        public void user_is_on_array_practice_page(String questionTitle) {

        	arrayPage.clickArraysInPython();
            arrayPage.clickPracticeQuestions();
            arrayPage.clickQuestion(questionTitle);
        }

        @When("user enters {string} in try editor fixes indentation and clicks Run button")
        public void user_enters_in_try_editor_fixes_indentation_and_clicks_run_button(String code) {
        	ArrayTestData = ExcelReader.getDataForSheet("ArrayTry");	
            String pythonCode = ArrayTestData.get(code).get("PythonCode");  
            arrayPage.clearEdit();
           
        	tryEditorPage.enterCode(pythonCode); 
        	tryEditorPage.clickRun();
        	
        }

        @Then("user clicks run button user should see {string}")
        public void user_clicks_run_button_user_should_see(String message) {
        	logger.info("*************RESULTS********* {}",message);

    	    String actual1 = arrayPage.getTryEditorResult();

    	    logger.info("ACTUAL: " + actual1);
    	    Assert.assertEquals(message, actual1);
        } 
	
	//===============Scenario4=====================================================//	
        @Given("Array Try Editor data")
        public void array_try_editor_data() {
        	arrayPage.clickApplicationsOfArray();
    	    arrayPage.clickTryHere();
        ArrayTestData = ExcelReader.getDataForSheet("ArrayData");		
			
        }
		 
		@When("User enters python code in TryEditor for {string} and clicks Run")
		public void user_enters_python_code_in_try_editor_for_and_clicks_run(String testCaseName) {
	        
	    String pythonCode = ArrayTestData.get(testCaseName).get("PythonCode");
	    	
	    tryEditorPage.enterCode(pythonCode);
	    tryEditorPage.clickRun();								 
		
		}     
		@Then("User should see the expected output for {string}")
		public void user_should_see_the_expected_output_for(String getResult) {
			
	    logger.info("*************Alert text:**********{}",getResult);
		try {
    	    Alert alert = driver.switchTo().alert();
    	    String alertText = alert.getText();
    	  logger.info("Alert text: " + alertText);
    	    alert.accept();

    	    Assert.assertTrue(alertText.contains(getResult));

    	} catch (NoAlertPresentException e) {
    	    String actualOutput = arrayPage.getOutput();
    	    Assert.assertEquals(actualOutput.trim(), getResult);
    	}
    		
		}


		  
}   


