package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.StackPage;
import pageObjects.TryEditorPage;
import utilities.ExcelReader;

import java.util.List;
import java.util.Map;

public class StackStepDefinitions {
	LoginPage loginPage;

    WebDriver driver = DriverFactory.getDriver();
    StackPage stackPage = new StackPage(driver);
    TryEditorPage tryEditorPage = new TryEditorPage(driver);

    List<Map<String, String>> loginTestData;
    static Map<String, Map<String, String>> stackTestData;
    
    // ---------------- Background ----------------
    @Given("User is on the stack page")
    public void user_is_on_the_stack_page() {
//    	// driver = DriverFactory.getDriver();
//        // loginPage = new LoginPage(driver);
//         
//         loginPage.openPortal();
//         loginPage.clickGetStarted();
//         loginPage.clickSignIn();
//         
//         if (loginTestData == null) {
//        	 loginTestData = ExcelReader.getDataForSheet("LoginData");
//         }
//        
//         String username = loginTestData.get(0).get("Username");
//         String password = loginTestData.get(0).get("Password");
//         loginPage.enterUsername(username);
//         loginPage.enterPassword(password);
//         loginPage.clickLogin();
        stackPage.clickGetStartedStack();
    }

    // ---------------- Stack_Test01 ----------------

    @When("User clicks {string} link in Stack page")
    public void user_clicks_topic_link(String topic) {
        stackPage.clickTopic(topic);
    }

    @Then("User should be redirected to {string} stack page")
    public void user_should_be_redirected_to_page(String destinationPage) {
        Assert.assertTrue(driver.getTitle().toLowerCase()
                .contains(destinationPage.toLowerCase()));
    }

    // ---------------- Stack_Test02 ----------------
    @Given("User is on {string} page in Stack module")
    public void user_is_on_specific_stack_page(String topic) {
        stackPage.clickTopic(topic);
    }

    @When("User clicks Try Here button on respective topics covered link")
    public void user_clicks_try_here_button() {
        stackPage.clickTryHere();
    }

    @Then("User should be redirected to Try Editor page with Run button in the respective link of stack module")
    public void user_redirected_to_try_editor() {
        Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
    }

    // ---------------- Stack_Test03 (Excel Driven) ----------------
    @Given("Try Editor data")
    public void try_editor_data() {
    	if (stackTestData == null) {
    		stackTestData = ExcelReader.getEditorData();
        }
    }

    @When("User enters python code for testcase {string} and clicks Run")
    public void user_enters_python_for_testcase(String testCaseName) {
    	stackPage.clickTopic("Implementation");
    	stackPage.clickTryHere();
        
    	String pythonCode = stackTestData.get(testCaseName).get("PythonCode");
        tryEditorPage.enterCode(pythonCode);
        tryEditorPage.clickRun();
    }

    @Then("User should see the output expected for the testcase {string}")
    public void user_should_see_the_output_expected_for_the_testcase(String testCaseName) {
        String expectedOutput = stackTestData.get(testCaseName).get("ExpectedOutput");

        if (expectedOutput.equals("Success")) {
        	String actualOutput = tryEditorPage.getOutput();
        	Assert.assertEquals(expectedOutput, actualOutput);
        } else {
        	tryEditorPage.acceptAlert();
        	Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
        }
    }

    /*
    // ---------------- Stack_Test04 ----------------
    @Given("User is on error alert in try editor page of stack")
    public void user_is_on_error_alert() {
        // Alert is triggered due to invalid python code
    }

    @When("User accepts the alert on stack page")
    public void user_accepts_alert() {
        tryEditorPage.acceptAlert();
    }

    @Then("User should remain on Try Editor page of stack")
    public void user_remains_on_try_editor_page() {
        Assert.assertTrue(tryEditorPage.isRunButtonDisplayed());
    }
    */

    // ---------------- Stack_Test05 ----------------
    @Given("User is again on the Stack page")
    public void user_again_on_stack_page() {
    	stackPage.clickTopic("Implementation");
    }

    @When("User clicks Practice Questions button on stack page")
    public void user_clicks_practice_questions_button() {
        stackPage.clickPracticeQuestions();
    }

    @Then("User should see Practice Questions page of stack")
    public void user_should_see_practice_questions_page() {
        Assert.assertTrue(driver.getTitle().contains("Practice"));
    }
}
