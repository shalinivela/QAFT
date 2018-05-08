package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import GenericUtility.TestConfig;
import GenericUtility.TestUtil;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest2 {
	
	
	
	
    public WebDriver driver;
    public WebDriverWait wait;
    
    
    
	

	int timeOut = 60; // default timeout for the testRun mode = 15 sec; default
						// timeout for the testDev mode = 2 sec
	String browser;
	String env;
	String shortcut;
	String server;
	String user;
	String password;
	String projectId;
	String screenId;
	boolean testFailed = false;

	String Shortcut = "/d/login";
	List<String> productNames = new ArrayList<String>();
	String ProjectName = TestUtil.makeStrUnique("AutomationProject");
	String URLObtained;
	
    @AfterClass(alwaysRun = true)
    public void teardown () {
    	driver.close();
        driver.quit();
    	System.out.println("Testing complete");
    }
    
    @BeforeClass(alwaysRun = true)
	public void openTest(ITestContext context) {
    	
    	
		/**
		 * Configuration imported from the testng XMLfile
		 */
		browser = context.getCurrentXmlTest().getParameter("browser");
		driver = TestConfig.setWebDriver(browser);
		env = context.getCurrentXmlTest().getParameter("env");
		server = context.getCurrentXmlTest().getParameter("server");
		shortcut = context.getCurrentXmlTest().getParameter("shortcut");
		user = context.getCurrentXmlTest().getParameter("user");
		password = context.getCurrentXmlTest().getParameter("password");
		projectId=context.getCurrentXmlTest().getParameter("projectId");
		
		/**
		 * Configuration imported from the GenericUtility>>TestConfig
		 */
		TestConfig.setWaitTimeout(driver, timeOut);
	    TestConfig.windowMaximize(driver);
		System.out.println("Staccato Social App Test STARTED");
		System.out.println("\tparameter  env = " + env);
		System.out.println("\tparameter  server = " + server);
		URLObtained=env+server+shortcut;
		System.out.println("URL" +URLObtained);
        //
		//waitForAngularRequestsToFinish(driver);
		
		 //*************PAGE INSTANTIATIONS*************
		  //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver,wait);
        LoginPage loginPage = new LoginPage(driver,wait);

	}


}
