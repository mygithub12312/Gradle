package stepDefs;

import abstractClasses.page.AbstractPage;
import desktop.fragments.BasketPageFragment;
import desktop.fragments.CheckoutPageFragment;
import desktop.fragments.HeaderFragment;
import desktop.fragments.SearchResultsPageFragment;
import driver.SingletonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.log4j.Logger;
import hooks.ScreenShoot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DesktopCheckoutForGuestUser extends AbstractPage {

    final static Logger logger = Logger.getLogger(DesktopCheckoutForGuestUser.class);

    HeaderFragment headerFragment = new HeaderFragment();
    SearchResultsPageFragment searchResultsPageFragment = new SearchResultsPageFragment();
    BasketPageFragment basketPageFragment = new BasketPageFragment();
    CheckoutPageFragment checkoutPageFragment = new CheckoutPageFragment();

    @After
    public void getScreenshot(Scenario scenario) throws IOException{
        Date currentDate = new Date();
        String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
        File screenshotFile = ((TakesScreenshot) SingletonDriver.getDriver()).getScreenshotAs(OutputType.FILE);

        if (scenario.isFailed()){
            FileUtils.copyFile(screenshotFile,new File(".//screenshot//"+screenshotFileName+".png"));
        }
    }


    @Given("^I am an anonymous customer with clear cookies$")
    public void iAmAnAnonymousCustomerWithClearCookies() {
        headerFragment.deleteCookies();
    }

    @When("I open the Home page")
    public void iOpenThe() {
        headerFragment.openHomePage();
        logger.info("Page displayed");
    }

    @And("I search for {string}")
    public void iSearchFor(String arg0) {
        headerFragment.fillSearchQuery(arg0);
    }

    @And("I am redirected to a {string}")
    public void iAmRedirectedToA(String arg0) {
        wait.until(ExpectedConditions.urlContains(searchResultsPageFragment.getPageUrl()));
        Assertions
            .assertThat(SingletonDriver.getDriver().getCurrentUrl().contains(searchResultsPageFragment.getPageUrl()))
                .overridingErrorMessage("Search page is not displayed")
                .isTrue();
    }

    @And("Search results contain the following products")
    public void searchResultsContainTheFollowingProducts(List<String> expectedBooks) {
        Assertions
            .assertThat(searchResultsPageFragment
                            .verifyThatBooksArePresentOnTheSearchResultPage(expectedBooks, searchResultsPageFragment.findBookTitles()))
            .overridingErrorMessage("Following product is not displayed")
            .isTrue();
    }

    @And("I apply the following search filters")
    public void iApplyTheFollowingSearchFilters(Map<String, String> filters) {
        searchResultsPageFragment.selectFilters(filters);
    }

    @Then("Search results contain only the following products")
    public void searchResultsContainOnlyTheFollowingProducts(List<String> expectedBooks) {
        Assertions
            .assertThat(searchResultsPageFragment
                            .verifyThatOnlyExpectedBooksArePresentOnTheSearchResultPage(expectedBooks, searchResultsPageFragment.findBookTitles()));
    }

    @When("I click Add to Basket button for product with name Thinking in Java")
    public void iClickAddToBasketButtonForProductWithName() {
        searchResultsPageFragment.addProductToBasket();
    }

    @And("I select {string} in basket pop-up")
    public void iSelectBasketCheckoutInBasketPopUp(String arg0) {
        searchResultsPageFragment.clickPopUpBasketButton();
    }

    @Then("I am redirected to the {string}")
    public void iAmRedirectedToThe(String arg0) {
        wait.until(ExpectedConditions.urlContains(basketPageFragment.getPageUrl()));
        Assertions.assertThat(SingletonDriver.getDriver().getCurrentUrl().contains(basketPageFragment.getPageUrl()))
                .overridingErrorMessage("Basket page is not displayed")
                .isTrue();
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(@Transpose Map<String, String> expectedOrderSummary) {
        Assertions.assertThat(basketPageFragment.getDeliveryPrice())
                .overridingErrorMessage("Delivery cost does not equal to expected value")
                .isEqualTo(expectedOrderSummary.get(basketPageFragment.getDeliveryTitle()));

        Assertions.assertThat(basketPageFragment.getBasketTotal())
                .overridingErrorMessage("Order total does not equal to expected value")
                .isEqualTo(expectedOrderSummary.get(basketPageFragment.getTotalPriceTitle()));
        logger.error("Step Failed");
    }

    @When("I click {string} button on {string} page")
    public void iClickCheckoutButtonOnBasketPage(String arg0, String arg1) {
        basketPageFragment.clickCheckoutButton();
    }

    @Then("I am redirected to the {string} page")
    public void iAmRedirectedToThePage(String arg0) {
        wait.until(ExpectedConditions.urlContains(checkoutPageFragment.getPageUrl()));
        Assertions.assertThat(SingletonDriver.getDriver().getCurrentUrl().contains(checkoutPageFragment.getPageUrl()))
                .overridingErrorMessage("Checkout page is not displayed")
                .isTrue();
    }

    @When("I click {string} button")
    public void iClickBuyNowButton(String arg0) {
        checkoutPageFragment.clickBuyNowButton();
    }

    @Then("the following validation error messages are displayed on Delivery Address form:")
    public void theFollowingValidationErrorMessagesAreDisplayedOnDeliveryAddressForm(Map<String, String> deliveryAddressFormValidationMessages) {
        Assertions.assertThat(checkoutPageFragment.getEmailAddressActualErrorMessage())
                .overridingErrorMessage("Email Address error message is not correct")
                .isEqualTo(deliveryAddressFormValidationMessages.get(checkoutPageFragment.getEmailAddressExpectedErrorMessageKey()));

        Assertions.assertThat(checkoutPageFragment.getNameErrorMessage())
                .overridingErrorMessage("Full name error message is not correct")
                .isEqualTo(deliveryAddressFormValidationMessages.get(checkoutPageFragment.getFullNameExpectedErrorMessageKey()));

        Assertions.assertThat(checkoutPageFragment.getAddressErrorMessage())
                .overridingErrorMessage("Address line 1 error message is not correct")
                .isEqualTo(deliveryAddressFormValidationMessages.get(checkoutPageFragment.getAddressLine1ExpectedErrorMessageKey()));

        Assertions.assertThat(checkoutPageFragment.getTownCityErrorMessage())
                .overridingErrorMessage("Town/city error message is not correct")
                .isEqualTo(deliveryAddressFormValidationMessages.get(checkoutPageFragment.getTownCityExpectedErrorMessageKey()));

        Assertions.assertThat(checkoutPageFragment.getZipCodeErrorMessage())
                .overridingErrorMessage("Postalcode/Zip error message is not correct")
                .isEqualTo(deliveryAddressFormValidationMessages.get(checkoutPageFragment.getPostcodeZipExpectedErrorMessageKey()));
    }

    @And("the following validation error messages are displayed on Payment form:")
    public void areTheFollowingErrorMessagesDisplayedOnPaymentForm(List<String> paymentFormErrorMessages) {
        Assertions.assertThat(checkoutPageFragment.getCardNumberErrorMessage().contains(paymentFormErrorMessages.get(0)))
            .overridingErrorMessage("Wrong card number error message").isTrue();

        Assertions.assertThat(checkoutPageFragment.getExpirationDateErrorMessage().contains(paymentFormErrorMessages.get(1)))
            .overridingErrorMessage("Wrong expiration date error message").isTrue();

        Assertions.assertThat(checkoutPageFragment.getCvvErrorMessage().contains(paymentFormErrorMessages.get(2)))
            .overridingErrorMessage("Wrong CVV error message").isTrue();
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummaryIsAsFollowing(@Transpose Map<String, String> expectedSummary) {
        Assertions.assertThat(checkoutPageFragment.getSubTotalOfTheCheckoutSummaryComponent())
                .overridingErrorMessage("Sub-total does not equal to expected value in the Checkout Summary Component")
                .isEqualTo(expectedSummary.get(checkoutPageFragment.getCheckoutSubtotal()));

        Assertions.assertThat(checkoutPageFragment.getDeliveryOfTheCheckoutSummaryComponent())
                .overridingErrorMessage("Delivery does not equal to expected value in the Checkout Summary Component")
                .isEqualTo(expectedSummary.get(checkoutPageFragment.getDeliveryTotal()));

        Assertions.assertThat(checkoutPageFragment.getVATOfTheCheckoutSummaryComponent())
                .overridingErrorMessage("VAT does not equal to expected value in the Checkout Summary Component")
                .isEqualTo(expectedSummary.get(checkoutPageFragment.getCheckoutSummaryVAT()));

        Assertions.assertThat(checkoutPageFragment.getTotalOfTheCheckoutSummaryComponent())
                .overridingErrorMessage("Total does not equal to expected value in the Checkout Summary Component")
                .isEqualTo(expectedSummary.get(checkoutPageFragment.getCheckoutSummaryTotal()));
    }

    @And("I checkout as a new customer with email {string}")
    public void iCheckoutAsANewCustomerWithEmail(String email) {
        checkoutPageFragment.fillInEmailAddress(email);
    }

    @When("I fill delivery address information manually:")
    public void iFillDeliveryAddressInformationManually(@Transpose Map<String,String> deliveryAddress) {
        checkoutPageFragment.fillInDeliveryAddressForm(deliveryAddress);
    }

    @Then("there is no validation error messages displayed on Delivery Address form")
    public void thereIsNoValidationErrorMessagesDisplayedOnDeliveryAddressForm() {
        Assertions.assertThat(checkoutPageFragment.getEmailAddressActualErrorMessage().isEmpty())
            .overridingErrorMessage("Email Address error message is displayed")
            .isTrue();

        Assertions.assertThat(checkoutPageFragment.getNameErrorMessage().isEmpty())
            .overridingErrorMessage("Full name error message is displayed")
            .isTrue();

        Assertions.assertThat(checkoutPageFragment.getAddressErrorMessage().isEmpty())
            .overridingErrorMessage("Address line 1 error message is displayed")
            .isTrue();

        Assertions.assertThat(checkoutPageFragment.getTownCityErrorMessage().isEmpty())
            .overridingErrorMessage("Town/city error message is displayed")
            .isTrue();

        Assertions.assertThat(checkoutPageFragment.getZipCodeErrorMessage().isEmpty())
            .overridingErrorMessage("Postalcode error message is displayed")
            .isTrue();
    }

    @When("I enter my card details")
    public void iEnterMyCardDetails(Map<String, String> cardData) {
        checkoutPageFragment.fillInCardDetailsInThePaymentArea(cardData);
    }
}
