package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QueuePage {

    private WebDriver driver;

    public QueuePage(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- Locators ----------------
    private By getStartedQueueBtn = By.xpath("//button[contains(text(),'Get Started') and contains(@onclick,'queue')]");
    private By practiceQuestionsBtn = By.xpath("//a[contains(text(),'Practice Questions')]");
    private By tryHereBtn = By.xpath("//button[contains(text(),'Try Here')]");
    private By outputConsole = By.id("output"); // For JSExecutor
    private By topicLink(String topic) {
        return By.linkText(topic);
    }

    // ---------------- Methods ----------------

    // Click Get Started on Queue module
    public void clickQueueGetStarted() {
        driver.findElement(getStartedQueueBtn).click();
    }

    // Verify if on Queue page
    public boolean isOnQueuePage() {
        return driver.getCurrentUrl().toLowerCase().contains("queue");
    }

    // Click on a topic link dynamically
    public void clickTopic(String topicName) {
        driver.findElement(topicLink(topicName)).click();
    }

    // Verify if on a topic page (by page title or URL)
    public boolean isOnTopicPage(String expectedPage) {
        return driver.getTitle().toLowerCase().contains(expectedPage.toLowerCase()) ||
               driver.getCurrentUrl().toLowerCase().contains(expectedPage.toLowerCase());
    }

    // Click Try Here button on topic page
    public void clickTryHere() {
        driver.findElement(tryHereBtn).click();
    }

    // Verify if on TryEditor page
    public boolean isOnTryEditorPage() {
        return driver.getCurrentUrl().toLowerCase().contains("tryeditor");
    }

    // Click Practice Questions button
    public void clickPracticeQuestions() {
        driver.findElement(practiceQuestionsBtn).click();
    }

    // Verify if on Practice Questions page
    public boolean isOnPracticeQuestionsPage() {
        return driver.getCurrentUrl().toLowerCase().contains("practice");
    }
}
