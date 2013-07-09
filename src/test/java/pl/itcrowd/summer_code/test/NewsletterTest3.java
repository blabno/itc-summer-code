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
public class NewsletterTest3 {

    @Drone
    WebDriver driver;

    @Page
    private Newsletter newsletter;

    @Test
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
