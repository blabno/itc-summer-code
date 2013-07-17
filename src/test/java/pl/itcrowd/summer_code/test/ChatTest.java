package pl.itcrowd.summer_code.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ChatTest {

    @Drone
    WebDriver browser;

    @Page
    Chat chat;

    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests(){}

    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'No'.
     * EXPECTED
     * Popup window will disappeared. */
    @Test
    public void chatExitTest(){
        //given
        //User Max1 maxio89@gmail.com : aaaaaa have to be logged in (we want to chat with him).
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        chat.chatButtonClick();
        chat.noButtonClick();
        //then
        assertFalse(chat.isPopUpBoxDisplayed());
    }

    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'Yes'.
     * EXPECTED
     * Popup window will showed current price for every minute chat. User will be waiting for confirmation from physic
     * and if physic will agreed 'chat window' will displayed. If physic will not confirmed dialog then popup message
     * will displayed with text " 'physic nickname' declined your chat proposition." */
    @Test
    public void chatForCreditsTest(){
        //given
        //User Max1 maxio89@gmail.com : aaaaaa have to be logged in (we want to chat with him).
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop");
        chat.chatButtonClick();
        chat.chatForCreditsButtonClick();
        //then
        assertTrue(chat.isWaitingForPsychicDisplayed());
        //Accepting/Declining invitation by invited user is not implemented yet.
    }

    /**TERMS
     * Validates a click on 'chat' button and functionality popup window.
     * SCENARIO
     * Logged user has entered on a homepage. User clicks on 'chat' button and chooses option 'chat for free'.
     * EXPECTED
     * User will be waiting for confirmation from physic and if physic will agreed 'chat window' will displayed.
     * If physic will not confirmed dialog then popup message will displayed with text " 'physic nickname' declined your chat proposition." */
     @Test
     public void chatForFreeTest(){
         //given
         //User Max1 maxio89@gmail.com : aaaaaa have to be logged in (we want to chat with him).
         browser.manage().deleteAllCookies();
         browser.navigate().to("https://itcrowd.pl/vop/login");
         loginPage.setEmailInput("customertest2@itcrowd.pl");
         loginPage.setPasswordInput("aaaaaa");
         loginPage.submitButtonClick();
         //when
         browser.navigate().to("https://itcrowd.pl/vop");
         chat.chatButtonClick();
         chat.chatForFreeButtonClick();
         //then
         assertTrue(chat.isWaitingForPsychicDisplayed());
         //Accepting/Declining invitation by invited user is not implemented yet.
     }
}
