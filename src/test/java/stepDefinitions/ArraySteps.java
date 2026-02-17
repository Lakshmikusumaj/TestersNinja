package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArrPage;
import utilities.ExcelReader;

	public class ArraySteps {
		 ArrPage arraypage;
		 WebDriver driver = DriverFactory.getDriver();
		   List<Map<String, String>> ArrayTestData;

		@Given("user clicks on Array from the home page")
		public void user_clicks_on_array_from_the_home_page() {
	        arraypage = new ArrPage(driver);   
	    
	    	System.out.println(driver.getTitle());
	    arraypage.clickGetStartesArr();
			String expectedTitle = "Array";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Arrays in Python button")
		public void user_clicks_on_arrays_in_python_button() {
			   arraypage.clickArraysInPython();
		}

		@Then("user is navigated to the Arrays in Python page")
		public void user_is_navigated_to_the_arrays_in_python_page() {
			String expectedTitle = "Arrays in Python";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Arrays Using List button")
		public void user_clicks_on_arrays_using_list_button() {
		    arraypage.clickArraysUsingList();
		}

		@Then("user is navigated to the Arrays Using List page")
		public void user_is_navigated_to_the_arrays_using_list_page() {
			String expectedTitle = "Arrays Using List";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Basic Operations in Lists")
		public void user_clicks_on_basic_operations_in_lists() {
		    arraypage.clickBasicOperationsInLists();
		}

		@Then("user is navigated to the Basic Operations in Lists page")
		public void user_is_navigated_to_the_basic_operations_in_lists_page() {
			String expectedTitle = "Basic Operations in Lists";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Applications of Array")
		public void user_clicks_on_applications_of_array() {
		    arraypage.clickApplicationsOfArray();
		}

		@Then("user is navigated to the Applications of Array page")
		public void user_is_navigated_to_the_applications_of_array_page() {
			String expectedTitle = "Applications of Array";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle ,actualTitle);
		}

		@When("user clicks on Try Here button")
		public void user_clicks_on_try_here_button() {
			arraypage.clickTryHere();
			}
		

		@Then("user is navigated to the Try Editor page")
		public void user_is_navigated_to_the_try_editor_page() {
			
		    
		}

		@When("user enters {string} in the Try Editor and clicks Run button")
		public void user_enters_in_the_try_editor_and_clicks_run_button(String code) {
	    	

			List<Map<String, String>> testData =
			        ExcelReader.getDataForSheet("ArrayTryEditor");

			for (Map<String, String> row : testData) {

			    String code1 = row.get("CODE");
			    String expectedResult = row.get("RESULT");

			    arraypage.clickTryHere();
			    arraypage.enterCodeInEditor(code);
			    arraypage.clickRunButton();
			}
		}
		@Then("user should see {string}")
		public void user_should_see(String result) {
			 String output = arraypage.getOutput();
		        if (result.equalsIgnoreCase("output")) {
		            Assert.assertTrue(output.length() > 0);
		        } else if (result.equalsIgnoreCase("error")) {
		            Assert.assertTrue(output.toLowerCase().contains("error"));  }
		}//---------------END--------------//

		@When("user clicks on Practice Questions")
		public void user_clicks_on_practice_questions() {
			  arraypage.clickPracticeQuestions();
		}

		@Then("user is navigated to the Practice Questions page")
		public void user_is_navigated_to_the_practice_questions_page() {
			System.out.println(driver.getTitle());
		}

		@When("user clicks on Search the Array")
		public void user_clicks_on_search_the_array() {
			arraypage.clickSearchTheArray();
			System.out.println(driver.getTitle());

		}

		@Then("user is navigated to the Search the Array question page")
		public void user_is_navigated_to_the_search_the_array_question_page() {
		    
		}

		@When("user clicks on Max Consecutive Ones")
		public void user_clicks_on_max_consecutive_ones() {
	        arraypage.clickMaxConsecutiveOnes();
			System.out.println(driver.getTitle());


		}

		@Then("user is navigated to the Max Consecutive Ones Try Editor page")
		public void user_is_navigated_to_the_max_consecutive_ones_try_editor_page() {
		   
		}

		@When("user clicks on Find Numbers with Even Number of Digits")
		public void user_clicks_on_find_numbers_with_even_number_of_digits() {
	        arraypage.clickFindNumbersWithEvenDigits();

		}

		@Then("user is navigated to the Find Numbers with Even Number of Digits editor page")
		public void user_is_navigated_to_the_find_numbers_with_even_number_of_digits_editor_page() {
		    
		}

		@When("user clicks on Squares of a Sorted Array")
		public void user_clicks_on_squares_of_a_sorted_array() {
	        arraypage.clickSquaresOfSortedArray();

		}

		@Then("user is navigated to the Squares of a Sorted Array editor page")
		public void user_is_navigated_to_the_squares_of_a_sorted_array_editor_page() {
		    
		}
		//------TryEditor--------//
		@Given("user is on the Applications of Array page")
		public void user_is_on_the_applications_of_array_page() {
	    	ArrayTestData = ExcelReader.getDataForSheet("ArrayData");		

		}
		 
		@When("user executes {string} from {string} sheet")
		public void user_executes_from_sheet(String TestCaseName, String ArrayData) {
			 arraypage.clickApplicationsOfArray();
			    arraypage.clickTryHere();
		    	ArrayTestData = ExcelReader.getDataForSheet("ArrayData");
		    	int rowIndex=0 ;
		    	String  valid = ArrayTestData.get(rowIndex).get("Valid");
		        arraypage.enterCodeInEditor(valid);
		        arraypage.clickRunButton();
		    	arraypage.getOutput();
		}

		@Then("user should see expected result")
		public void user_should_see_expected_result() {
		  
		}




		
	

	


}
