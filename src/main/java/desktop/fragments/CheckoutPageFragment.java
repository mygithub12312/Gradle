package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CheckoutPageFragment extends AbstractFragment {
    private static final String checkOutUrl = "https://www.bookdepository.com/payment";

    private static final By buyButton = By.xpath("//*[@class='btn btn-primary full-width']");

    private static final By emailAddressError = By.xpath("(//*[@class='error-block'])[1]");
    private static final By nameErrorMessage = By.xpath("(//*[@class='error-block'])[2]");
    private static final By address1ErrorMessage = By.xpath("(//*[@class='error-block'])[4]");
    private static final By townCityErrorMessage = By.xpath("(//*[@class='error-block'])[6]");
    private static final By zipCodeErrorMessage = By.xpath("(//*[@class='error-block'])[8]");

    private static final By emailField = By.xpath("//*[@name='emailAddress']");
    private static final By nameField = By.xpath("//*[@name='delivery-fullName']");
    private static final By address1Field = By.xpath("//*[@name='delivery-addressLine1']");
    private static final By address2Field = By.xpath("//*[@name='delivery-addressLine2']");
    private static final By townField = By.xpath("//*[@name='delivery-city']");
    private static final By countryField = By.xpath("//*[@name='delivery-county']");
    private static final By zipCodeField = By.xpath("//*[@name='delivery-postCode']");

    private static final String emailExpectedMessage = "Email address";
    private static final String nameExpectedMessage = "Full name";
    private static final String addressExpectedMessage = "Address line 1";
    private static final String townExpectedMessage = "Town/City";
    private static final String zipCodeExpectedMessage = "Postcode/ZIP";

    private static final By subTotals = By.xpath("(//*[@class='text-right'])[1]");
    private static final By deliveryTotal = By.xpath("(//*[@class='text-right'])[2]");
    private static final By vatTotal = By.xpath("//*[@class='text-right total-tax']");
    private static final By checkoutTotal = By.xpath("//*[@class='text-right total-price']");

    private static final By cardNumberErrorMessage = By.xpath("//*[@class='buynow-error-msg']");
    private static final By cardExpDateErrorMessage = By.xpath("//*[@class='buynow-error-msg']");
    private static final By cardCvvErrorMessage = By.xpath("//*[@class='buynow-error-msg']");

    private static final String totalKey = "Sub-total";
    private static final String deliveryKey = "Delivery";
    private static final String vatKey = "VAT";
    private static final String totalsKey = "Total";

    private static final String nameKey = "Full name";
    private static final String address1Key = "Address line 1";
    private static final String address2Key = "Address line 2";
    private static final String townKey = "Town/City";
    private static final String countryKey = "County/State";
    private static final String zipKey = "Postcode";

    private static final String cardNumberKey= "cardNumber";
    private static final String expirationDateKey= "Expiry Month/Year";
    private static final String cvvKey= "Cvv";
    private static final By cardNumber = By.xpath("//*[@name='braintree-hosted-field-number']");
    private static final By expirationDate = By.xpath("//*[@id='braintree-hosted-field-expirationDate']");
    private static final By cvv= By.xpath("//*[@name='braintree-hosted-field-cvv']");
    private static final By cardNumberInputField= By.xpath("//*[@id='credit-card-number']");
    private static final By expirationDateInputField= By.xpath("//*[@id='expiration']");
    private static final By cvvInputField= By.xpath("//*[@id='cvv']");

    public String getPageUrl() {
        return checkOutUrl;
    }

    public void clickBuyNowButton() {
        findElement(buyButton).click();
    }

    public String getEmailAddressActualErrorMessage() {
        return getText(emailAddressError);
    }

    public String getNameErrorMessage() {
        return getText(nameErrorMessage);
    }

    public String getAddressErrorMessage(){
        return getText(address1ErrorMessage);
    }

    public String getTownCityErrorMessage() {
        return getText(townCityErrorMessage);
    }

    public String getZipCodeErrorMessage() {
        return getText(zipCodeErrorMessage);
    }

    public String getEmailAddressExpectedErrorMessageKey() {
        return emailExpectedMessage;
    }

    public String getFullNameExpectedErrorMessageKey(){
        return nameExpectedMessage;
    }

    public String getAddressLine1ExpectedErrorMessageKey() {
        return addressExpectedMessage;
    }

    public String getTownCityExpectedErrorMessageKey() {
        return townExpectedMessage;
    }

    public String getPostcodeZipExpectedErrorMessageKey() {
        return zipCodeExpectedMessage;
    }

    public String getSubTotalOfTheCheckoutSummaryComponent() {
        return findElement(subTotals).getText();
    }

    public String getDeliveryOfTheCheckoutSummaryComponent() {
        return findElement(deliveryTotal).getText();
    }

    public String getVATOfTheCheckoutSummaryComponent() {
        return findElement(vatTotal).getText();
    }

    public String getTotalOfTheCheckoutSummaryComponent() {
        return findElement(checkoutTotal).getText();
    }

    public String getCheckoutSubtotal(){
        return totalKey;
    }

    public String getDeliveryTotal() {
        return deliveryKey;
    }

    public String getCheckoutSummaryVAT(){
        return vatKey;
    }

    public String getCheckoutSummaryTotal() {
        return totalsKey;
    }

    public String getCardNumberErrorMessage() {
        return findElement(cardNumberErrorMessage).getText();
    }

    public String getExpirationDateErrorMessage() {
        return findElement(cardExpDateErrorMessage).getText();
    }

    public String getCvvErrorMessage() {
        return findElement(cardCvvErrorMessage).getText();
    }

    public void fillInEmailAddress(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void fillInDeliveryAddressForm(Map<String,String> deliveryAddressForm) {
        findElement(nameField).sendKeys(deliveryAddressForm.get(nameKey));
        findElement(address1Field).sendKeys(deliveryAddressForm.get(address1Key));
        findElement(address2Field).sendKeys(deliveryAddressForm.get(address2Key));
        findElement(townField).sendKeys(deliveryAddressForm.get(townKey));
        findElement(countryField).sendKeys(deliveryAddressForm.get(countryKey));
        findElement(zipCodeField).sendKeys(deliveryAddressForm.get(zipKey));
        findElement(countryField).click();
    }

    public void fillInCardDetailsInThePaymentArea(Map<String,String> paymentData){
        switchToIframe(findElement(cardNumber));
        findElement(cardNumberInputField).sendKeys(paymentData.get(cardNumberKey));
        switchToDefaultContent();
        switchToIframe(findElement(expirationDate));
        findElement(expirationDateInputField).sendKeys(paymentData.get(expirationDateKey));
        switchToDefaultContent();
        switchToIframe(findElement(cvv));
        findElement(cvvInputField).sendKeys(paymentData.get(cvvKey));
    }
}
