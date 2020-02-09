package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class HomePageSteps {

	static WebDriver driver;
	TestContext testContext;
	HomePage homePage;
	LoginPage loginPage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();

	}

	@Given("^user is on Home Page of hudl$")
	public void userIsOnHomePageOfHudl() {
		homePage.navigateTo_HomePage();
		Assert.assertEquals("Hudl: We Help Teams and Athletes Win", homePage.getHomePageTitle());
	}

	@Then("^user see the homePage$")
	public void user_see_the_homepage() {
		Assert.assertEquals("Hudl: We Help Teams and Athletes Win", homePage.getHomePageTitle());
	}

}
