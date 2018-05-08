package tests;

import org.testng.annotations.Test;
import org.testng.Reporter;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest2 {
	@Test(priority = 0)
	public void logInToSocial() throws InterruptedException {
		// *************PAGE INSTANTIATIONS*************
		HomePage homePage = new HomePage(driver, wait);
		LoginPage loginPage = new LoginPage(driver, wait);

		// *************ACTUAL TESTING WITH POM *************
		Reporter.log("go to home page");
		homePage.goToFrontLineSelling(URLObtained);
		Reporter.log("Login with Crendentials");
		loginPage.provideUserName("skannan@frontlineselling.com");
		loginPage.clickNextButton();
		loginPage.providePassword("Shaloo80");
		Reporter.log("Click on submit");
		loginPage.clickSubmitButton();
		Thread.sleep(150);
		Reporter.log("User should be on the dashboard page:"+ driver.getTitle());
		}

	@Test(dependsOnMethods = { "logInToSocial" })
	public void verifyPageLoaded() throws InterruptedException {
		// *************PAGE INSTANTIATIONS*************
		LoginPage loginPage = new LoginPage(driver, wait);
		// *************ACTUAL TESTING WITH POM *************
		Reporter.log("User should be on the dashboard page.");
		loginPage.verifyPageLoadedAsExpected();
		Thread.sleep(150);
		Reporter.log("Validated that the page has loaded");

	}
}
