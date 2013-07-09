import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 05.07.13
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class FooterTest {
    @FindBy(css = "#footer")
    Footer footer;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){

    }
    @Test
    public void testHelpButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.helpButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER"));
    }
    @Test
    public void testAboutUsButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.aboutUsButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/ABOUT"));
    }
    @Test
    public void testHowItWorksButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.howItWorksButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/help.jsf?content=LOGIN_SIGNUP_CUSTOMER&mode=CUSTOMER"));
    }
    @Test
    public void testAboutPsychicReadingsButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.aboutPsychicReadingsButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PSYCHIC_READING"));
    }
    @Test
    public void testContactUsButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.contactUsButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/contact"));
    }
    @Test
    public void testPrivacyPolicyButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.privacyPolicyButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/PRIVACY_POLICY"));
    }
    @Test
    public void testTermsConditionsButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.termsConditionsButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/page/TERMS"));
    }
    @Test
    public void testConnectWithUsByFB(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.connectWithUsByFBClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://www.facebook.com/PsychicMarketplace"));
    }
    @Test
    public void testConnectWithUsByTwitter(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.connectWithUsByTwitterClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://twitter.com/voiceofpsychic"));
    }
    @Test
    public void testConnectWithUsByPinterest(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.connectWithUsByPinterestClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("http://pinterest.com/voiceofpsychic/"));
    }
    @Test
    public void testConnectWithUsByYT(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        footer.connectWithUsByYTClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://www.youtube.com/voiceofpsychic"));
    }

}
