package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.JsExecutor;
import org.openqa.selenium.By;

public class BasketPageFragment extends AbstractFragment {

    JsExecutor jsExecutor = new JsExecutor();

    private String pageUrl = "https://www.bookdepository.com/basket";

    private String checkoutButton = "//div[@class='basketHeaderButtons']//a[contains(@class,'checkout-btn btn')]";

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
