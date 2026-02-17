package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePages {
	WebDriver driver;
	 WebDriverWait wait;
	

	public HomePages(WebDriver driver) { 
	      this.driver = driver;
	      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By LaunchGetstart=By.linkText("Get Started");
	private By RegisterHm=By.xpath("//a[@href='/register']");
	private By dropDown=By.xpath("//div[@class='nav-item dropdown show']");
	private  By DSdropdown=By.xpath("//a[@href='#']");
			By Arrays=By.linkText("Arrays");
			By Linked=By.linkText("Linked List");
			By stackHm=By.linkText("Stack");
			By QueueHm=By.linkText("Queue");
			By GraphHm=By.linkText("Graph");
   private By AlertHm=By.xpath("//div[@role='alert']");
   private By SigninHm=By.linkText("Sign in"); 
   private By usernameField = By.id("id_username");
   private By passwordField = By.id("id_password");
   private By loginBtn = By.xpath("//input[@value='Login']");
   private By logoutLink = By.xpath("//a[@href='/logout']");
   private  By errorMsg = By.xpath("//div[contains(@class,'alert')]"); 
		  //Actions action = new Actions(driver);
		

     
  public void clickLaunchStartR() { 
	  driver.findElement(LaunchGetstart).click(); 
	  
  }
    public void clickRegisterR() { 
    	driver.findElement(RegisterHm).click(); 
    	
    	
    }
    public void clickSignInlinkR() {
    	driver.findElement(SigninHm).click();
    }
    
   
    public void clickDDArrayBS() {
    	driver.findElement(DSdropdown).click();
    }
    
    
    public void clickModule(String moduleName) { 
    	    // Open dropdown first
    	
    	   
    	   wait.until(ExpectedConditions.elementToBeClickable(DSdropdown)).click();
    	    // Click module dynamically
    	    
    	   By module = By.linkText(moduleName);
           wait.until(ExpectedConditions.elementToBeClickable(module)).click();
    }
    
   
    public void clickArrayR() {
		  wait.until(ExpectedConditions.elementToBeClickable(Arrays)).click();	
    }

    
    public void clickLinkedlistR() {
		  wait.until(ExpectedConditions.elementToBeClickable(Linked)).click();
    }
    
  
    public void clickStackR(){	  
		  wait.until(ExpectedConditions.elementToBeClickable(stackHm)).click();	 
    }
    
    
    public void clickQueueR() {
		  wait.until(ExpectedConditions.elementToBeClickable(QueueHm)).click();
    }
     
    
    public void clickAlertR() { 	
       WebElement result = driver.findElement(By.xpath("/html/body/div[2]")); 
 	   String text = result.getText();
       System.out.println("Result Message: " + text);
    }
    
    
  public void ClickSigninR() {
    	driver.findElement(SigninHm).click();
    }
  
  
  public void clickUserPassR(String username, String password) {
    	driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    	driver.findElement(passwordField).clear();
    	driver.findElement(passwordField).sendKeys(password);

    }
  
  
 public void ClickLoginR() {
    	driver.findElement(loginBtn).click();
    	
    }
 
 
  public void ClickLogoutR() {
    	WebElement logout = wait.until(
    	        ExpectedConditions.visibilityOfElementLocated(
    	                By.linkText("Sign out")
    	        )
    	);
        logout.click(); 
    	System.out.println("Logout button displayed: " + logout.isDisplayed());
    }
    
	}
