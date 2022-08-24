package kreditech_test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by roma.barabash on 7/27/2017.
 */
public class LinkedinPage extends AbstractPage {

    private static Logger log = Logger.getLogger(LinkedinPage.class.getName());

    @FindBy(css = ".org-top-card-module__name")
    private WebElement linkedinHead;

    @FindBy(css = ".form-subtext.login a")
    private WebElement signUpLinkedin1;

    @FindBy(id = "login-email")
    private WebElement loginLinkedin1;

    @FindBy(id = "login-password")
    private WebElement passwordLinkedin1;

    @FindBy(id = "login-submit")
    private WebElement signInBtnLinkedin1;

    @FindBy(className = "sign-in-link")
    private WebElement signUpLinkedin2;

    @FindBy(id = "session_key-login")
    private WebElement loginLinkedin2;

    @FindBy(id = "session_password-login")
    private WebElement passwordLinkedin2;

    @FindBy(id = "btn-primary")
    private WebElement signInBtnLinkedin2;

    @FindBy(id = "nav-settings__dropdown-trigger")
    private WebElement meIcon;

    @FindBy(id = "nav-settings__dropdown-options")
    private WebElement profileFrame;

    @FindBy(css = ".nav-dropdown__action")
    private WebElement signOut;

    public LinkedinPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getlinkedinHeadText(){
        log.info("got linkedin header text");
        captureScreenshot("getlinkedinHeadText");
        return linkedinHead.getText();
    }

    public LinkedinPage signUpLinkedin(String login, String password) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        if(getDriver().getTitle().contains("LinkedIn: Log In or Sign Up")){
            wait.until(ExpectedConditions.elementToBeClickable(signUpLinkedin1));
            signUpLinkedin1.click();
            loginLinkedin1.clear();
            loginLinkedin1.sendKeys(login);
            passwordLinkedin1.clear();
            passwordLinkedin1.sendKeys(password);
            signInBtnLinkedin1.submit();
            log.info("sign up to linkedin with 1st flow");
            captureScreenshot("signUpLinkedin1stFlow");
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(signUpLinkedin2));
            signUpLinkedin2.click();
            loginLinkedin2.clear();
            loginLinkedin2.sendKeys(login);
            passwordLinkedin2.clear();
            passwordLinkedin2.sendKeys(password);
            signInBtnLinkedin2.submit();
            log.info("sign up to linkedin with 2nd flow");
            captureScreenshot("signUpLinkedin2ndFlow");
        }
        return this;
    }

    public LinkedinPage signOut() {
        meIcon.click();
        signOut.click();
        log.info("sign out linkedin");
        captureScreenshot("linkedinSignOut");
        return this;
    }

}







