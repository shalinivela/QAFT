package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
    	 driver.findElement(elementLocation).clear();
         driver.findElement(elementLocation).sendKeys(text);
         
    }
  
    public void clickEnter (By elementLocation) {

    	 driver.findElement(elementLocation).sendKeys(Keys.RETURN);
    }
    //Read Text
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
    
    //Confirm Element Is Present
    public boolean isComponentAvailable(By elementLocation) {
        return driver.findElement(elementLocation).isDisplayed();
    }
    
    //Confirm Element Is Present
    public <webelements> void clickOnNthElement(By elementLocation, int nthElement) {
       List<webelements> eleList= (List<webelements>) driver.findElements(elementLocation);
       ((WebElement) eleList.get(nthElement)).click();
    }
}
