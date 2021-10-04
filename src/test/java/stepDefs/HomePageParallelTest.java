package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageParallelTest {

    @Given("I open the {string} Home Page and verify header is {string}")
    public void iOpenTheHttpsGoogleComHomePageAndVerifyHeaderIsGoogle(String pageUrl, String expectedHeader) {
        WebDriver driver = new ChromeDriver();
        driver.get(pageUrl);
        Assertions.assertEquals(expectedHeader, driver.getTitle(), "Wrong page title");
        driver.quit();
    }
}
