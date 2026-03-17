package pageObjects;

import java.time.Duration;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataStructuresPages {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 
	 public DataStructuresPages(WebDriver driver) { 
	      this.driver = driver;
	      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 }
	
	By DsIntro = By.xpath("//a[@href='data-structures-introduction' and normalize-space()='Get Started']");
	By Timecomplexity =By.xpath("//a[@href='time-complexity']");
	By practice=By.xpath("//a[@href='/data-structures-introduction/practice']");
	By TryHereDS=By.xpath("//a[@href='/tryEditor']");
	By TryHere=By.xpath("//a[contains(text(),'Try here')]");
	By TRYhereDS=By.xpath("//a[text()='Try here>>>']");
	By editor1=By.xpath("//pre[@class=' CodeMirror-line ']");
	private By editorDS = By.xpath("//div[contains(@class,'CodeMirror')]//textarea");
	private By ClickRunBtn=By.xpath("//button[@type='button']");
	private By output = By.xpath("//pre[@id='output']");

	

	
	public void DSClickIntro() {
		driver.findElement(DsIntro).click();
		
	}
	public void DSClickTimeComplexity() {
		driver.findElement(Timecomplexity).click();
		
	}

	public void DSClickPracticeQ() {
		driver.findElement(practice).click();
	}
	public void DSClickTryhere() {
		WebElement txt2=driver.findElement(TryHere);
    	//JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("arguments[0].scrollIntoView(true);", txt2);
	//txt2.click();
		//driver.findElement(TryHereDS).click();
	Actions actions = new Actions(driver);
	actions.moveToElement(txt2).perform();
	txt2.click();
	}
	public void enterCode(String Code) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(editor1));
		//driver.findElement(editorDS).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript(
            "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
            Code);
		//Actions actions = new Actions(driver);
		//actions.moveToElement).click().perform();
}
	public void clickRunButton() {
       driver.findElement(ClickRunBtn).click();
    }

	public String getResult() {

	    try {
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        System.out.println("Alert Text: " + alertText);  // print
	        alert.accept();
	        return alertText;

	    } catch (NoAlertPresentException e) {
	    	String outputText = driver.findElement(output).getText();  // get text
	        System.out.println("Output Text: " + outputText);          // print text
	        return outputText;
	        //System.out.println("Output Text: " + output);  // print


	       // return driver.findElement(output).getText();
	        
	    }
	}
    public String getOutput() {
    	WebElement txt3=driver.findElement(output);
    	txt3.click();
        return txt3.getText();
    }
    public String getPageTitle() {
    	return driver.getTitle();
    }
}

