package GenericUtility;


import java.awt.Toolkit;  
import java.io.IOException; 
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver.*; 
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
package com.browserstack;
import com.browserstack.local.Local;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.Assert;


public  class TestConfig {
	
	public static WebDriver setWebDriver(String browser	) {
		WebDriver driver = null;
		if (browser.contains("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("<h2>Test conducted on <font color='red'>Firefox</font> browser.</h2>");
		} else if (browser.contains("iexplore")) {
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			Reporter.log("<h2>Test conducted on <font color='red'>IE</font> browser.</h2>");
		} else if (browser.contains("googlechrome")) {
			   System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		        driver = (WebDriver) new ChromeDriver();
		    Reporter.log("<h2>Test conducted on <font color='red'>Chrome</font> browser.</h2>");
		} else if (browser.contains("htmlunit")) {
			DesiredCapabilities huCapabilities = DesiredCapabilities.htmlUnit();
			huCapabilities.setJavascriptEnabled(true);
			driver = new HtmlUnitDriver(huCapabilities);			
			Reporter.log("<h2>Test conducted on <font color='red'>Htmlunit </font> driver.</h2>");
		} else {
			System.out.println("Unknown browser = " + browser
					+ "! unable to determine the driver - exit");
			System.exit(1);
		}
		return driver;
	}
	/* every time an element is located, if the element is not present,
	 *  the location is retried until either it is present, or until 30 seconds have passed
	 */
/**	
	
public static RemoteWebDriver setUp(String config_file, String environment) throws Exception {
	   public WebDriver driver;
	    private Local l;
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }
        
        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(capabilities.getCapability(pair.getKey().toString()) == null){
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if(username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if(accessKey == null) {
            accessKey = (String) config.get("key");
        }

        if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
            l = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", accessKey);
            l.start(options);
        }

        driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
        return driver;
    }
}
	**/
	
	public static void setWaitTimeout(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS); 
		
	}
	public static void windowMaximize(WebDriver driver) {
	
		
		 ((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");
		}
		
}
