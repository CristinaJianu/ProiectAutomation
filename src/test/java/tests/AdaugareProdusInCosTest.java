package tests;

import helpMethods.ElementMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutentificarePage;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class AdaugareProdusInCosTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://diva-charms.com/ro/");
        driver.manage().window().maximize();

        ElementMethods elementMethods=new ElementMethods(driver);

        WebElement respingeCookies =driver.findElement(By.id("onesignal-slidedown-cancel-button"));
        elementMethods.clickJSElement(respingeCookies);

        WebElement accountButton=driver.findElement(By.xpath("//span[@class='header_v_align_m']"));
        elementMethods.clickJSElement(accountButton);

        String emailValue = "test1@gmail.com";
        String parolaValue = "TestAutentificare123.";

        WebElement emailElement = driver.findElement(By.xpath("//div[@class='form_content_inner']//input[@name='email']"));
        elementMethods.fillElement(emailElement, emailValue);

        WebElement parolaElement = driver.findElement(By.xpath("//input[@class='form-control js-child-focus js-visible-password']"));
        elementMethods.fillElement(parolaElement, parolaValue);

        WebElement conectareButton = driver.findElement(By.id("SubmitLogin"));
        elementMethods.clickJSElement(conectareButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Autentificare esuata.']")));

        if (errorMessage != null) {
            System.out.println("Autentificare eșuată. Încearcă să creezi un cont prima dată.");
        }
        //HomePage homePage=new HomePage(driver);
        //homePage.clickRespingeCookies();
        //homePage.clickAccountButton();

        //AutentificarePage autentificarePage=new AutentificarePage(driver);
        //autentificarePage.autentificareProcess(emailValue,parolaValue);

        WebElement livrareRapidaButton= driver.findElement(By.id("st_ma_15"));
        elementMethods.clickJSElement(livrareRapidaButton);

        WebElement produsElement= driver.findElement(By.xpath("//h3[@itemprop='name']//a[@title='Palton Amir Burgundy']"));
        elementMethods.clickJSElement(produsElement);

//        List<WebElement> sizeOptionsList=driver.findElements(By.xpath("//input[@name='group[1]']"));
//        String sizeValue="XS";
//        switch (sizeValue) {
//            case "XS":
//                elementMethods.clickJSElement(sizeOptionsList.get(0));
//                break;
//            case "S":
//                elementMethods.clickJSElement(sizeOptionsList.get(1));
//                break;
//            case "M":
//                elementMethods.clickJSElement(sizeOptionsList.get(2));
//                break;
//        }

        WebElement adaugaInCosButton= driver.findElement(By.xpath("//span[text()='Adauga in cos']"));
        elementMethods.clickJSElement(adaugaInCosButton);

        WebElement finalizeazaComandaButton= driver.findElement(By.xpath("//div[@class='col-md-6']//a[text()='Finalizeaza comanda']"));
        elementMethods.clickJSElement(finalizeazaComandaButton);

        WebElement finalizeazaComandaFinalButton= driver.findElement(By.xpath("//div[@class='checkout cart-detailed-actions card-block']//a[text()='Finalizeaza comanda']"));
        elementMethods.clickJSElement(finalizeazaComandaFinalButton);

        WebElement adresaElement = driver.findElement(By.xpath("//input[@name='address1']"));
        elementMethods.fillElement(adresaElement,"str sperantei nr 2");

        WebElement codPostalElement = driver.findElement(By.xpath("//input[@name='postcode']"));
        elementMethods.fillElement(codPostalElement,"456788");

        WebElement countryElement=driver.findElement(By.xpath("//select[@name='id_country']"));
        elementMethods.clickJSElement(countryElement);
        Select select = new Select(countryElement);
        select.selectByVisibleText("Estonia");
        //elementMethods.selectDropDownElement(countryElement,"Estonia");

//        WebElement judetElement=driver.findElement(By.xpath("//select[@name='id_state']"));
//        js.executeScript("arguments[0].click();",judetElement);

        WebElement localitateElement = driver.findElement(By.xpath("//input[@name='city']"));
        elementMethods.fillElement(localitateElement,"timisoara");

        WebElement telefonElement = driver.findElement(By.xpath("//input[@name='phone']"));
        elementMethods.fillElement(telefonElement,"0987654567");

        WebElement continuaButton=driver.findElement(By.xpath("//button[@name='confirm-addresses']"));
        elementMethods.clickJSElement(continuaButton);

        WebElement continuaFinalButton=driver.findElement(By.xpath("//button[@name='confirmDeliveryOption']"));
        elementMethods.clickJSElement(continuaFinalButton);

        WebElement plataButton=driver.findElement(By.xpath("//input[@name='payment-option']"));
        elementMethods.clickJSElement(plataButton);

        WebElement termeniButton=driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        elementMethods.clickJSElement(termeniButton);

        WebElement plaseazaComandaButton=driver.findElement(By.xpath("//div[@class='ps-shown-by-js']//button[@class='btn btn-default']"));
        elementMethods.clickJSElement(plaseazaComandaButton);


        //validari
        Assert.assertTrue(livrareRapidaButton.isDisplayed(), "Butonul Livrare Rapidă nu este afișat");
        Assert.assertTrue(produsElement.isDisplayed(), "Produsul Palton Amir Burgundy nu este afișat");
       // Assert.assertFalse(sizeOptionsList().isEmpty(), "Opțiunile pentru mărime nu sunt disponibile");
        Assert.assertTrue(adaugaInCosButton.isDisplayed(), "Butonul Adaugă în Coș nu este afișat");
        Assert.assertTrue(finalizeazaComandaButton.isDisplayed(), "Butonul Finalizează Comanda (primul pas) nu este afișat");
        Assert.assertTrue(finalizeazaComandaFinalButton.isDisplayed(), "Butonul Finalizează Comanda (final) nu este afișat");
        Assert.assertTrue(adresaElement.isDisplayed(), "Câmpul Adresă nu este afișat");
        Assert.assertEquals(adresaElement.getAttribute("value"), "str sperantei nr 2", "Adresa introdusă nu este corectă");
        Assert.assertTrue(codPostalElement.isDisplayed(), "Câmpul Cod Poștal nu este afișat");
        Assert.assertEquals(codPostalElement.getAttribute("value"), "456788", "Codul Poștal introdus nu este corect");
        Assert.assertTrue(countryElement.isDisplayed(), "Dropdown-ul pentru țară nu este afișat");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Estonia", "Țara selectată nu este corectă");
        Assert.assertTrue(localitateElement.isDisplayed(), "Câmpul Localitate nu este afișat");
        Assert.assertEquals(localitateElement.getAttribute("value"), "timisoara", "Localitatea introdusă nu este corectă");
        Assert.assertTrue(telefonElement.isDisplayed(), "Câmpul Telefon nu este afișat");
        Assert.assertEquals(telefonElement.getAttribute("value"), "0987654567", "Numărul de telefon introdus nu este corect");
        Assert.assertTrue(continuaButton.isDisplayed(), "Butonul Continuă Adresa nu este afișat");
        Assert.assertTrue(continuaFinalButton.isDisplayed(), "Butonul Continuă Livrare nu este afișat");
        Assert.assertTrue(plataButton.isDisplayed(), "Opțiunea de plată nu este afișată");
        Assert.assertTrue(plaseazaComandaButton.isDisplayed(), "Butonul Plasează Comanda nu este afișat");
        Assert.assertTrue(termeniButton.isDisplayed(), "Checkbox-ul Termeni și Condiții nu este afișat");
//        Assert.assertTrue(confirmationMessageElement.isDisplayed(), "Mesajul de confirmare nu este afișat");
//        Assert.assertEquals(confirmationMessageElement.getText(), expectedConfirmationMessage, "Mesajul de confirmare nu este corect");

    }
}
