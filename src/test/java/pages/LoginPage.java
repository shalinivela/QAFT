package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Keys;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Web Elements*********
    String usenameId = "pplx-auth-username";
    String passwordId = "pplx-auth-password";
    String nextButtonId = "#form-username .row.text-small .inline-block.pull-right .form-submit";
    String submitButton= "#form-pass .row.text-small .inline-block.pull-right .form-submit";
    String textOnPageLoad="snap-drawer-main";
    String backbtn=".back-button";

    //*********Page Methods*********

    public void provideUserName(String username) throws InterruptedException{
        //Enter Username(Email)
        writeText(By.id(usenameId),username);
        Thread.sleep(500);
    }
    public void providePassword(String password) throws InterruptedException{
         //Enter Password
        writeText(By.id(passwordId),password);
    }

    public void clickNextButton() throws InterruptedException{
        //Enter Password
    	 Thread.sleep(500);
             click(By.cssSelector(nextButtonId));
             Thread.sleep(1500);
   }
    
    public void clickSubmitButton() throws InterruptedException{
        //Enter Password
    	 Thread.sleep(500);
    	 Thread.sleep(2000);
    	 clickOnNthElement(By.cssSelector(submitButton),0);
          
           Thread.sleep(1000);

   }
    public void isAvailableSubmitButton() throws InterruptedException{
        //Enter Password
    	 Thread.sleep(500);
    	 Assert.assertTrue(isComponentAvailable(By.className(submitButton)));
             Thread.sleep(500);
   }
    //Verify Username Condition
    public void verifyPageLoadedAsExpected (){
        Assert.assertTrue(isComponentAvailable(By.className(textOnPageLoad)));
    }

}
