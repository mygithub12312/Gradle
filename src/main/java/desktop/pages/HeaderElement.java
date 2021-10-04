package desktop.pages;

import abstractClasses.page.AbstractPage;
import driver.SingletonDriver;

public class HeaderElement extends AbstractPage {

    private String homePageURL = "https://www.bookdepository.com/";

    public HeaderElement() {
        setPageUrl(homePageURL);
    }


}
