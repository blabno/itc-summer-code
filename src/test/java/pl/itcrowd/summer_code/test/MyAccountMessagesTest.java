package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 10.07.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class MyAccountMessagesTest {

    @Drone
    WebDriver browser;

    @Before
    public void beforeTests(){
        //You must be logged in
        //Use e.g. this passes:
        //email: customertest2@itcrowd.pl
        //password: aaaaaa
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
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
        Assert.fail("Not implemented yet");
    }
}
