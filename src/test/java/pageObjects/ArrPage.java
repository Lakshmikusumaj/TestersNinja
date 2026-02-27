package pageObjects;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
//Log4j2 imports
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ArrPage  {

    private static final Logger logger = LogManager.getLogger(ArrPage.class); 



          public ArrPage(WebDriver driver) {  
                   this.driver = driver;
          }
         // private static final Logger logger = LogManager.getLogger(ArrPage.class);

    private By getStartedBtn = By.xpath("//button[text()='Get Started']");
    private By array=By.xpath("//a[contains(@class,'btn-primary') and normalize-space()='Get Started']");
    private By getStartesArr=By.xpath("//a[@href='array' and normalize-space()='Get Started']");
    private By arraysInPython = By.xpath("//a[contains(@href,'arrays-in-python')]");
    private By arraysUsingList = By.xpath("//a[contains(@href,'arrays-using-list')]");
    private By basicOperations = By.xpath("//a[text()='Basic Operations in Lists']");
    private By applicationsOfArray = By.xpath("//a[text()='Applications of Array']");
    private By tryHere =ById.xpath("//a[@href='/tryEditor']");
    private By practiceQuestions = By.xpath("//a[text()='Practice Questions']");
    private By searchArray = By.linkText("Search the Array");
    private	By maxConsecutiveOnes = By.linkText("Max Consecutive Ones");
    private By evenDigits = By.linkText("Find Numbers with Even Number of Digits");
    private By sortedSquares = By.linkText("Squares of a Sorted Array");
    private By searchTheArray = By.xpath("//a[text()='Search the array']");
    private By editor=By.xpath("//div[contains(@class,'CodeMirror')]//textarea");
    private	By runButton = By.id("runButton");
	private	By output = By.xpath("//*[@id='output']");
	       //By editor = By.id("textarea");
           // By editor= By.xpath("//div[@class='CodeMirror-code']");
	       //By editor=By.xpath("//form[@id='answer_form']/div/div/div/textarea");  
		     WebDriver driver;
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
 
		    
            public void clickGetStartesArr() {
              driver.findElement(getStartesArr).click();
		
           }
		   
		    public void clickArraysInPython() {
		      driver.findElement(arraysInPython ).click();
		
		    }

		    public void clickArraysUsingList() {
		        driver.findElement(arraysUsingList).click();
			    
		    }

		    public void clickBasicOperationsInLists() {
		        driver.findElement(basicOperations).click();

		    }

		    public void clickApplicationsOfArray() { 
			     driver.findElement(applicationsOfArray).click();

		    }

		    public void clickTryHere() {
		        
			   driver.findElement(applicationsOfArray).click();
			   WebElement element= driver.findElement(tryHere);
			   element.click();

		    }
		    
		    public void clickPracticeQuestions() {
		        
			     driver.findElement(arraysInPython ).click();
			     driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
  
		    } 

		    public void clickSearchTheArray() {
			     driver.findElement(arraysInPython ).click();
				 driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
                 driver.findElement(searchTheArray).click();
		    }

		    public void clickMaxConsecutiveOnes() {
		    	driver.findElement(arraysInPython ).click();
			    driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
		        driver.findElement(By.linkText("Max Consecutive Ones")).click();
		    }

		    public void clickFindNumbersWithEvenDigits() {
		    	driver.findElement(arraysInPython ).click();
			    driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
		        driver.findElement(By.linkText("Find Numbers with Even Number of Digits")).click();
		    }

		    public void clickSquaresOfSortedArray() {
		    	driver.findElement(arraysInPython ).click();
			    driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();
		        driver.findElement(By.linkText("Squares of a Sorted Array")).click();
		    }

		    // ---------------- Try Editor Methods ----------------
		    public void enterCodeInEditor(String Code) {
		        logger.info("Entering code into Try Editor: " + Code);

		    	    JavascriptExecutor js = (JavascriptExecutor) driver;

		    	    // Clear existing code completely
		    	    js.executeScript(
		    	        "document.querySelector('.CodeMirror').CodeMirror.setValue('');"
		    	    );

		    	    // Set new code from Excel
		    	    js.executeScript(
		    	        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
		    	        Code
		    	    );
		    	}

		          
		    public void clickRunButton() {
		    	driver.findElement(By.xpath("//button[text()='Run']")).click();
		    }

		    public String getOutput() {
		        return driver.findElement(output).getText();
		    }
		    public String getPageTitle() {
		    	return driver.getTitle();
		    }
		}



