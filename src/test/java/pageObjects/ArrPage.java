package pageObjects;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.WebDriver;


        public class ArrPage {


          public ArrPage(WebDriver driver) {
                   this.driver = driver;
          }

 private By getStartedBtn = By.xpath("//button[text()='Get Started']");
		 By array=By.xpath("//a[contains(@class,'btn-primary') and normalize-space()='Get Started']");
private	 By getStartesArr=By.xpath("//a[@href='array' and normalize-space()='Get Started']");
		    By arraysInPython = By.xpath("//a[contains(@href,'arrays-in-python')]");
		    By arraysUsingList = By.xpath("//a[contains(@href,'arrays-using-list')]");
		    By basicOperations = By.xpath("//a[text()='Basic Operations in Lists']");
		    By applicationsOfArray = By.xpath("//a[text()='Applications of Array']");
		    By tryHere =ById.xpath("//a[@href='/tryEditor']");
		    By practiceQuestions = By.xpath("//a[text()='Practice Questions']");
		    By searchArray = By.linkText("Search the Array");
		    By maxConsecutiveOnes = By.linkText("Max Consecutive Ones");
		    By evenDigits = By.linkText("Find Numbers with Even Number of Digits");
		    By sortedSquares = By.linkText("Squares of a Sorted Array");
		    By searchTheArray = By.xpath("//a[text()='Search the array']");
		   //By editor = By.id("textarea");
		   // By editor= By.xpath("//div[@class='CodeMirror-code']");
		   By editor=By.xpath("//div[contains(@class,'CodeMirror')]//textarea");
		    //By editor=By.xpath("//form[@id='answer_form']/div/div/div/textarea");
		    By runButton = By.id("runButton");
		    By output = By.xpath("//*[@id='output']");
		    
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
			    driver.findElement(applicationsOfArray).click();
			    driver.findElement(By.xpath("//a[text()='Practice Questions']")).click();

			    WebElement txt= driver.findElement(editor);
		        txt.sendKeys(Code);
		        
		    }

		    public void clickRunButton() {
		    	driver.findElement(By.xpath("//button[text()='Run']")).click();
		    }

		    public String getOutput() {
		        return driver.findElement(output).getText();
		    }
		}



