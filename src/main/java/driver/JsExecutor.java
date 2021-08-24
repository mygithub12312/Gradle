package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsExecutor {


    public void javascriptClick(String element) {
        WebElement webElement=SingletonDriver.getDriver().findElement(By.xpath(element));
        JavascriptExecutor js = (JavascriptExecutor)SingletonDriver.getDriver();

        js.executeScript("arguments[0].click();",webElement);
    }
}
