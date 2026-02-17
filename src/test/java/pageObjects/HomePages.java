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
	 // Actions action = new Actions(driver);

	public HomePages(WebDriver driver) { 
	      this.driver = driver;
	      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	 //private By getStartedBtn = By.xpath("//button[text()='Get Started']"); 
	private By LaunchGetstart=By.linkText("Get Started");
   //private By LaunchGetstart=By.xpath("//button[text()='Get Started']");
	private By RegisterHm=By.xpath("//a[@href='/register']");
	//By SignIn=By.xpath("");
	private By dropDown=By.xpath("//div[@class='nav-item dropdown show']");
			private By DSdropdown=By.xpath("//a[@href='#']");
			By Arrays=By.linkText("Arrays");
			By Linked=By.linkText("Linked List");
			By stackHm=By.linkText("Stack");
			By QueueHm=By.linkText("Queue");
			// By TreeHm=By.linkText("Tree");
			By GraphHm=By.linkText("Graph");
			
	/*private By LinkedList=By.xpath("//div[@class='nav-item dropdown show']//a[contains(text()='/linked-list']");
	private By TreeHm=By.xpath("//div[@class='nav-item dropdown show']//a[contains(text()='Tree']");
	private By QueueHm=By.xpath("//div[@class='nav-item dropdown show']//a[contains(text()='Queue']");
	private By StackHm=By.xpath("//div[@class='nav-item dropdown show']//a[contains(text()='Stack']");
   private By ArrayHm=By.xpath("//div[@class='nav-item dropdown show']//a[contains(text()='Arrays']");*/
   private By AlertHm=By.xpath("//div[@role='alert']");
   private By SigninHm=By.linkText("Sign in"); 
   private By usernameField = By.id("id_username");
   private By passwordField = By.id("id_password");
   private By loginBtn = By.xpath("//input[@value='Login']");
    //By LogoutBtn=By.xpath("//a[text()='Sign out']");
   // private By logoutLink = By.linkText("Sign out");
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
    
   // public void clickDSdropdwR(String topic) {
    //	driver.findElement(DSdropdown).click(); 
   // }
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

    	//By dropdownMenu = By.xpath("//a[contains(text(),'Data Structures')]");
 

       // By module = By.linkText(moduleName);

       // wait.until(ExpectedConditions.elementToBeClickable(DSdropdown)).click();
    
       // By module = By.linkText("Tree"); 
       // wait.until(ExpectedConditions.elementToBeClickable(module)).click();
        
       // WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable((ArrayHm)));

        // 3. Click the desired option
       // desiredOption.click();)));

        // 3. Click the desired option
       //  desiredOption.click();
       // driver.findElement(LinkedList).click();
		 /* wait.until(ExpectedConditions.elementToBeClickable(Arrays)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(Linked)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(stackHm)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(QueueHm)).click();
		 // wait.until(ExpectedConditions.elementToBeClickable()).click();

		  

		 // wait.until(ExpectedConditions.elementToBeClickable(TreeHm)).click();
	       // driver.findElement(StackHm).click();


        
    

   /* public void clickTopic(String topicName) {
        // Dynamic locator using linkText
        driver.findElement(By.linkText(topicName)).click();
    }*/
    public void clickArrayR() {
    	  //driver.findElement(LaunchGetstart).click(); 

      	//driver.findElement(DSdropdown).click();
		  wait.until(ExpectedConditions.elementToBeClickable(Arrays)).click(); 

      	//driver.findElement(Arrays).click();  
      	//driver.findElement(LinkedList).click();
      	
      }
//div[@id='yourDropdownId']//a[contains(text(), '" + optionText + "')]")));
    
   // option.click(); 


   /* WebElement dropdownDiv = driver.findElement(By.xpath("//div[@class='your-dropdown-class']"));
    dropdownDiv.click();

    // 2. Use WebDriverWait to ensure the desired option is clickable
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Your Option Text']")));

    // 3. Click the desired option
    desiredOption.click();*/

    
    public void clickLinkedlistR() {
  	 // Actions action = new Actions(driver);

    	//WebElement menu = driver.findElement(DSdropdown);
    	//menu.click();
    	//driver.findElement(DSdropdown).click();
		  wait.until(ExpectedConditions.elementToBeClickable(Linked)).click();

		 // action.moveToElement(menu).perform(); 
		// driver.findElement(LinkedList).click();
    	//driver.findElement(DSdropdown).click();

    	//driver.findElement(LinkedList).click();
    }
   /* public void clickTreeR() { 
  	 // Actions action = new Actions(driver);

    	//WebElement menu = driver.findElement(DSdropdown);
    	//menu.click();
		 // action.moveToElement(menu).perform(); 
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(TreeHm)).click();

		  //driver.findElement(By.linkText("Tree")).click();
    	//driver.findElement(DSdropdown).click();
    	//driver.findElement(DSdropdown).click();

    	//driver.findElement(TreeHm).click();
    }*/
    public void clickStackR(){
  	  //Actions action = new Actions(driver);

    	//WebElement menu = driver.findElement(DSdropdown);
    	//menu.click();
		  wait.until(ExpectedConditions.elementToBeClickable(stackHm)).click();

		  //action.moveToElement(menu).perform();
		 // driver.findElement(By.linkText("Stack")).click();
    	//driver.findElement(DSdropdown).click();
        //Assert.assertTrue(driver.getTitle().contains("Stack"));

       // driver.findElement(StackHm).click(); 

    }
    public void clickQueueR() {
    	//driver.findElement(DSdropdown).click(); 
		  wait.until(ExpectedConditions.elementToBeClickable(QueueHm)).click();

    	//driver.findElement(QueueHm).click();
    }
    
    public void clickAlertR() { 
    	
       //driver.findElement(AlertHm).click();
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

    	//driver.findElement(usernameField).click();
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

    	//driver.findElement(logoutLink).click();
    	//driver.findElement(errorMsg).click();
    }
    
	}
