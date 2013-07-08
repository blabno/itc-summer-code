package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 08.07.13
 * Time: 10:38
 * To change this template use File | Settings | File Templates.
 */
public class NewsletterTest2 {
    /**
     * TERMS:
     * Type email twice the same
     *
     * SCENARIO:
     * 1. Type email into input field
     * 2. Press 'enter' key or click on 'sign up'
     * 3. Type same email again
     *
     * EXPECTED:
     * AssertEquals("Sorry, but mail cannot be send", popup.getText())
     *
     */
    @Test
    public void twoSameEmailToSubscibeTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Input is empty, don't type anything
     *
     * SCENARIO:
     * 1. Don't type anything
     * 2. Click "Sign in" button or press enter key
     *
     * EXPECTED:
     * AssertEquals("Enter your email here to subscribe" ,popup.getText())
     *
     */
    @Test
    public void emptyStringInInputTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Input some email wrong, e. g. without "@" symbol
     *
     * SCENARIO:
     * 1. Input random text e.g. "bwhhs"
     * 2. Hit enter
     *
     * EXPECTED
     * AssertEquals("not well-formed email address", popup.getText())
     */
    @Test
    public void isEmailCorrectTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * Type some correct email address
     *
     * SCENARIO:
     * 1. Type email
     * 2. Hit enter key
     *
     * EXPECTED:
     * AssertEquals("Your email has been added", popup.getText())
     */
    @Test
    public void isEmailHasBeenAddedTest(){
        Assert.fail("Not implemented yet");
    }
}
