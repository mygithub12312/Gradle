package desktop.pages;

import abstractClasses.page.AbstractPage;
import driver.SingletonDriver;

public class HeaderElement extends AbstractPage {

    private static final String pageUrl = "https://www.bookdepository.com/";

    public void homePageUrl() {
        setPageUrl(pageUrl);
    }

}
