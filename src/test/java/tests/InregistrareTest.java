package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InregistrareTest {
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

        WebElement creareContButton =wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitCreate")));
        js.executeScript("arguments[0].click();",creareContButton);

        List<WebElement> genderOptionsList=driver.findElements(By.xpath("//input[@name='id_gender']"));
        String genderValue="Dna.";
        switch (genderValue) {
            case "Dl.":
                js.executeScript("arguments[0].click();",genderOptionsList.get(0));
                break;
            case "Dna.":
                js.executeScript("arguments[0].click();",genderOptionsList.get(1));
                break;
        }

        WebElement prenumeElement= driver.findElement(By.xpath("//input[@name='firstname']"));
        String prenumeValue="Cristina";
        prenumeElement.sendKeys(prenumeValue);

        WebElement numeElement= driver.findElement(By.xpath("//input[@name='lastname']"));
        String numeValue="Jianu";
        numeElement.sendKeys(numeValue);

//        WebElement emailNouElement= driver.findElement(By.xpath("//input[@fdprocessedid='o6eq1r']"));
//        String emailNouValue="test@gmail.com";
//        emailNouElement.sendKeys(emailNouValue);

        WebElement parolaNouaElement= driver.findElement(By.xpath("//input[@class='form-control js-child-focus js-visible-password']"));
        String parolaNouaValue="ParolaTest123.";
        parolaNouaElement.sendKeys(parolaNouaValue);

        WebElement salveazaButton= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large js-submit-active btn-spin btn-full-width']"));
        salveazaButton.click();


    }
}