package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AdaugareProdusInCos {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://diva-charms.com/ro/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement respingeCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onesignal-slidedown-cancel-button")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", respingeCookies);

        WebElement accountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header_v_align_m']")));
        js.executeScript("arguments[0].click();",accountButton);

        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email' and @fdprocessedid='kqihy9']")));
        String emailValue="test@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement parolaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-control js-child-focus js-visible-password']")));
        String parolaValue="TestAutentificare123.";
        parolaElement.sendKeys(parolaValue);

        WebElement conectareButton=driver.findElement(By.id("SubmitLogin"));
        conectareButton.click();

        WebElement livrareRapidaButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("st_ma_15")));
        js.executeScript("arguments[0].click();", livrareRapidaButton);

        WebElement produsElement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@itemprop='name']//a[@title='Palton Amir Burgundy']")));
        js.executeScript("arguments[0].click();", produsElement);

        List<WebElement> sizeOptionsList=driver.findElements(By.xpath("//input[@name='group[1]']"));
        String sizeValue="XS";
        switch (sizeValue) {
            case "XS":
                js.executeScript("arguments[0].click();",sizeOptionsList.get(0));
                break;
            case "S":
                js.executeScript("arguments[0].click();",sizeOptionsList.get(1));
                break;
            case "M":
                js.executeScript("arguments[0].click();",sizeOptionsList.get(2));
                break;
        }


        WebElement adaugaInCosButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Adauga in cos']")));
        js.executeScript("arguments[0].click();", adaugaInCosButton);

        WebElement finalizeazaComandaButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-6']//a[text()='Finalizeaza comanda']")));
        js.executeScript("arguments[0].click();", finalizeazaComandaButton);

        WebElement finalizeazaComandaFinalButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkout cart-detailed-actions card-block']//a[text()='Finalizeaza comanda']")));
        js.executeScript("arguments[0].click();", finalizeazaComandaFinalButton);

        WebElement adresaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='address1']")));
        String adresaValue="str sperantei nr 2";
        adresaElement.sendKeys(adresaValue);

        WebElement codPostalElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='postcode']")));
        String codPostalValue="456788";
        codPostalElement.sendKeys(codPostalValue);

        WebElement countryElement=driver.findElement(By.xpath("//select[@name='id_country']"));
        js.executeScript("arguments[0].click();",countryElement);
        Select select = new Select(countryElement);
        select.selectByVisibleText("Estonia");

//        WebElement judetElement=driver.findElement(By.xpath("//select[@name='id_state']"));
//        js.executeScript("arguments[0].click();",judetElement);
//


        WebElement localitateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='city']")));
        String localitateValue="timisoara";
        localitateElement.sendKeys(localitateValue);

        WebElement telefonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='phone']")));
        String telefonValue="0987654567";
        telefonElement.sendKeys(telefonValue);

        WebElement continuaButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='confirm-addresses']")));
        js.executeScript("arguments[0].click();", continuaButton);

        WebElement continuaFinalButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='confirmDeliveryOption']")));
        js.executeScript("arguments[0].click();", continuaFinalButton);

        WebElement plataButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='payment-option']")));
        js.executeScript("arguments[0].click();", plataButton);

        WebElement termeniButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("conditions_to_approve[terms-and-conditions]")));
        js.executeScript("arguments[0].click();", termeniButton);

        WebElement plaseazaComandaButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ps-shown-by-js']//button[@class='btn btn-default']")));
        js.executeScript("arguments[0].click();", plaseazaComandaButton);


    }
}
