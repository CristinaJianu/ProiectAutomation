package helpMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    public void clickJSElement(WebElement element) {
        waitVisibleElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void fillElement(WebElement element, String text) {
        waitVisibleElement(element);
        element.sendKeys(text);
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> List){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(List));
    }

    public void selectDropDownElement(WebElement element, String text) {
        waitVisibleElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}
