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

public class AutentificareTest {
    public WebDriver driver;

    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://diva-charms.com/ro/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement respingeCookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("onesignal-slidedown-cancel-button")));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",respingeCookies);

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


//
////        WebElement creatiContElement = driver.findElement(By.cssSelector("button.action.submit.primary"));
////        creatiContElement.click();

    }
}
