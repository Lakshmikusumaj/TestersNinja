package stepDefinitions;



import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TryEditorPage;
import pageObjects.graphpages;
import utilities.ExcelReader;

public class GrpahsSteps {

    private static final Logger logger = LogManager.getLogger(GrpahsSteps.class); 

		WebDriver driver = DriverFactory.getDriver();
		graphpages graphpage = new graphpages(driver);
	    static Map<String, Map<String, String>> GraphTestData;
	  	 TryEditorPage tryEditorPage = new TryEditorPage(driver);



		//====================================== Graph_0001
		@Given("User is logged in to the DSAlgo portal and on graph page")
		public void user_is_logged_in_to_the_ds_algo_portal_and_on_graph_page() {
			logger.info("*************GRAPH*****************");
			graphpage.clickGetStarted();
		}

		@When("User clicks {string} link in graph page")
		public void user_clicks_link_in_graph_page(String topic) {
            logger.info("********topicName******",topic);
			graphpage.clickTopic(topic);
		}

		@Then("user should be redirected to {string} graph page")
		public void user_should_be_redirected_to_graph_page(String destinationPage) {
			String actualTitle = graphpage.getPageTitle();
			logger.info("Actual Title is " + actualTitle + " Excpected Title is -" + destinationPage);
			Assert.assertTrue(actualTitle.contains(destinationPage), "Actual title doesnt match with expected page title");
		}
//=================================================Graph_0002
		@Given("User is on {string} page in Graph module")
		public void user_is_on_page_in_graph_module(String Module) {
			
			graphpage.clickTopic(Module);
		}

		@When("User clicks Try Here button on respective topics covered link in graph")
		public void user_clicks_try_here_button_on_respective_topics_covered_link_in_graph() {
			graphpage.clickTryHere();
		}

		@Then("User should be redirected to Try Editor page with Run button in the respective link of graph module")
		public void user_should_be_redirected_to_try_editor_page_with_run_button_in_the_respective_link_of_graph_module() {
			Assert.assertTrue(graphpage.isButtonDisplayed(), "Run button is not displayed");
		}

	//=============================================Graph_0003
		@Given("User try editor page of graph")
		public void user_try_editor_page_of_graph() {
			logger.info("******EXCEL DATA DRIVEN******");
			graphpage.navigateToTryHere();
	        GraphTestData = ExcelReader.getDataForSheet("ArrayData");		


		}

		@When("User enters {string} and clciks on the run button")
		public void user_enters_and_clciks_on_the_run_button(String testCaseName) {
			String pythonCode = GraphTestData.get(testCaseName).get("PythonCode");
	    	
		    tryEditorPage.enterCode(pythonCode);
		    tryEditorPage.clickRun();
		}

		@Then("user should see {string}")
		public void user_should_see(String expectedResult) {
			logger.info("*************Alert text:**********"  +expectedResult);
			//arrayPage.getOutput(); 
			try {
	    	    Alert alert = driver.switchTo().alert();
	    	    String alertText = alert.getText();
	    	  logger.info("******Alert text:******* " + alertText);
	    	    alert.accept();

	    	    Assert.assertTrue(alertText.contains(expectedResult));

	    	} catch (NoAlertPresentException e) {
	    	    String actualOutput = graphpage.getOutput();
	    	    Assert.assertEquals(actualOutput.trim(), expectedResult);
	    	}
		}
	//===============================================Graph_0004

	@Given("the user is on the Graph page")
	public void the_user_is_on_the_graph_page() {
	   
     logger.info("******PRACTICE QUESTIONS******");
     
	}

	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String testCaseName) {
		
	    graphpage.clickPracticalQuestions();

	    
	}

	@Then("the user should see the {string}")
	public void the_user_should_see_the(String topicTitle) {
		
		String expectedTitle =topicTitle;
        String actualTitle =graphpage.getPageTitle();
        Assert.assertEquals(expectedTitle ,actualTitle);
       
		

	}
		

}
