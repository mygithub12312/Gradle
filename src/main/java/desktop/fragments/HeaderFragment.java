package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFragment extends AbstractFragment {

    private static final String pageUrl = "https://www.bookdepository.com/";

    @FindBy(xpath = "//*[@class='text-input']")
    private WebElement searchField;

    public void openHomePage() {
        SingletonDriver.getDriver().get(pageUrl);
    }

    public void deleteCookies() {
        SingletonDriver.getDriver().manage().deleteAllCookies();
    }


    public void fillSearchQuery(String query) {
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
    }
}
