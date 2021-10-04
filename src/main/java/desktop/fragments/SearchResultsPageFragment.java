package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchResultsPageFragment extends AbstractFragment {

    private static final String pageUrl = "https://www.bookdepository.com/search";

    private By priceFilter = By.xpath("//*[@name='price']");

    private By availabilityFilter = By.xpath("//*[@id='filterAvailability']");

    private By languageFilter = By.xpath("//*[@name='searchLang']");

    private By formatFilter = By.xpath("//*[@name='format']");

    private By productTitles = By.xpath("//*[@class='title']");

    @FindBy(xpath = "//*[@data-isbn='9780131872486']")
    private WebElement addToCartButton;

    @FindBy(className = "modal-content")
    private WebElement cartPopUp;

    @FindBy(xpath = "//*[@class='btn btn-primary pull-right continue-to-basket string-to-localize link-to-localize']")
    private WebElement basketButton;

    private static final By applyFilters = By.xpath("//*[contains(button,'Refine results')]");

    private static final String price = "Price range";
    private static final String availability = "Availability";
    private static final String language = "Language";
    private static final String format = "Format";

    public String getPageUrl() {
        return pageUrl;
    }

    public void addProductToBasket() {
        clickElement(addToCartButton);
    }

    public void clickPopUpBasketButton() {
        clickElement(basketButton);
    }

    public void setApplyFilters(){
        findElement(applyFilters).click();
    }

    public List<String> findBookTitles() {
        return findElements(productTitles).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean verifyThatBooksArePresentOnTheSearchResultPage(List<String> expectedBookTitles, List<String> actualBookTitles) {
        for (String expectedBookTitle: expectedBookTitles){
            for (String actualBookTitle: actualBookTitles){
                if (expectedBookTitle.matches(actualBookTitle)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyThatOnlyExpectedBooksArePresentOnTheSearchResultPage(List<String> expectedBookTitles, List<String> actualBookTitles){
        return actualBookTitles.containsAll(expectedBookTitles);
    }


    public void setPriceFilter (String priceRefinementFilter) {
        selectByVisibleText(priceFilter,priceRefinementFilter);
    }

    public void setAvailabilityFilter (String availabilityRefinementFilter) {
        selectByVisibleText(availabilityFilter,availabilityRefinementFilter);
    }

    public void setLanguageFilter (String languageRefinementSelector) {
        selectByVisibleText(languageFilter,languageRefinementSelector);
    }

    public void setFormatFilter (String formatRefinementSelector) {
        selectByVisibleText(formatFilter,formatRefinementSelector);
    }

    public void selectFilters (Map<String, String> Filters) {
        setPriceFilter(Filters.get(price));
        setAvailabilityFilter(Filters.get(availability));
        setLanguageFilter(Filters.get(language));
        setFormatFilter(Filters.get(format));
        setApplyFilters();
    }

}
