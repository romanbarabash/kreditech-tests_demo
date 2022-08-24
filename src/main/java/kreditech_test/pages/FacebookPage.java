package kreditech_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by roma.barabash on 7/27/2017.
 */
public class FacebookPage extends AbstractPage   {

    private static Logger log = Logger.getLogger(FacebookPage.class.getName());

    @FindBy(css = "._33vv a")
    private WebElement facebookHead;

    public FacebookPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getFacebookHeadText(){
        log.info("got Facebook head text");
        captureScreenshot("getFacebookHeadText");
        return facebookHead.getText();
    }

}
