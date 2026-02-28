package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;

public class RegisterPage {

	    // Locators
	    private By registerLink = By.linkText("Register");
	    private By usernameField = By.id("username");
	    private By passwordField = By.id("password");
	    private By confirmPasswordField = By.id("confirmPassword");
	    private By registerButton = By.id("registerBtn");
	    private By successMessage = By.id("successMessage");
	    private By passwordErrorMessage = By.id("passwordError");

	    WebDriver driver;


public RegisterPage(WebDriver driver) {
	    	
	        this.driver =driver;
	    }
	    
	    
	    // Actions
	    public void clickRegisterLink() {
	        driver.findElement(registerLink).click();
	    }
 public void getintohomepage() {
	 driver.get("https://dsportalapp.herokuapp.com/home"); // replace with real URL
 }
 
	    public boolean isRegistrationPageDisplayed() {
	        return driver.getTitle().contains("Register");
	    }

	    public void enterUsername(String username) {
	        driver.findElement(usernameField).clear();
	        driver.findElement(usernameField).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).clear();
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void enterConfirmPassword(String confirmPassword) {
	        driver.findElement(confirmPasswordField).clear();
	        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	    }

	    public void clickRegisterButton() {
	        driver.findElement(registerButton).click();
	    }

	    public boolean isSuccessMessageDisplayed() {
	        return driver.findElement(successMessage).isDisplayed();
	    }

	    public String getPasswordErrorMessage() {
	        return driver.findElement(passwordErrorMessage).getText();
	    }
	}


