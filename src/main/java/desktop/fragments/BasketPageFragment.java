package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.JsExecutor;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class BasketPageFragment extends AbstractFragment {

    JsExecutor jsExecutor = new JsExecutor();

    private String pageUrl = "https://www.bookdepository.com/basket";

    private String checkoutButton = "//div[@class='basketHeaderButtons']//a[contains(@class,'optimizely-variation-1')]";

    private static final By basketDeliveryPrice = By.xpath("//*[@class='delivery-text']/dd");
    private static final String basketPriceMap = "Delivery cost";

    private static final By basketTotalPrice = By.xpath("//*[@class='total']/dd");
    private static final String basketTotalMap = "Total";

    public String getPageUrl() {
        return pageUrl;
    }

    public String getDeliveryPrice(){
        return getText(basketDeliveryPrice);
    }

    public String getBasketTotal(){
        return getText(basketTotalPrice);
    }

    public String getDeliveryTitle(){
        return basketPriceMap;
    }

    public String getTotalPriceTitle(){
        return basketTotalMap;
    }

    public void clickCheckoutButton() {
        jsExecutor.javascriptClick(checkoutButton);
    }


}
