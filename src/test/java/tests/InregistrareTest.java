package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class InregistrareTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://diva-charms.com/ro/");
        driver.manage().window().maximize();
        ElementMethods elementMethods=new ElementMethods(driver);

        HomePage homePage=new HomePage(driver);
        //homePage.clickRespingeCookies();
        //homePage.clickAccountButton();

        WebElement respingeCookies =driver.findElement(By.id("onesignal-slidedown-cancel-button"));
        elementMethods.clickJSElement((respingeCookies));

        WebElement accountButton=driver.findElement(By.xpath("//span[@class='header_v_align_m']"));
        elementMethods.clickJSElement(accountButton);

        WebElement creareContButton =driver.findElement(By.id("SubmitCreate"));
        elementMethods.clickJSElement(creareContButton);

//        List<WebElement> genderOptionsList=driver.findElements(By.xpath("//input[@name='id_gender']"));
//        String genderValue="Dna.";
//        switch (genderValue) {
//            case "Dl.":
//                elementMethods.clickJSElement(genderOptionsList.get(0));
//
//               //js.executeScript("arguments[0].click();",genderOptionsList.get(0));
//                break;
//            case "Dna.":
//                elementMethods.clickJSElement(genderOptionsList.get(1));
//
//                //js.executeScript("arguments[0].click();",genderOptionsList.get(1));
//                break;
//        }

        WebElement prenumeElement= driver.findElement(By.xpath("//input[@name='firstname']"));
       String prenumeValue="Cristina";
        elementMethods.fillElement(prenumeElement,prenumeValue);

        WebElement numeElement= driver.findElement(By.xpath("//input[@name='lastname']"));
        String numeValue="Jianu";
        elementMethods.fillElement(numeElement,numeValue);

        WebElement emailNouElement= driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@name='email']"));
        String emailNouValue="test1@gmail.com";
        elementMethods.fillElement(emailNouElement,emailNouValue);

        WebElement parolaNouaElement= driver.findElement(By.xpath("//input[@class='form-control js-child-focus js-visible-password']"));
        String parolaNouaValue="ParolaTest123.";
        elementMethods.fillElement(parolaNouaElement,parolaNouaValue);

        WebElement salveazaButton= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large js-submit-active btn-spin btn-full-width']"));
        elementMethods.clickJSElement(salveazaButton);

    }
}