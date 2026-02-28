package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

public class linkedlistpages {

	 WebDriver driver;

	    public linkedlistpages(WebDriver driver) {
	        this.driver = driver;
	    }
//locators
	    private By getStartedlinkedlist = By.xpath("//a[@href='linked-list']");
	    private By Introductionlink = By.xpath("//a[@href='introduction']");
	    private By CreatingLinkedLIstlink = By.linkText("Creating Linked LIst");
	    private By TypesofLinkedLIstlink = By.linkText("Types of Linked List");
	    private By ImplementLinkedListinPythonlink = By.linkText("Implement Linked List in Python");
	    private By Traversallink = By.linkText("Traversal");
	    private By Insertionlink = By.linkText("Insertion");
	    private By Deletionlink = By.linkText("Deletion");
	    private By PracticeQuestions = By.linkText("Practice Questions");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
	    public void clickGetStartedLlinkedlist() {
	driver.findElement(getStartedlinkedlist).click();
}
public void clickTopic(String topic) {
    switch (topic) {
        case "Introduction":
            driver.findElement(Introductionlink).click();
            break;
        case "CreatingLinkedLIstlink":
            driver.findElement(CreatingLinkedLIstlink).click();
            break;
        case "TypesofLinkedLIstlink":
            driver.findElement(TypesofLinkedLIstlink).click();
            break;
        case "ImplementLinkedListinPythonlink":
            driver.findElement(ImplementLinkedListinPythonlink).click();
            break;
        case "Traversallink":
            driver.findElement(Traversallink).click();
            break;
        case "Insertionlink":
            driver.findElement(Insertionlink).click();
            break;
            
        case "Deletionlink":
            driver.findElement(Deletionlink).click();
            break;
        case "PracticeQuestions":
            driver.findElement(PracticeQuestions).click();
            break;
    }}}     
    

