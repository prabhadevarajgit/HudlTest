package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QaProjectsPage {

	WebElement element;
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'QA Hire Project')]")
	private static WebElement qaProjectHeader;
	
	@FindBy(xpath = "//div[contains(@class,\"hui-globaluseritem__display-name\")]")
	private static WebElement profileName;
	
	@FindBy(linkText = "Log Out")
	private static WebElement logOutLink;
	
	public QaProjectsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isQaProjectPageDisplayed(){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(qaProjectHeader));
		return qaProjectHeader.isDisplayed();
	}
		
	public void clickLogout() {
		Actions builder = new Actions(driver); 
		builder.moveToElement(profileName ).build().perform();
		builder.moveToElement(logOutLink).click().build().perform();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
}
