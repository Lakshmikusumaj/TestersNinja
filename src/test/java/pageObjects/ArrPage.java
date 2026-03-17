package pageObjects;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
//Log4j2 imports
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ArrPage  {

    private static final Logger logger = LogManager.getLogger(ArrPage.class); 



          public ArrPage(WebDriver driver) {  
                   this.driver = driver;
          }        

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
    private By editor1=By.xpath("//div[contains(@class,'CodeMirror')]//textarea");
    private	By runButton = By.id("runButton");
    private By RunButton=By.xpath("//button[text()='Run']");
	private	By output = By.xpath("//*[@id='output']");
    private By codeText = By.xpath("//textarea[@tabindex='0']");

	       //By editor = By.id("textarea");
           // By editor= By.xpath("//div[@class='CodeMirror-code']");
	         By editor=By.xpath("//form[@id='answer_form']/div/div/div/textarea");  
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
		        
			  // driver.findElement(applicationsOfArray).click();
			   WebElement element= driver.findElement(tryHere);
			   JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("arguments[0].scrollIntoView(true);", element);
			   element.click();

		    }
		    
		    public void clickPracticeQuestions() {
		        
			     driver.findElement(arraysInPython ).click();
			     driver.findElement(practiceQuestions).click();
  
		    } 
		    public void clickQuestion(String question) {
		        driver.findElement(By.linkText(question)).click();
		        //driver.findElement(tryHere).click();
		    }
		    public void clickSearchTheArray() {
			     //driver.findElement(arraysInPython ).click();
				 driver.findElement(practiceQuestions).click();
                 driver.findElement(searchTheArray).click();
		    }

		    public void clickMaxConsecutiveOnes() {
		    	//driver.findElement(arraysInPython ).click();
			    driver.findElement(practiceQuestions).click();
		        driver.findElement(maxConsecutiveOnes).click();
		    }

		    public void clickFindNumbersWithEvenDigits() {
		    	//driver.findElement(arraysInPython ).click();
			    driver.findElement(practiceQuestions).click();
		        driver.findElement(evenDigits).click();
		    }

		    public void clickSquaresOfSortedArray() {
		    	//driver.findElement(arraysInPython ).click();
			    driver.findElement(practiceQuestions).click();
		        driver.findElement(sortedSquares).click();
		    }
		    
		    
		    // ---------------- Try Editor Methods ----------------
		    public void enterCodeInEditor(String Code) {
		        logger.info("Entering code into Try Editor: " + Code);
		       // JavascriptExecutor js = (JavascriptExecutor) driver;
			   // js.executeScript("arguments[0].CodeMirror.setValue('');" + Code);//

		    	    JavascriptExecutor js = (JavascriptExecutor) driver;

		    	    // Clear existing code completely
		    	    js.executeScript(
		    	        "document.querySelector('.CodeMirror').CodeMirror.setValue('');"
		    	    );

		    	    // Set new code from Excel
		    	    js.executeScript(
		    	        "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
		    	        Code); 
		    	    
		    	}
		    public void clearEdit() {
		    	
		    	WebElement editor = driver.findElement(By.id("editor"));
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript(
		    	    "var cm = arguments[0].nextSibling.CodeMirror;" +
		    	    "if(cm) cm.replaceRange('', {line:1, ch:15}, {line:0, ch:0});",
		    	    editor
		    	);
		    	
		    }
		    
		   
		    public WebElement getEditor() {
		        return driver.findElement(editor);
		    }
		          
		    public void clickRunButton() {
		    	driver.findElement(RunButton).click();
		    }

		    public String getOutput() {
		    	//return output.getText();
		    	
		        
		    	
		   String result = "";  
		        try {
		            Alert alert = driver.switchTo().alert();
		            result = alert.getText();
		            System.out.println("Alert Text: " + result);
		            alert.accept();
		        } catch (NoAlertPresentException e) {
		           
		            result = driver.findElement(output).getText();  
		            System.out.println("Editor Output: " + result);
		        }

		        return result;
		    
		    }
		    public void submit() {
		    	driver.findElement(By.xpath("//input[@type='submit']")).click();
		    }
		    
		    	public String getPageTitle() {
		    	    return driver.getTitle();   // get the page title
		    	}
		    	public static void TextIndentation(WebDriver driver, WebElement pythonElement, int row, int space,boolean flag) { 
		    		
			    	Actions action = new Actions(driver); // Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL; 
			    	 for(int i=1;i<=row;i++) {
			    		 action.sendKeys(Keys.ARROW_UP).keyUp(Keys.SHIFT).perform();
			    		 for(int j=1;j<=space;j++) { 
			    			 if(i==1 && flag)
			    				// action.sendKeys(Keys.BACK_SPACE).perform();
			    			// else 
			    				 action.sendKeys(Keys.DELETE).perform();
			    			 } } }	
		    
		
}



