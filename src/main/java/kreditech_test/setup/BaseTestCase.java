package kreditech_test.setup;

import kreditech_test.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by roma.barabash on 7/25/2017.
 */


public class BaseTestCase extends BaseTest{

    public GooglePage google;
    public KreditechPage kreditech;
    public FacebookPage facebook;
    public LinkedinPage linkedin;
    public TwitterPage twitter;
    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void getLogPage() {

        google = new GooglePage(getDriver());
        PageFactory.initElements(getDriver(), GooglePage.class);

        kreditech = new KreditechPage(getDriver());
        PageFactory.initElements(getDriver(), KreditechPage.class);

        facebook = new FacebookPage(getDriver());
        PageFactory.initElements(getDriver(), FacebookPage.class);

        linkedin = new LinkedinPage(getDriver());
        PageFactory.initElements(getDriver(), LinkedinPage.class);

        twitter = new TwitterPage(getDriver());
        PageFactory.initElements(getDriver(), TwitterPage.class);

    }

    @BeforeClass
    public void setUp() throws IOException {
        chooseBrowsers();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }


}
