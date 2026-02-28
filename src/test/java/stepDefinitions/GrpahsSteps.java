package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.graphpages;

public class GrpahsSteps {

	WebDriver driver = DriverFactory.getDriver();
	graphpages graphpage = new graphpages(driver);

	// Graph_0001
	@Given("User is logged in to the DSAlgo portal and on graph page")
	public void user_is_logged_in_to_the_ds_algo_portal_and_on_graph_page() {
		graphpage.clickGetStarted();
	}

	@When("User clicks {string} link in graph page")
	public void user_clicks_link_in_graph_page(String topic) {

		graphpage.clickTopic(topic);
	}

	@Then("user should be redirected to {string} graph page")
	public void user_should_be_redirected_to_graph_page(String destinationPage) {
		String actualTitle = graphpage.getPageTitle();
		System.out.println("Actual Title is " + actualTitle + " Excpected Title is -" + destinationPage);
		Assert.assertTrue(actualTitle.contains(destinationPage), "Actual title doesnt match with expected page title");
	}

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

//0003
	@Given("User try editor page of graph")
	public void user_try_editor_page_of_graph() {
		System.out.println("Usert is on tryeditor page");
		graphpage.navigateToTryHere();

	}

	@When("User enters {string} and clciks on the run button")
	public void user_enters_and_clciks_on_the_run_button(String code) {
		graphpage.enterCode(code);
		graphpage.clickRunButton();
	}

	@Then("user should see {string}")
	public void user_should_see(String expectedResult) {
		System.out.println("Usert is on expected result is -:" + graphpage.getOutPutText());
		String actualResult;
		if (expectedResult == "Error") {
			actualResult = graphpage.getAlertMessage();
			Assert.assertEquals("actualResult", "SyntaxError: bad input on line 1");
		} else {
			actualResult = graphpage.getOutPutText();
			Assert.assertEquals(actualResult, expectedResult);
		}}

//0004

@Given("the user is on the Graph page")
public void the_user_is_on_the_graph_page() {
    
}

@When("the user clicks on the {string} link")
public void the_user_clicks_on_the_link(String string) {
    graphpage.clickPracticalQuestions();
    
}

@Then("the user should see the {string}")
public void the_user_should_see_the(String string) {
	String expectedTitle = "Practice Questions";
    String actualTitle =graphpage.getPageTitle();//getpageoobject
    Assert.assertEquals(expectedTitle ,actualTitle);  

}}
	


