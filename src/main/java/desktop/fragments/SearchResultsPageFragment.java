package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultsPageFragment extends AbstractFragment {

    @FindBy(xpath = "//*[@name='price']")
    private WebElement priceFilter;

    @FindBy(xpath = "//*[@name='availability']")
    private WebElement availabilityFilter;

    @FindBy(xpath = "//*[@name='searchLang']")
    private WebElement languageFilter;

    @FindBy(xpath = "//*[@name='format']")
    private WebElement formatFilter;

    @FindBy(xpath = "//*[@data-isbn='9780131872486']")
    private WebElement addToCartButton;

    public void selectDropdown() {
        selectDropDownValue(priceFilter, "high");
        selectDropDownValue(availabilityFilter, "1");
        selectDropDownValue(languageFilter, "123");
        selectDropDownValue(formatFilter, "1");
    }
}
