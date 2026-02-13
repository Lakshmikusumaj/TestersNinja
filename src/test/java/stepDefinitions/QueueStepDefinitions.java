package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.QueuePage;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;

import java.util.List;
import java.util.Map;

public class QueueStepDefinitions {

	LoginPage loginPage;

    WebDriver driver = DriverFactory.getDriver();
    QueuePage queuePage = new QueuePage(driver);
    TryEditorPage tryEditorPage = new TryEditorPage(driver);

    List<Map<String, String>> loginTestData;
    List<Map<String, String>> queueTestData;
    
    /* ---------- Background ---------- */

    @Given("User is on the Queue page")
    public void user_is_on_the_queue_page() {
//    	driver = DriverFactory.getDriver();
//        loginPage = new LoginPage();
//        
//        loginPage.openPortal();
//        loginPage.clickGetStarted();
//        loginPage.clickSignIn();
//        
//        if (loginTestData == null) {
//       	 loginTestData = ExcelReader.getDataForSheet("LoginData");
//        }
//       
//        String username = loginTestData.get(0).get("Username");
//        String password = loginTestData.get(0).get("Password");
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickLogin();
        queuePage.clickQueueGetStarted();
    }

    /* ---------- Queue_Test01 Topic Navigation ---------- */

    @When("User clicks {string} link in Queue page")
    public void user_clicks_topic_link(String topic) {
        queuePage.clickTopic(topic);
    }

    @Then("User should be redirected to {string} queue page")
    public void user_should_be_redirected_to_queue_page(String destinationPage) {
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
    	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
    }

    /* ---------- Queue_Test03 Excel Driven TryEditor ---------- */

    @Given("User is on TryEditor page of Queue module")
    public void user_is_on_try_editor_queue() {
    	queueTestData = ExcelReader.getDataForSheet("EditorData");
    }

    @When("User enters python code from row {int} and clicks Run in Queue module")
    public void user_enters_code_from_excel(Integer rowIndex) throws Exception {

    	queuePage.clickTopic("Queue Operations");
    	queuePage.clickTryHere();
        
    	String pythonCode = queueTestData.get(rowIndex).get("PythonCode");
        tryEditorPage.enterCode(pythonCode);
        tryEditorPage.clickRun();
    }

    @Then("User should see the output expected for the row {int} in Queue module")
    public void user_should_see_expected_output(Integer rowIndex) throws Exception {

    	 String expectedOutput = queueTestData.get(rowIndex).get("ExpectedOutput");

         if (expectedOutput.equals("Success")) {
         	String actualOutput = tryEditorPage.getOutput();
         	Assert.assertEquals(expectedOutput, actualOutput);
         } else {
         	tryEditorPage.acceptAlert();
         	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
         }
     }
    /*
   /* ---------- Alert Handling ---------- 

    @Given("User is on error alert in try editor page of Queue")
    public void user_is_on_error_alert() {
        Assert.assertTrue(tryEditorPage.isAlertPresent());
    }

    @When("User accepts the alert on queue page")
    public void user_accepts_alert() {
        tryEditorPage.acceptAlert();
    }

    @Then("User should remain on TryEditor page of Queue")
    public void user_remains_on_try_editor_queue() {
        Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("Assessment"));
    }
    */
    

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
        Assert.assertTrue(DriverFactory.getDriver().getTitle().contains("Practice"));
    }
}
