

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
import pageObjects.TreePages;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;
public class TreeSteps {
	
	 private static final Logger logger = LogManager.getLogger(TreeSteps.class); 
	 static Map<String, Map<String, String>> TreeTestData;
	WebDriver driver = DriverFactory.getDriver();
	TreePages treepage = new TreePages(driver);
	TryEditorPage tryEditorPage = new TryEditorPage(driver);
	//static Map<String, Map<String, String>> TreeTestData;
	//Tree_0001
	@Given("User is logged in to the DSAlgo portal and on Tree page")
	public void user_is_logged_in_to_the_ds_algo_portal_and_on_tree_page() {
		treepage.clickGetStarted();
	}

	@When("User clicks {string} link in Tree page")
	public void user_clicks_link_in_tree_page(String topic) {
		//treepage.clickTopic(topic);
		
			   switch(topic) {
			        case "Overview of Trees":
			       treepage.overviewoftree();    
			            break;
			        case "Terminologies":
			            treepage.terminologies();
			            break;
			        case "Types of Trees":
			            treepage.typesoftrees();
			            break;
			        case "Tree Traversals":
			            treepage.tree1();
			            break;
			        case "Traversals-Illustration":
			            treepage.traversals1();
			            break;
			        case "Binary Trees":
			            treepage.binary1();
			            break;
			        case "Types of Binary Trees":
			            treepage.types1();
			            break;
			        case "Implementation in Python":
			            treepage.imple1();
			            break;
			        case "Binary Tree Traversals":
			        	treepage.binarytree1();
			        	break;
			        case "Implementation of Binary Trees":
			        	treepage.impletrees1();
			        	break;
			        case "Applications of Binary trees":
			        	treepage.apply1();
			        	break;
			        case "Binary Search Trees":
			        	treepage.binarysearch1();
			        	break;
			        case "Implementation Of BST":
			            treepage.implementation1();
			            break;
			    }}
	@Then("user should be redirected to {string} Tree page")
	public void user_should_be_redirected_to_tree_page(String destinationTitle) {
		String expectedTitle =destinationTitle;
        String actualTitle =treepage.getPageTitle();
        logger.info("Expected title",destinationTitle);
        Assert.assertEquals(expectedTitle ,actualTitle);  
	}
	//Tree_0002
	@Given("User is on the Overview of Trees page in Tree")
	public void user_is_on_the_overview_of_trees_page_in_tree() {
	//    treepage.overviewoftree();
	
	treepage.hereT();
	TreeTestData = ExcelReader.getDataForSheet("EditorData");
	}

	@When("User clicks Try Here and enter {string} on respective Overview of Trees page in Tree")
	public void user_clicks_try_here_and_enter_on_respective_overview_of_trees_page_in_tree(String code) {
		 		  
		 		    
		 		   String pythonCode = TreeTestData.get(code).get("PythonCode");
		 	tryEditorPage.enterCode(pythonCode);
		    tryEditorPage.clickRun();
	}
	

	@Then("user should see  {string} on the tree try editor page")
	public void user_should_see_on_the_tree_try_editor_page(String testCaseName) {
	
		String expectedOutput = TreeTestData.get(testCaseName).get("ExpectedOutput");
	

		if (expectedOutput.equals("Success")) {
        	String actualOutput = tryEditorPage.getOutput();
        	logger.info("python code is valid.");
        	Assert.assertEquals(expectedOutput, actualOutput);
        } else {
        	tryEditorPage.acceptAlert();
        	logger.info("python code is invalid.");
        	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
        }
	
    	}}
