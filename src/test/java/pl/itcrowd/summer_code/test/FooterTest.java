package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class FooterTest {

    @Drone
    WebDriver browser;

    @Page
    Footer footer;

    @Before
    public void beforeTests()
    {}

    @Test
    /**TERMS
     * Validates a click 'About Physic Readings' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'About Physic Readings' button.
     * EXPECTED
     * User will be redirected to 'physic reading' page */
    public void testAboutPsychicReadingsButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.aboutPsychicReadingsButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PSYCHIC_READING"));
    }

    @Test
    /**TERMS
     * Validates a click 'about us' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on about us button.
     * EXPECTED
     * User will be redirected to 'about' page */
    public void testAboutUsButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.aboutUsButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/ABOUT"));
    }

    @Test
    /**TERMS
     * Validates a click 'connect with us by Facebook' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'connect with us by Facebook' button.
     * EXPECTED
     * User will be redirected to facebook.com/PsychicMarketplace */
    public void testConnectWithUsByFB()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.connectWithUsByFBClick();
        //then
        assertEquals("https://www.facebook.com/PsychicMarketplace", browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click 'connect with us by Pinterest' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'connect with us by Pinterest' button.
     * EXPECTED
     * User will be redirected to pinterest.com/voiceofpsychic/ */
    public void testConnectWithUsByPinterest()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //then
        footer.connectWithUsByPinterestClick();
        //then
        assertEquals("http://pinterest.com/voiceofpsychic/", browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click 'connect with us by Twitter' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'connect with us by Twitter' button.
     * EXPECTED
     * User will be redirected to twitter.com/voiceofpsychic */
    public void testConnectWithUsByTwitter()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.connectWithUsByTwitterClick();
        //then
        assertEquals("https://twitter.com/voiceofpsychic", browser.getCurrentUrl());
    }

    public void testConnectWithUsByYoutube()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.connectWithUsByYTClick();
        //then
        assertEquals("https://www.youtube.com/voiceofpsychic", browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click 'contact us' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'contact us' button.
     * EXPECTED
     * User will be redirected to 'contact' page */
    public void testContactUsButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.contactUsButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/contact"));
    }

    @Test
    /**TERMS
     * Validates a click help button.
     * SCENARIO
     * User has entered on a homepage. User clicks on help button.
     * EXPECTED
     * User will be redirected to help page */
    public void testHelpButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.helpButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf"));
    }

    @Test
    /**TERMS
     * Validates a click 'How it works' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'How it works' button.
     * EXPECTED
     * User will be redirected to 'How it works' page */
    public void testHowItWorksButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.howItWorksButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER"));
    }

    @Test
    /**TERMS
     * Validates a click 'privacy policy' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'privacy policy' button.
     * EXPECTED
     * User will be redirected to 'privacy policy' page */
    public void testPrivacyPolicyButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.privacyPolicyButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PRIVACY_POLICY"));
    }

    @Test
    /**TERMS
     * Validates a click 'terms & conditions' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'terms & conditions' button.
     * EXPECTED
     * User will be redirected to 'terms & conditions' page */
    public void testTermsConditionsButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop");
        //when
        footer.termsConditionsButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/TERMS"));
    }
}