package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class LoginPage {
	
	WebElement element;
	WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "continue")
	private WebElement clickOnContinue;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "logIn")
	private WebElement logIn;
	
	@FindBy(xpath = "//div[contains(@class,'login-error-container')]//p")
	private WebElement logInError;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String userEmail){
		email.sendKeys(userEmail);
	}
	
	public void clickOnContinue(){
		clickOnContinue.click();
	}
	
	public void enterPassword(String userPwd){
		password.sendKeys(userPwd);
	}
	
	public void clickOnLogIn(){
		logIn.click();
	}
	
	public String getErrorMessage( ) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(logInError));
		return logInError.getText();
	}
	
	public boolean isLoginButtonEnabled() {
		return logIn.isEnabled();
	}
	
	public void quitDriver() {
		driver.quit();
	}


}
