package kreditech_test.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by roma.barabash on 7/25/2017.
 */

public class BaseTest {

    protected WebDriver getDriver() {
        return driver;
    }

    private static final String sFileName = "testBrowser.properties";
    private static String sDirSeparator = System.getProperty("file.separator");
    private static Properties props = new Properties();
    public WebDriver driver;
    private static Logger log = Logger.getLogger(BaseTest.class.getName());


    public WebDriver chooseBrowsers() throws IOException {
        File currentDir = new File(".");

        String sFilePath = currentDir.getCanonicalPath() + sDirSeparator + sFileName;
        FileInputStream ins = new FileInputStream(sFilePath);
        props.load(ins);
        String browser = props.getProperty("BROWSER");

        switch (browser) {
            case "Chrome":
                log.info("*** Test started with Chrome browser ***");
                return createChromeDriver();
            default:
                log.info("*** Test started with Firefox browser ***");
                return createFirefoxDriver();
        }

    }

    //GH 59, chromedriver 2.31
    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roma.barabash\\GitProjects\\kreditech-test-task\\chromedriver_2_31\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }


    //FF 47.0.1
    private WebDriver createFirefoxDriver() {
        driver = new FirefoxDriver();
        return driver;
    }


    @AfterSuite
    public void browseClose() {
        driver.close();
        driver.quit();
        log.info("*** Test finished ***");
    }


}
