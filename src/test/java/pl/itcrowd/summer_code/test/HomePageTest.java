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
public class HomePageTest {

    @Drone
    WebDriver browser;

    @Page
    HomePage homePage;

    @Before
    public void beforeTests(){}

    @Test
    /**TERMS
     * Validates a click 'Are you PSYCHIC? JOIN NOW' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'Are you PSYCHIC? JOIN NOW' button.
     * EXPECTED
     * User will be redirected to register psychic page */
    public void testAreYouPsychicJoin()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        homePage.areYouPsychicJoinClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/registerPsychic.jsf"));
    }

    @Test
    /**TERMS
     * Validates a click 'Register to get 3 minutes chat for free' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'Register to get 3 minutes chat for free' button.
     * EXPECTED
     * User will be redirected to register user page */
    public void testRegisterToGet3Minutes()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        homePage.registerToGet3MinutesClick();
        //then
        assertEquals("https://itcrowd.pl/vop/register", browser.getCurrentUrl());
    }
}
