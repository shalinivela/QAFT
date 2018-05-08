package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    //*********Web Elements*********
    String signInButtonClass = "pplx-auth-username";


    //*********Page Methods*********

    //Go to Homepage
    public void goToFrontLineSelling (String baseURL){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

   

}
