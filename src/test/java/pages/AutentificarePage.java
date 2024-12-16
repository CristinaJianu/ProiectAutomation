package pages;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AutentificarePage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public AutentificarePage(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(this.driver);
    }

    @FindBy(xpath = "//div[@class='form_content_inner']//input[@name='email']")
    public WebElement emailElement;
    @FindBy(xpath = "//input[@class='form-control js-child-focus js-visible-password']")
    public WebElement parolaElement;
    @FindBy(id="SubmitLogin")
    public WebElement conectareButton;

    public void autentificareProcess(String emailValue, String parolaValue)
    {
        elementMethods.fillElement(emailElement,emailValue);
        elementMethods.fillElement(parolaElement,parolaValue);
        elementMethods.clickJSElement(conectareButton);

        //validare
        Assert.assertTrue(emailElement.isDisplayed(), "Câmpul email nu este afișat");
        Assert.assertTrue(parolaElement.isDisplayed(), "Câmpul parolă nu este afișat");
        Assert.assertTrue(conectareButton.isDisplayed(), "Butonul de conectare nu este afișat");

        Assert.assertEquals(emailElement.getAttribute("name"), "email", "Atributul 'name' pentru câmpul email nu este corect");
        Assert.assertEquals(conectareButton.getAttribute("id"), "SubmitLogin", "ID-ul butonului de conectare nu este corect");

    }

}
