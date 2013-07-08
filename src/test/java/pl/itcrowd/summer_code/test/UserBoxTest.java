package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Arquillian.class)
public class UserBoxTest {


    /**
     * TERMS
     * UserBox 1 in Top Psychics should contain a short description of Top Psychic
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if Description of Top Psychic contain a short description of Psychic
     */
    @Test
    public void testDesrtiption(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * UserBox in Top Psychics should contain a price of Psychic.
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if price of Psychic is Displayed and if this price is correct
     */
    @Test
    public void testPrice(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * UserBox in Top Psychics should contain information about Psychic status (online/offline)
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
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * Test if UserBox in Top Psychics contain a nickname of Psychic
     *
     * SCENARIO
     * 1.Open the Homepage
     *
     * EXPECTED VALUES
     * Check if Nickname of psychic is not empty
     */
    @Test
    public void testNickname(){
        Assert.fail("Not implemented yet");
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
    public void testNicknmeClick(){
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
    public void testEmailCLick(){
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
    public void testCountUserBox(){
        Assert.fail("Not implemented yet");
    }
}