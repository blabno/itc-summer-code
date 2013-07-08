package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 08.07.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class UserBoxTest2 {

    /**
     * TERMS:
     * Method checks that link connected to psychics name provide to right page
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Click on Psychic7 name
     *
     * EXPECTED:
     * check expected url with current url after click
     * assertEquals("https://itcrowd.pl/vop/Psychic7", driver.getCurrentUrl())
     */
    @Test
    public void clickOnPsychicNameTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Checks if psychic is offline
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Retrieve status text
     * 3. Assert
     *
     * EXPECTED:
     * Compare retrieved status text with expected "offline"
     * assertEquals("offline", element.getText());
     */
    @Test
    public void isPsychicOfflineTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Checks if "E-mail" button provide to correct URL
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Click on "E-mail" button
     * 3. Assert
     *
     * EXPECTED:
     * Compare expected URL with current URL after click
     * assertEquals("https://itcrowd.pl/vop/private/createMessage?userId=7", driver.getCurrentUrl())
     */
    @Test
    public void EmailButtonTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Checks if "Read more" button provide to correct URL
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Click on "Read more" button
     * 3. Assert
     *
     * EXPECTED:
     * Compare expected URL with current URL after click
     * assertEquals("https://itcrowd.pl/vop/Psychic7", driver.getCurrentUrl())
     */
    @Test
    public void ReadMoreButtonTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * Checks if price showed in box is equals to this from getter
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Assert
     *
     * EXPECTED:
     * Compare expected prize as string to this connected to WebElement
     * assertEquals("$ 0.50 / min", webElement)
     */
    @Test
    public void CashPerMinuteTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * Checks if psychics description is correct to this from getter
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Get text from description to String
     * 3. Assert
     *
     * EXPECTED:
     * Compare expected text with this in String variable
     * assertEquals("I am Nature Born Psychic and Spiritual Messenger, Contact me for Honest reading.", stringVal);
     */
    @Test
    public void descriptionTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS
     * Checks if 6 boxes are displayed
     *
     * SCENARIO:
     * 1. Go to main page
     * 2. Try to get 6 psychics names from HTML
     * 3. Assert
     *
     * EXPECTED:
     * Compare each 'n' every psychic name from getter with expected
     * assertEquals("psychic7", driver.getPsychic7)
     * assertEquals("Max1", driver.getMax)
     * and so on..
     */
    @Test
    public void isThere6BoxesTest(){
        Assert.fail("Not implemented yet");
    }
}
