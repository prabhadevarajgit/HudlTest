package managers;
  
import org.openqa.selenium.WebDriver;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.QaProjectsPage;


public class PageObjectManager {
 
	private WebDriver driver;
 
		private HomePage homePage;
 
	
	private LoginPage loginPage;
	
	private QaProjectsPage qaProjectsPage;
		
 
	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
	}
 
	
 
	public HomePage getHomePage(){
 
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
 
	}
 	
 
	
	
	public LoginPage getLoginPage() {
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
	}



	public QaProjectsPage getQaProjectsPage() {
		
		return (qaProjectsPage == null) ? qaProjectsPage = new QaProjectsPage(driver) : qaProjectsPage;
	}
 
	
}