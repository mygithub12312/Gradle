package abstractClasses.fragment;

import driver.SingletonDriver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverWaiter;

import static driver.SingletonDriver.getDriver;

import java.util.List;

public abstract class AbstractFragment extends WebDriverWaiter {

    private WebElement rootElement;

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public WebElement findElement(By by) {
        return SingletonDriver.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return SingletonDriver.getDriver().findElements(by);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void setFieldValue(WebElement element, String text) {
        element.sendKeys(text);
    }

    public Select selectValue(By by) {
        return new Select(SingletonDriver.getDriver().findElement(by));
    }

    protected void selectByVisibleText(By by, String text){
        selectValue(by).selectByVisibleText(text);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public static void switchToDefaultContent(){
        SingletonDriver.getDriver().switchTo().defaultContent();
    }

    public static void switchToIframe(WebElement frame) {
        SingletonDriver.getDriver().switchTo().frame(frame);
    }

}
