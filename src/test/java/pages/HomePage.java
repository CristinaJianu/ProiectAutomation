package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

   public WebDriver driver;
   public ElementMethods elementMethods;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(this.driver);
    }

//    @FindBy (id = "onesignal-slidedown-cancel-button")
//    public WebElement respingeCookies;
//    @FindBy (xpath = "//span[@class='header_v_align_m']")
//    public  WebElement accountButton;

//    public void clickRespingeCookies() {
//    elementMethods.clickJSElement(respingeCookies);
//    }
//    public void clickAccountButton(){
//    elementMethods.clickJSElement(accountButton);
//    }

}
