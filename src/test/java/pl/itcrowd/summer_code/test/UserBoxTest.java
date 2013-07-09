package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(Arquillian.class)
public class UserBoxTest {

    @FindBy(css = ".grayBorderedPanel:nth-of-type(1)")
    UserBox psychic7;

    @FindBy(css = "#j_idt78")
    UserBox otherUsers;

    @Drone
    WebDriver browser;

    @Before
    public void beforeTests(){

    }
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
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String text = psychic7.getDescriptionText();
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
        psychic7.readMoreClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/Psychic7"));
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
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String price = psychic7.getPriceValue();
        //Then
        assertEquals("$ 0.50 / min", price);
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
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        boolean status = psychic7.statusOnline();
        //Then
        assertFalse(status);
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
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String userName = psychic7.getNameInfo();
        boolean checkEmpty = false;
        if(userName.isEmpty()) checkEmpty = true;
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
        psychic7.nameClick();
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
        psychic7.imageClick();
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
        psychic7.emailClick();
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
    public void testCountUserBox(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        String [] userNames = new String[6];
        boolean check = false;
        userNames[0] = psychic7.getNameInfo();
        if(!(userNames[0].isEmpty())){
            check = true;
        }
        userNames[1] = otherUsers.getMax1Name();
        if(!(userNames[1].isEmpty())){
            check = true;
        }
        userNames[2] = otherUsers.getPeterName();
        if(!(userNames[2].isEmpty())){
            check = true;
        }
        userNames[3] = otherUsers.getPsychic5Name();
        if(!(userNames[3].isEmpty())){
            check = true;
        }
        userNames[4] = otherUsers.getKrzysztof52Name();
        if(!(userNames[4].isEmpty())){
            check = true;
        }
        userNames[5] = otherUsers.getPsychic4Name();
        if(!(userNames[5].isEmpty())){
            check = true;
        }
        //Then
        assertTrue(check);
    }
}