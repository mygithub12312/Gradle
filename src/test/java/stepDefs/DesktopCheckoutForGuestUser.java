package stepDefs;

import desktop.fragments.HeaderFragment;
import desktop.fragments.SearchResultsPageFragment;
import desktop.pages.HeaderElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class DesktopCheckoutForGuestUser {
    HeaderFragment headerFragment = new HeaderFragment();
    SearchResultsPageFragment searchResultsPageFragment = new SearchResultsPageFragment();

    @Given("I am an anonymous customer with clear cookies")
    public void iAmAnAnonymousCustomerWithClearCookies() {

    }

    @When("I open the {string}")
    public void iOpenThe(String arg0) {
        headerFragment.openHomePage();
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) {
        headerFragment.fillSearchQuery(arg0);
    }

    @And("I am redirected to a {string}")
    public void iAmRedirectedToA(String arg0) {
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(Map<String, String> details) {

    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(List<String> filters) {

    }

    @Then("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts() {
    }

    @When("I click {string} button for product with name {string}")
    public void iClickAddToBasketButtonForProductWithName(String arg0) {
    }

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp() {
    }

    @Then("I am redirected to the {string}")
    public void iAmRedirectedToThe(String arg0) {
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing() {
    }

    @When("I click {string} button on {string} page")
    public void iClickCheckoutButtonOnBasketPage() {
    }

    @Then("I am redirected to the {string} page")
    public void iAmRedirectedToThePage(String arg0) {
    }

    @When("I click {string} button")
    public void iClickBuyNowButton() {
    }

    @Then("the following validation error messages are displayed on {string} form:")
    public void theFollowingValidationErrorMessagesAreDisplayedOnDeliveryAddressForm() {
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing() {
    }

    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String arg0) {
    }

    @When("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually() {
    }

    @Then("there is no validation error messages displayed on {string} form")
    public void thereIsNoValidationErrorMessagesDisplayedOnDeliveryAddressForm() {
    }

    @When("I enter my card details")
    public void iEnterMyCardDetails() {
    }
}
