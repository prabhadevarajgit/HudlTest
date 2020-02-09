package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.QaProjectsPage;

public class LoginSteps {

	static WebDriver driver;
	TestContext testContext;
	HomePage homePage;
	LoginPage loginPage;
	QaProjectsPage qaProjectsPage;

	public LoginSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		loginPage = testContext.getPageObjectManager().getLoginPage();
		qaProjectsPage = testContext.getPageObjectManager().getQaProjectsPage();
	}

	
	@When("^user tries to login with \"(.*)\" and \"(.*)\"$")
	public void user_tries_to_login_with_and(String email, String password) {
		homePage.clickLoginButton();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLogIn();
	}

	@Then("^user able to login successfully$")
	public void user_able_to_login_successfully() {
		Assert.assertTrue(qaProjectsPage.isQaProjectPageDisplayed());
	}

	@Then("^user see the error message (.+)$")
	public void user_see_the_error_message(String errormessage) throws InterruptedException {
		System.out.println("****" + loginPage.getErrorMessage());
		String actualErrorMessage = loginPage.getErrorMessage();
		Assert.assertEquals(errormessage, actualErrorMessage);
	}

	 @When("^user tries to login with below credentials of (.+) and (.+)$")
	public void user_tries_to_login_with_below_invalid_credentials(String email, String password) {
		homePage.clickLoginButton();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLogIn();
	}
	
	@And("^login button is disabled$")
	public void login_button_is_disabled() {
		Assert.assertFalse(loginPage.isLoginButtonEnabled());
	}
	
	@And("^user loggedout successfully on clicking logout button$")
    public void user_loggedout_successfully_on_clicking_logout_button() {
		qaProjectsPage.clickLogout();
		Assert.assertEquals("Hudl: We Help Teams and Athletes Win",homePage.getHomePageTitle());
		homePage.closeBrowser();
    }
	
	 @And("^user clicks on back in browser$")
	    public void user_clicks_on_back_in_browser() {
		 qaProjectsPage.navigateBack();
	    }

}
