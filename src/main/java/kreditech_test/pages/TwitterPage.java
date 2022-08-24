package kreditech_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by roma.barabash on 7/27/2017.
 */
public class TwitterPage extends AbstractPage {

    private static Logger log = Logger.getLogger(TwitterPage.class.getName());

    @FindBy(css = ".ProfileHeaderCard-nameLink.u-textInheritColor.js-nav")
    private WebElement twitterHead;


    public TwitterPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTwitterHeadText() {
        log.info("got Twitter head text");
        captureScreenshot("getFacebookHeadText");
        return twitterHead.getText();

    }

}
