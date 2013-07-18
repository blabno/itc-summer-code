package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 10.07.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class MyAccountMessagesTest {

    @Drone
    WebDriver driver;

    @Page
    MyAccountMessages accountMessages;

    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests(){
    }

    /**
     * TERMS
     * Checks if you'll be forwarded to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * page, where you can write messages.
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private?p=MAILBOX"
     * 2. Click on the "New" button
     * 3. Do assert
     *
     * EXPECTATIONS
     * You'll be forwarded to the page, which allows you to create message to psychics
     */
    @Test
    public void newMessageButtonTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private?p=MAILBOX");
        accountMessages.newClick();
        //then
        assertTrue(driver.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private/createMessage?userId"));
    }

    /**
     * TERMS
     * Checks if you'll be forwarded to "https://itcrowd.pl/vop/private?p=MAILBOX"
     * this is page, where you can e.g. read message, that you've sent
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to: "https://itcrowd.pl/vop/private?p=MAILBOX"
     * 2. Click on "Mailbox" button
     * 3. Do assert
     *
     * EXPECTATIONS
     * You'll be forwarded to the page, which allows you to read messages
     */
    @Test
    public void mailboxButtonTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private?p=MAILBOX");
        accountMessages.emailClick();
        //then
        assertTrue(driver.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private?p=MAILBOX"));
    }

    /**
     * TERMS
     * Checks if all needed fields are filled
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Leave one of needed fields empty
     * 3. Do assertions
     *
     * EXPECTATIONS
     * When you leave one of needed fields empty, it should be signalized
     */
    @Test
    public void emailNewRequiredFieldsTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.setSubject("test");
        accountMessages.sendMessageClick();
        String errorMessage = accountMessages.getEmptyRecipientMessage();
        //then
        assertEquals("value is required",accountMessages.getEmptyRecipientMessage());
    }

    /**
     * TERMS
     * Checks, what happens when you try to remove message, when there is no messages or message is unchecked
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private?p=MAILBOX"
     * 2. Don't check any message
     * 3. Click remove
     * 4. Do assert
     *
     * EXPECTATIONS
     * If none message will be checked, there should be pop-up with "Select some items!" message
     */
    @Test
    public void mailboxRemoveWhenEmptyTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private?p=MAILBOX");
        accountMessages.removeClick();
        //then
        assertEquals("Select some items!",accountMessages.getPopUpMessage());

    }

    /**
     * TERMS
     * Checks if message will be successfully sent, if inputs are correctly filled
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Choose psychic, e.g psychic7
     * 3. Fill topic
     * 4. Fill content
     * 5. Click on "Send message" button
     * 6. Do assert
     *
     * EXPECTATIONS
     * If email is correctly sent, there should be a pop-up with message: "Message sent"
     */
    @Test
    public void sendMessageToPsychicTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.triggerFormChangeEvent();
        accountMessages.recipient1Click();
        accountMessages.setSubject("kkkk");
        accountMessages.setContent("test");
        accountMessages.sendMessageClick();
        //then
        assertEquals("Message sent",accountMessages.getPopUpMessage());

    }

    /**
     * TERMS
     * Checks, if after "Read" button click, there will be message displayed.
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private?p=MAILBOX"
     * 2. Check message, that you want to read.
     * 3. Click "Read" button
     * 4. Do assert
     *
     * EXPECTATIONS
     * After click you'll be forwarded to "https://itcrowd.pl/vop/private/showMessage?threadId=81"
     */
    @Test
    public void readSentMessageTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private?p=MAILBOX");
        accountMessages.checkboxClick(0);
        accountMessages.readClick(0);
        //then
        assertTrue(driver.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private/showMessage?threadId"));
    }

    /**
     * TERMS
     * Checks, if deletions of messages work properly
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private?p=MAILBOX"
     * 2. Check message, you want to delete
     * 3. Click "Remove" button
     * 4. Do assert
     *
     * EXPECTATIONS
     * Message is deleted.
     */
    @Test
    public void deleteMessageTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private?p=MAILBOX");
        int sizeOfMessages = accountMessages.getSizeOfMessages();
        accountMessages.checkboxClick(0);
        accountMessages.removeClick();
        //then
        assertTrue(sizeOfMessages != accountMessages.getSizeOfMessages());

    }

    /**
     * TERMS
     * Checks, if pop-up "Would you like to save changes.." will be displayed after click "Cancel"
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Choose psychic, you want to send message to.
     * 3. Click "Cancel" button
     * 4. Do assert
     *
     * EXPECTATIONS
     * After "Cancel" click, pop-up ought to be displayed
     */
    @Test
    public void cancelWritingMessageTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.recipient1Click();
        accountMessages.cancelClick();
        boolean result = accountMessages.isPopUpAfterCancelDisplayed();
        //then
        assertFalse(result);
    }

    /**
     * TERMS
     * Checks, if attachment will be added correctly
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Click "Add" button
     * 3. Choose some jpeg to upload
     * 4. Press ok in window
     * 5. Do assert
     *
     * EXPECTATIONS
     * Picture should be added, it should be visible as miniature.
     */
    @Test
    public void addAttachmentTest(){
        //Test should be done manually

    }

    /**
     * TERMS
     * Checks, if attachment is in supported format (jpeg, bmp, png or gif)
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Click "Add" button
     * 3. Choose some file, but no picture
     * 4. Press ok in window
     * 5. Do assert
     *
     * EXPECTATIONS
     * Some alert should appear. It should says that chosen format is not supported,
     * it means, that you cannot add anything, except a few picture formats.
     */
    @Test
    public void attachmentWrongFormatTest(){
        //Test should be done manually
    }

    /**
     * TERMS
     * Checks, if pop-up's "Would you like to save changes.." option "Cancel" work properly
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Choose psychic, you want to send message to.
     * 3. Click "Cancel" button
     * 4. On the pop-up click "cancel"
     * 4. Do assert
     *
     * EXPECTATIONS
     * After "cancel" click, pop-up ought to quit, message should not has been saved
     * Click shouldn't redirect anywhere, it should return to last focused page
     */
    @Test
    public void saveChangesPopUp_Cancel_Test(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        //when
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.triggerFormChangeEvent();
        accountMessages.recipient1Click();
        accountMessages.cancelClick();
        accountMessages.popUpCancelClick();
        String currentUrl = driver.getCurrentUrl();
        //then
        assertFalse(accountMessages.isPopUpAfterCancelDisplayed());
        assertTrue(currentUrl.startsWith("https://itcrowd.pl/vop/private/createMessage"));
    }

    /**
     * TERMS
     * Checks, if pop-up's "Would you like to save changes.." option "No" work properly
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Choose psychic, you want to send message to.
     * 3. Click "Cancel" button
     * 4. On the pop-up click "no"
     * 4. Do assert
     *
     * EXPECTATIONS
     * After "no" click, pop-up ought to quit, message should not has been saved
     * Link should redirect to :"https://itcrowd.pl/vop/private?p=MAILBOX"
     */
    @Test
    public void saveChangesPopUp_No_Test(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        //when
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.triggerFormChangeEvent();
        accountMessages.recipient1Click();
        accountMessages.cancelClick();
        accountMessages.popUpNoClick();
        //then
        assertFalse(accountMessages.isPopUpAfterCancelDisplayed());
        assertEquals("https://itcrowd.pl/vop/private?p=MAILBOX", driver.getCurrentUrl());

    }

    /**
     * TERMS
     * Checks, if pop-up's "Would you like to save changes.." option "yes" work properly
     *
     * SCENARIO
     * 1. While logged in as customertest2@itcrowd.pl, go to "https://itcrowd.pl/vop/private/createMessage?userId=70"
     * 2. Choose psychic, you want to send message to.
     * 3. Click "Cancel" button
     * 4. On the pop-up click "Yes"
     * 4. Do assert
     *
     * EXPECTATIONS
     * After "yes" click, pop-up ought to quit, message should has been saved
     * Link should redirect to :"https://itcrowd.pl/vop/private?p=MAILBOX"
     */
    @Test
    public void saveChangesPopUp_Yes_Test(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        //when
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/private/createMessage?userId=69");
        accountMessages.triggerFormChangeEvent();
        accountMessages.recipient1Click();
        accountMessages.cancelClick();
        accountMessages.popUpYesClick();
        //then
        assertFalse(accountMessages.isPopUpAfterCancelDisplayed());
        assertEquals("https://itcrowd.pl/vop/private/createMessage", driver.getCurrentUrl());
    }
}
