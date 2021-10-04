package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static constants.Constants.IMPLICITLY_WAIT_TIMEOUT;
import static driver.CapabilitiesHelper.getChromeOptions;

public class SingletonDriver {

    private static WebDriver instance;

    public static void setProperty() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            System.setProperty("geckodriver.chrome.driver", "src/main/resources/geckodriver.exe");
    }

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new ChromeDriver(getChromeOptions());
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        }
        return instance;
    }
}
