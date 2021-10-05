package hooks;

import driver.SingletonDriver;
import io.cucumber.java.After;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShoot {
    private Date currentDate = new Date();
    private String screenShotName = currentDate.toString().replace(" ", "-").replace(":", "-");
    private File screenShot = ((TakesScreenshot) SingletonDriver.getDriver()).getScreenshotAs(OutputType.FILE);

    @After
    public void getScreenShoot() throws IOException {
        FileUtil.copyFile(screenShot, new File("C://Users//Roman_Hryhorenko//IdeaProjects//FrameworkTemplate//screenshot" + screenShotName + ".png"));
    }

}
