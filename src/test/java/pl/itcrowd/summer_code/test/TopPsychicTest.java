package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.*;

@RunWith(Arquillian.class)
public class TopPsychicTest {

    @Drone
    WebDriver browser;

    @Before
    public void beforeTests(){

    }

    @Page
    TopPsychic topPsychic;

    /**
     * TERMS
     * TopPsychic 1 in Top Psychics should contain a short description of Top Psychic
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if Description of Top Psychic contain a short description of Psychic
     */

    @Test
    public void testDescription(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String text = topPsychic.getTopPsychic(0).getDescription();
        //Then
        assertEquals("I am Nature Born Psychic and Spiritual Messenger, Contact me for Honest reading.", text);
    }

    /**
     * TERMS
     * Test of click on Read More link for navigate to Top Psychic profile page
     *
     * SCENARIO
     * 1.Open the Homepage
     * 2.Click on Read More link in User Box
     *
     * EXPECTED VALUES
     * Check if currentUrl is correct
     */
    @Test
    public void testReadMoreClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        topPsychic.getTopPsychic(0).readMoreClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/Psychic7"));
    }

    /**
     * TERMS
     * TopPsychic in Top Psychics should contain a price of Psychic.
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if price of Psychic is Displayed and if this price is correct
     */
    @Test
    public void testPrice(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String price = topPsychic.getTopPsychic(0).getPrice();
        //Then
        assertEquals("$ 0.50 / min", price);
    }

    /**
     * TERMS
     * TopPsychic in Top Psychics should contain information about Psychic status (online/offline)
     *
     * SCENARIO
     * 1.Open the Homepage
     * 2.Check if statuses in 1, 2 and 3 User Boxes are set as Offline
     * 3.Set 1 and 2 User status as online
     *
     * EXPECTED VALUES
     * Check if Psychic statuses in User Box 1 and 2 are displayed as Online
     * Check if Psychic status in User Box 3 is displayed as Offline
     */
    @Test
    public void testStatus(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        boolean status = topPsychic.getTopPsychic(0).statusOnline();
        //Then
        assertFalse(status);
    }

    /**
     * TERMS
     * Test if TopPsychic in Top Psychics contain a nickname of Psychic
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if Nickname of psychic is not empty
     */
    @Test
    public void testNickname(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String psychicName = topPsychic.getTopPsychic(0).getName();
        boolean checkEmpty = false;
        if(psychicName.isEmpty()) checkEmpty = true;
        //Then
        assertFalse(checkEmpty);
    }

    /**
     * TERMS
     * Test of click on Top Psychic nickname for navigate to Psychic profile page
     *
     * SCENARIO
     * 1.Open the Homepage
     * 2.Click on Psychic nickname in User Box
     *
     * EXPECTED VALUES
     * Check if current url is correct
     */
    @Test
    public void testNicknameClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        topPsychic.getTopPsychic(2).nameClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/Psychic7"));
    }

    /**
     * TERMS
     * TEst of click on Top Psychic image for navigate to this Psychic profile page
     *
     * SCENARIO
     * 1.Open the Homepage
     * 2.Click on Psychic image in User Box
     *
     * EXPECTED VALUES
     * Check if currentUrl is correct
     */
    @Test
    public void testImageClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        topPsychic.getTopPsychic(0).imageClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/Psychic7"));
    }

    /**
     * TERMS
     * Test of click on email button for navigate to page where user can write email message to Top Psychic
     *
     * SCENARIO
     * 1.Open the Homepage
     * 2.Click on email button in User Box
     *
     * EXPECTED VALUES
     * Check if currentUrl is correct
     */
    @Test
    public void testEmailClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        topPsychic.getTopPsychic(0).emailClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private/createMessage?userId=7"));
    }

    /**
     * TERMS
     * Test check if there is 6 Top Psychics on Homepage
     *
     * SCENARIO
     * 1.Open the Homepage

     * EXPECTED VALUES
     * Check if number of User Boxes is equal 6
     */
    @Test
    public void testCountTopPsychics(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        final int topPsychicsSize = topPsychic.getTopPsychicsSize();
        String text = topPsychic.getTopPsychic(0).getDescription();
        //Then
        assertEquals("There should be 6 psychics on home page", 6, topPsychicsSize);
    }
}