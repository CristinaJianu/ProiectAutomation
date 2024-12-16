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
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutentificarePage;
import pages.HomePage;


import java.time.Duration;

public class AutentificareTest {
    public WebDriver driver;

    @Test
    public void metodaTest() {
        driver = new ChromeDriver();
        driver.get("https://diva-charms.com/ro/");
        driver.manage().window().maximize();

        ElementMethods elementMethods = new ElementMethods(driver);
        HomePage homePage = new HomePage(driver);

        WebElement respingeCookies = driver.findElement(By.id("onesignal-slidedown-cancel-button"));
        elementMethods.clickJSElement((respingeCookies));

        WebElement accountButton = driver.findElement(By.xpath("//span[@class='header_v_align_m']"));
        elementMethods.clickJSElement(accountButton);

        String emailValue = "test@gmail.com";
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
    }

}
