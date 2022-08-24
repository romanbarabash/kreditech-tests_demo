package kreditech_test.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roma.barabash on 7/28/2017.
 */

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void captureScreenshot(String object) {
        String fileDateDayTime = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
        String fileDateDay = new SimpleDateFormat("yyyyMMdd").format(new Date());
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File("screenshots\\"+ fileDateDay +"\\"+ object + fileDateDayTime));
            }
                catch (IOException e)
            {
                e.printStackTrace();
            }
    }

}
