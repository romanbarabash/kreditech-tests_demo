package kreditech_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

/**
 * Created by roma.barabash on 7/27/2017.
 */

public class KreditechPage extends AbstractPage {

    private static Logger log = Logger.getLogger(KreditechPage.class.getName());

    @FindBy(css = ".social.linkedin a")
    private WebElement linkedinButton;

    @FindBy(css = ".social.facebook a")
    private WebElement facebookButton;

    @FindBy(css = ".social.twitter a")
    private WebElement twitterButton;

    @FindBy(id = "menu-item-970")
    private WebElement homeTab;

    @FindBy(id = "menu-item-53")
    private WebElement whatWeDoTab;

    @FindBy(id = "menu-item-107")
    private WebElement whatWeAreTab;

    @FindBy(id = "menu-item-3975")
    private WebElement workWithUsTab;

    @FindBy(id = "menu-item-47")
    private WebElement careersTab;

    @FindBy(id = "menu-item-4040")
    private WebElement investorRelationsTab;

    @FindBy(id = "menu-item-45")
    private WebElement pressTab;

    @FindBy(id = "menu-item-3979")
    private WebElement magazineTab;


    public KreditechPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public KreditechPage openLinkedinPage(){
        linkedinButton.click();
        log.info("opened linkedin page");
        captureScreenshot("openLinkedinPage");
        return this;
    }

    public KreditechPage openFacebookPage(){
        facebookButton.click();
        log.info("opened facebook page");
        captureScreenshot("openFacebookPage");
        return this;
    }

    public KreditechPage openTwitterPage(){
        twitterButton.click();
        log.info("opened twitter page");
        captureScreenshot("openTwitterPage");
        return this;
    }

    public KreditechPage openHomePage(){
        homeTab.click();
        log.info("opened home page");
        captureScreenshot("openHomePage");
        return this;
    }

    public KreditechPage openWhatWeDoPage(){
        whatWeDoTab.click();
        log.info("opened What We Do page");
        captureScreenshot("openWhatWeDoPage");
        return this;
    }

    public KreditechPage openWhoWeArePage(){
        whatWeAreTab.click();
        log.info("opened Who We Are page");
        captureScreenshot("openWhoWeArePage");
        return this;
    }

    public KreditechPage openWorkWithUsPage(){
        workWithUsTab.click();
        log.info("opened Work With Us page");
        captureScreenshot("openWorkWithUsPage");
        return this;
    }

    public KreditechPage openCareersPage(){
        careersTab.click();
        log.info("opened Careers page");
        captureScreenshot("openCareersPage");
        return this;
    }

    public KreditechPage openInvestorRelationsPage(){
        investorRelationsTab.click();
        log.info("opened Investor Relations page");
        captureScreenshot("openInvestorRelationsPage");
        return this;
    }

    public KreditechPage openPressTabPage(){
        pressTab.click();
        log.info("opened Press page");
        captureScreenshot("openPressTabPage");
        return this;
    }

    public KreditechPage openMagazinePage(){
        magazineTab.click();
        log.info("opened Magazine page");
        captureScreenshot("openMagazinePage");
        return this;
    }

    public String getPageTitle(){
        log.info("get page title");
        return getDriver().getTitle().toString();
    }

    public KreditechPage switchToWindow(int window){
        ArrayList<String> tabs = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(window));
        log.info("switched to window # " + window + "");
        captureScreenshot("switchToWindow" + window);
        return this;
    }

}
