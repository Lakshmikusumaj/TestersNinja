package stepDefinitions;

import java.util.List;
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
import pageObjects.TryEditorPage;
import utilities.ExcelReader;

public class ArraySteps  { 
  
    private static final Logger logger = LogManager.getLogger(ArraySteps.class); 

		 ArrPage arrayPage;
	  	 WebDriver driver = DriverFactory.getDriver();
	  	TryEditorPage tryEditorPage = new TryEditorPage(driver);

	   

	    static Map<String, Map<String, String>> ArrayTestData;
		// List<Map<String, String>> ArrayTestData;
	    //ArrayTestData = ExcelReader.getDataForSheet("ArrayData");	
		 public ArraySteps() {
		        arrayPage = new ArrPage(driver);
		    } 
 
 
        @Given("user clicks on Array from the home page")
		public void user_clicks_on_array_from_the_home_page() {
	       // arraypage = new ArrPage(driver);   
	    	//System.out.println(driver.getTitle());
	        arrayPage.clickGetStartesArr();
		//	String expectedTitle = "Array";
	      //  String actualTitle = driver.getTitle();
	       // Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Arrays in Python button")
		public void user_clicks_on_arrays_in_python_button() {
		    arrayPage.clickArraysInPython();
		    //arrayPage.clickTryHere();
		} 

		@Then("user is navigated to the Arrays in Python page")
		public void user_is_navigated_to_the_arrays_in_python_page() {
			String expectedTitle = "Arrays in Python";
	        String actualTitle =arrayPage.getPageTitle();//getpageoobject
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        arrayPage.clickTryHere();
		}

		@When("user clicks on Arrays Using List button")
		public void user_clicks_on_arrays_using_list_button() {
		    arrayPage.clickArraysUsingList();
		   // arrayPage.clickTryHere();
		}

		@Then("user is navigated to the Arrays Using List page")
		public void user_is_navigated_to_the_arrays_using_list_page() {
			String expectedTitle = "Arrays Using List";
			
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        arrayPage.clickTryHere();
		}

		@When("user clicks on Basic Operations in Lists")
		public void user_clicks_on_basic_operations_in_lists() {
		    arrayPage.clickBasicOperationsInLists();
		   // arrayPage.clickTryHere();
		}

		@Then("user is navigated to the Basic Operations in Lists page")
		public void user_is_navigated_to_the_basic_operations_in_lists_page() {
			String expectedTitle = "Basic Operations in Lists";
	        String actualTitle =arrayPage.getPageTitle();//paje
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        arrayPage.clickTryHere();
		}

		@When("user clicks on Applications of Array")
		public void user_clicks_on_applications_of_array() {
		    arrayPage.clickApplicationsOfArray();
		    //arrayPage.clickTryHere();
		}

		@Then("user is navigated to the Applications of Array page")
		public void user_is_navigated_to_the_applications_of_array_page() {
			String expectedTitle = "Applications of Array";
	        String actualTitle =arrayPage.getPageTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
	        arrayPage.clickTryHere();
		}

		@When("user clicks on Try Here button")
		public void user_clicks_on_try_here_button() {
		
			 arrayPage.clickApplicationsOfArray();
			arrayPage.clickTryHere();
			}
		

		@Then("user is navigated to the Try Editor page")
		public void user_is_navigated_to_the_try_editor_page() {
		    
		}

		@When("user enters {string} in the Try Editor and clicks Run button")
		public void user_enters_in_the_try_editor_and_clicks_run_button(String code) {
			/*
			 * 
			 * 
			 * List<Map<String, String>> testData =
			 * ExcelReader.getDataForSheet("ArrayTryEditor");
			 * 
			 * for (Map<String, String> row : testData) {
			 * 
			 * String Code = row.get("CODE"); String expectedResult = row.get("RESULT");
			 * 
			 * arrayPage.clickTryHere(); arrayPage.enterCodeInEditor(code); // Use Excel
			 * value arrayPage.clickRunButton();
			 * 
			 * String actualResult = arrayPage.getOutput();
			 * Assert.assertEquals(actualResult, expectedResult); }
			 */}  
	
		
		/*@Then("user should see {string}")
		public void user_should_see(String result) {
			 String output = arrayPage.getOutput();
		        if (result.equalsIgnoreCase("output")) {
		            Assert.assertTrue(output.length() > 0);
		        } else if (result.equalsIgnoreCase("error")) {
		            Assert.assertTrue(output.toLowerCase().contains("error"));  }
		}//---------------END--------------//*/

		@When("user clicks on Practice Questions")
		public void user_clicks_on_practice_questions() {
			logger.info("*********PRACTICE QUESTIONS*********");
			  arrayPage.clickPracticeQuestions();
		}

		@Then("user is navigated to the Practice Questions page")
		public void user_is_navigated_to_the_practice_questions_page() {
		arrayPage.getPageTitle();
		}

		@When("user clicks on Search the Array")
		public void user_clicks_on_search_the_array() {
			arrayPage.clickSearchTheArray();
			System.out.println(arrayPage.getPageTitle()); 

		}

		@Then("user is navigated to the Search the Array question page")
		public void user_is_navigated_to_the_search_the_array_question_page() {
		    
		}

		@When("user clicks on Max Consecutive Ones")
		public void user_clicks_on_max_consecutive_ones() {
	        arrayPage.clickMaxConsecutiveOnes();
			System.out.println(arrayPage.getPageTitle());

		}

		@Then("user is navigated to the Max Consecutive Ones Try Editor page")
		public void user_is_navigated_to_the_max_consecutive_ones_try_editor_page() {
		   
		}

		@When("user clicks on Find Numbers with Even Number of Digits")
		public void user_clicks_on_find_numbers_with_even_number_of_digits() {
	        arrayPage.clickFindNumbersWithEvenDigits();

		}

		@Then("user is navigated to the Find Numbers with Even Number of Digits editor page")
		public void user_is_navigated_to_the_find_numbers_with_even_number_of_digits_editor_page() {
		     
		}

		@When("user clicks on Squares of a Sorted Array")
		public void user_clicks_on_squares_of_a_sorted_array() {
	        arrayPage.clickSquaresOfSortedArray();

		}

		@Then("user is navigated to the Squares of a Sorted Array editor page")
		public void user_is_navigated_to_the_squares_of_a_sorted_array_editor_page() {
		    
		}
		//------TryEditor--------//
		@Given("Array Try Editor data")
		public void array_try_editor_data() {
	    	ArrayTestData = ExcelReader.getDataForSheet("ArrayData");		
			//System.out.println(arrayPage.getPageTitle());
			//if (ArrayTestData == null) {
	    		//ArrayTestData = ExcelReader.getArrayData();
			//}
	        

		}
		 
		@When("User enters python code in TryEditor for {string} and clicks Run")
		public void user_enters_python_code_in_try_editor_for_and_clicks_run(String testCaseName) {
			arrayPage.clickApplicationsOfArray();
	    	arrayPage.clickTryHere();
	        
	    	String pythonCode = ArrayTestData.get(testCaseName).get("PythonCode");
	        tryEditorPage.enterCode(pythonCode);
	        tryEditorPage.clickRun();
			/*
									 * 
									 * // Open Try Editor arrayPage.clickTryHere(); // Read all test cases from
									 * Excel sheet ArrayTestData = ExcelReader.getDataForSheet(Arraydata);
									 * 
									 * for (Map<String, String> row : ArrayTestData) {
									 * 
									 * String testCase = row.get("TestCaseName"); String code = row.get("Code");
									 * String expectedResult = row.get("Results");
									 * System.out.println("Running test case: " + testCase);
									 * 
									 * // Enter code and run arrayPage.enterCodeInEditor(code);
									 * arrayPage.clickRunButton(); // Before fetching output try { Alert alert =
									 * driver.switchTo().alert(); logger.info("Alert appeared with text: " +
									 * alert.getText());
									 * 
									 * //System.out.println("Alert text: " + alert.getText()); alert.accept(); // or
									 * alert.dismiss() } catch (NoAlertPresentException e) { // No alert, continue
									 * logger.info("No alert appeared");
									 * 
									 * } }
									 */

		}	        
		@Then("User should see the expected output for {string}")
		public void user_should_see_the_expected_output_for(String testCaseName) {
			String expectedOutput = ArrayTestData.get(testCaseName).get("ExpectedOutput");

	        if (expectedOutput.equals("Output")) {
	        	String actualOutput = tryEditorPage.getOutput();
	        	Assert.assertEquals(expectedOutput, actualOutput);
	        } else {
	        	tryEditorPage.acceptAlert();
	        	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
	        }
		  // arrayPage.getOutput();
		  
		   //logger.info("Alert appeared with text:" , );

		}


}
