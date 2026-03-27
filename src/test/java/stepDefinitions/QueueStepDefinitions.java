package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.QueuePage;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;

import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class QueueStepDefinitions {

	LoginPage loginPage;

    WebDriver driver = DriverFactory.getDriver();
    QueuePage queuePage = new QueuePage(driver);
    TryEditorPage tryEditorPage = new TryEditorPage(driver);
    private static final Logger logger = LogManager.getLogger(QueueStepDefinitions.class);

    List<Map<String, String>> loginTestData;
    static Map<String, Map<String, String>> queueTestData;
    
    /* ---------- Background ---------- */

    @Given("User is on the Queue page")
    public void user_is_on_the_queue_page() {
        queuePage.clickQueueGetStarted();
    }

    /* ---------- Queue_Test01 Topic Navigation ---------- */

    @When("User clicks {string} link in Queue page")
    public void user_clicks_topic_link(String topic) {
        queuePage.clickTopic(topic);
    }

    @Then("User should be redirected to {string} queue page")
    public void user_should_be_redirected_to_queue_page(String destinationPage) {
    	logger.info("user should be redirected to destination page of queue."); 
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(destinationPage.toLowerCase()));
    }

    /* ---------- Queue_Test02 Try Here Navigation ---------- */

    @Given("User is on {string} page in Queue module")
    public void user_is_on_topic_page(String topic) {
        queuePage.clickTopic(topic);
    }

    @When("User clicks Try Here button on respective Topics covered of Queue module")
    public void user_clicks_try_here() {
        queuePage.clickTryHere();
    }

    @Then("User should be redirected to TryEditor page with Run button in the respective link of Queue")
    public void user_is_on_try_editor_page() {
    	logger.info("user should be redirected to try editor page with run button of destination page of queue.");
    	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
    }

    /* ---------- Queue_Test03 Excel Driven TryEditor ---------- */

    @Given("TryEditor data for Queue module")
    public void try_editor_data() {
    	if (queueTestData == null) {
    		queueTestData = ExcelReader.getEditorData();
        }
    }

    @When("User enters python code for testcase {string} and clicks Run in Queue module")
    public void user_enters_python_code_for_testcase(String testCaseName) throws Exception {

    	queuePage.clickTopic("Queue Operations");
    	queuePage.clickTryHere();
        
    	String pythonCode = queueTestData.get(testCaseName).get("PythonCode");
        tryEditorPage.enterCode(pythonCode);
        tryEditorPage.clickRun();
    }

    @Then("User should see the output expected for the testcase {string} in Queue module")
    public void user_should_see_the_output_expected_for_the_testcase(String testCaseName) throws Exception {

    	 String expectedOutput = queueTestData.get(testCaseName).get("ExpectedOutput");

         if (expectedOutput.equals("Success")) {
         	String actualOutput = tryEditorPage.getOutput();
         	logger.info("python code is valid.");
         	Assert.assertEquals(expectedOutput, actualOutput);
         } else {
         	tryEditorPage.acceptAlert();
         	logger.info("python code is invalid.");
         	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
         }
     }
   

    /* ---------- Practice Questions ---------- */

    @Given("User is on any of the queue topic page")
    public void user_is_on_any_of_the_queue_topic_page() {
    	queuePage.clickTopic("Queue Operations");
    }

    @When("User clicks Practice Questions button on queue page")
    public void user_clicks_practice_questions() {
        queuePage.clickPracticeQuestions();
    }

    @Then("User should see Practice Questions page")
    public void user_should_see_practice_questions() {
    	logger.info("user is on the practice questions page.");
        Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("Practice"));
    }
}
