package kreditech_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by roma.barabash on 7/27/2017.
 */

public class GooglePage extends AbstractPage {

    public String googleUrl = "https://www.google.com";
    private static Logger log = Logger.getLogger(GooglePage.class.getName());

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(id = "hplogo")
    private WebElement googleLogo;

    @FindBy(css = "#rso ._NId:nth-of-type(1) .rc .r a")
    private WebElement kreditechLink;

    public GooglePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GooglePage openGooglePage(){
        getDriver().get(googleUrl);
        getDriver().manage().window().maximize();
        log.info("opened google page");
        captureScreenshot("openGooglePage");
        return this;
    }

    public GooglePage searchGoogle(String term){
        searchField.sendKeys(term);
        searchField.sendKeys(Keys.ENTER);
        log.info("searched by: '" + term + "' term");
        captureScreenshot("searchGoogle");
        return this;
    }

    public GooglePage goToKreditechHomePage(){
        kreditechLink.click();
        log.info("opened Kreditech home page  ");
        captureScreenshot("goToKreditechHomePage");
        return this;
    }























}
