package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import desktop.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageFragment extends AbstractFragment {

    @FindBy(xpath = "//*[@class='text-input']")
    private By searchField;

    @FindBy(xpath = "//*[@class='header-search-btn']")
    private By searchButton;


    public void fillSearchQuery(String query) {
    }


}
