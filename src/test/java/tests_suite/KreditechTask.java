package tests_suite;

import kreditech_test.setup.BaseTestCase;
import org.testng.annotations.Test;

/**
 * Created by roma.barabash on 7/29/2017.
 */

public class KreditechTask extends BaseTestCase {



    @Test
    public void KreditechTaskTest() {

        //open google, find and open kreditech.com
        google.openGooglePage()
                .searchGoogle("kreditech")
                .goToKreditechHomePage();

        //open facebook page and ensure its relation to Kreditech
        kreditech.openFacebookPage()
                .switchToWindow(1);
        softAssert.assertEquals(facebook.getFacebookHeadText(), "Kreditech", "verify facebook head text is matched");

        //open twitter page and ensure its relation to Kreditech
        kreditech.switchToWindow(0)
                .openTwitterPage()
                .switchToWindow(2);
        softAssert.assertEquals(twitter.getTwitterHeadText(), "Kreditech", "verify twitter head text is matched");

        //open, sign in linkedin page and ensure its relation to Kreditech
        kreditech.switchToWindow(0)
                .openLinkedinPage()
                .switchToWindow(3);
        linkedin.signUpLinkedin("666qa.test@gmail.com","29072017test");
        softAssert.assertEquals(linkedin.getlinkedinHeadText(), "Kreditech Holding SSL GmbH",
                "verify linkedin head text is matched");
        linkedin.signOut();

        //open each of navigation bar item and ensure location on appropriate page
        kreditech.switchToWindow(0)
                .openWhatWeDoPage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Kreditech – Providing access to credit for the underbanked",
                "verify What We Do page is opened ");

        kreditech.openWhoWeArePage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Who we are - Kreditech", "verify Who We Are page is opened ");

        kreditech.openWorkWithUsPage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Work with Kreditech in Hamburg, Data Science, Engineering, Finance",
                "verify Work With Us page is opened ");

        kreditech.openCareersPage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Kreditech Career Opportunities – Hamburg and worldwide",
                "verify Careers page is opened ");

        kreditech.openInvestorRelationsPage();
        softAssert.assertEquals(kreditech.getPageTitle().substring(0,26), "Investor Relations Website",
                "verify Investor Relations page is opened ");

        kreditech.openPressTabPage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Media & Press | Kreditech Group Website",
                "verify Press page is opened ");

        kreditech.openMagazinePage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Magazine - Kreditech",
                "verify Magazine page is opened ");

        kreditech.openHomePage();
        softAssert.assertEquals(kreditech.getPageTitle(), "Kreditech - Financial Freedom for the Underbanked",
                "verify Home page is opened ");

        softAssert.assertAll();

    }

}
