package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(Arquillian.class)
public class NewsletterTest {

    @Drone
    WebDriver driver;

    @Page
    private Newsletter newsletter;

    @Test
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
    public void twoSameEmailToSubscibeTest(){

        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //when
        newsletter.setInput("test123@gmail.com");
        newsletter.clickSignUp();
        newsletter.setInput("test123@gmail.com");
        newsletter.clickSignUp();
        //then
        assertEquals("Sorry, but mail can not be send, try later", newsletter.getPopUpText());
    }
    @Test
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
    public void emptyStringInInputTest(){
        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //when
        newsletter.setInput("");
        newsletter.clickSignUp();
        //then
        assertEquals("Enter your email here to subscribe", newsletter.getPopUpText());
    }
    @Test
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
    public void isEmailCorrectTest()
    {
        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //when
        newsletter.setInput("bwhhs");
        newsletter.clickSignUp();
        //then
        assertEquals("not a well-formed email address", newsletter.getPopUpText());
    }
    @Test
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
    public void isEmailHasBeenAddedTest(){
        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        String randomEmail = UUID.randomUUID().toString() + "@ymail.com";
        //then
        newsletter.setInput(randomEmail);
        newsletter.clickSignUp();
        //then
        assertEquals("Your address has been added to subscriber list. Check your email and activate subscription.", newsletter.getPopUpText());
    }

}
