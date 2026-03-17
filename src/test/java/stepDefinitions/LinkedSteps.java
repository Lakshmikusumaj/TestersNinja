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
import utilities.ExcelReader;
import pageObjects.LinkedlistPages;


	public class LinkedSteps {
		
		//linkedlistpages.clickGetStartedLlinkedlist();
	//}
		LoginPage loginPage;
		WebDriver driver = DriverFactory.getDriver();
		LinkedlistPages linkedlistpage = new LinkedlistPages(driver);
	    TryEditorPage tryEditorPage = new TryEditorPage(driver);

	    List<Map<String, String>> loginTestData;
	   // List<Map<String, String>> linkedlistTestData;
	    static Map<String, Map<String, String>> linkedlistTestData;
		
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
		@When("User clicks Try Here button on respective topicscovered link")
		public void user_clicks_try_here_button_on_respective_topicscovered_link() {
			linkedlistpage.here();
			linkedlistpage.clickRunButton();
			
			
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

		@When("User clicks Try Here and gives {string} on respective Introduction page in linkedlinst")
		public void user_clicks_try_here_and_gives_on_respective_introduction_page_in_linkedlinst(String testCaseName) {
			if (linkedlistTestData == null) {
		        linkedlistTestData = ExcelReader.getEditorData();
		    } 

		    linkedlistpage.here();

		    Map<String,String> row = linkedlistTestData.get(testCaseName);

		    if(row == null){
		        throw new RuntimeException("Test data not found for: " + testCaseName);
		    }

		    String pythonCode = row.get("PythonCode");

		    tryEditorPage.enterCode(pythonCode);
		    tryEditorPage.clickRun();
		
			/*if (linkedlistTestData == null) {
				linkedlistTestData = ExcelReader.getEditorData();
			}
	        

		 // String here1 =null;
			linkedlistpage.here(); 
		    //linkedlistpage.clickRunButton();
		    String pythonCode = linkedlistTestData.get(testCaseName).get("PythonCode");
	        tryEditorPage.enterCode(pythonCode);
	        tryEditorPage.clickRun();*/
		}
		

		@Then("User should see the output on the tryeditor page {string}")
		public void user_should_see_the_output_on_the_tryeditor_page(String testCaseName) {
			String expectedOutput = linkedlistTestData.get(testCaseName).get("ExpectedOutput");

	        if (expectedOutput.equals("Success")) {
	        	String actualOutput = tryEditorPage.getOutput();
	        	Assert.assertEquals(expectedOutput, actualOutput);
	        } else {
	        	tryEditorPage.acceptAlert();
	        	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
	        }
		}


	}


	       


