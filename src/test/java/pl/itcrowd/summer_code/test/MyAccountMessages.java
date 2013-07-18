package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardXhr;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import static org.jboss.arquillian.graphene.Graphene.waitModel;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 10.07.13
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class MyAccountMessages {

    @FindBy(css = ".rf-fu-btn-cnt-add")
    private WebElement Add;

    @FindBy(css = "body.create-message div.form-actions input:nth-of-type(1)")
    private WebElement cancel;

    @FindBy(css = "[id$=':msgContent']")
    private WebElement content;

    @FindBy(id = "form:content:message1")
    private WebElement contentErrorMessage;

    @FindBy(css = " body.message-list ul.nav-list li:nth-of-type(3) a")
    private WebElement emailButton;

    @FindBy(css = "div.span9 .rf-dt-r")
    private List<Message> messages;

    @FindBy(css = "body.message-list ul.nav.nav-list li:nth-of-type(2) a")
    private WebElement newButton;

    @FindBy(css = "div.rf-ntf-cnt")
    private WebElement popUp;

    @FindBy(css = "div.rf-pp-cnt")
    private WebElement popUpAfterCancel;

    @FindBy(css = "div.rf-pp-cnt form:nth-of-type(1) input:nth-of-type(2)")
    private WebElement popUpCancel;

    @FindBy(css = "div.rf-pp-cnt form:nth-of-type(1) input:nth-of-type(4)")
    private WebElement popUpNo;

    @FindBy(css = "div.rf-pp-cnt form:nth-of-type(1) input:nth-of-type(3)")
    private WebElement popUpYes;

    @FindBy(css = "body.create-message form select:nth-of-type(1) option:nth-of-type(2)")
    private WebElement recipient1;

    @FindBy(css = "body.create-message form select:nth-of-type(1) option:nth-of-type(3)")
    private WebElement recipient2;

    @FindBy(css = "body.create-message form select:nth-of-type(1) option:nth-of-type(4)")
    private WebElement recipient3;

    @FindBy(id = "form:recipient:message1")
    private WebElement recipientErrorMessage;

    @FindBy(css = "div.span12 div.span9 .pull-right")
    private WebElement remove;

    @FindBy(css = "body.create-message div.form-actions input:nth-of-type(2)")
    private WebElement sendMessage;

    @FindBy(css = "[id$=':msgSubject']")
    private WebElement subject;

    @FindBy(id = "form:subject:message1")
    private WebElement subjectErrorMessage;

    @FindBy(css = ".uploaded")
    private List<Uploaded> thumbnails;

    public String getEmptyContentMessage()
    {
        return contentErrorMessage.getText();
    }
    public WebElement getPopUpAfterCancel()
    {
        return popUpAfterCancel;
    }
    public WebElement getRecipient1()
    {
        return recipient1;
    }

    public String getEmptyRecipientMessage()
    {
        return recipientErrorMessage.getText();
    }

    public String getEmptySubjectMessage()
    {
        return subjectErrorMessage.getText();
    }

    public String getPopUpAfterCancelMessage()
    {
        return popUpAfterCancel.getText();
    }

    public String getPopUpMessage()
    {
        waitGui().until().element(popUp).is().visible();
        return popUp.getText();
    }

    public int getSizeOfMessages()
    {
        return messages.size();

    }

    public void setContent(String string)
    {
        content.clear();
        content.clear();
        content.sendKeys(string);
    }

    public void setSubject(String string)
    {
        subject.clear();
        subject.clear();
        subject.sendKeys(string);
    }

    public void cancelClick()
    {
        cancel.click();
    }

    public void checkboxClick(int index)
    {
        messages.get(index).checkboxClick();

    }

    public void emailClick()
    {
        guardHttp(emailButton).click();
    }

    public boolean isPopUpAfterCancelDisplayed()
    {
        try {
            return popUpAfterCancel.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isUploadedDisplayed()
    {
        return thumbnails.get(1).isDisplayed();
    }

    public void newClick()
    {
        guardHttp(newButton).click();
    }

    public void popUpCancelClick()
    {
        guardXhr(popUpCancel).click();
    }

    public void popUpNoClick()
    {
        waitGui().until().element(popUpAfterCancel).is().visible();
        guardHttp(popUpNo).click();
    }

    public void popUpYesClick()
    {
        waitGui().until().element(popUpAfterCancel).is().visible();
        guardHttp(popUpYes).click();
    }

    public void readClick(int index)
    {
        messages.get(index).readClick();
    }

    public void recipient1Click()
    {
        guardXhr(recipient1).click();
    }

    public void recipient2Click()
    {
        recipient2.click();
        waitGui().until().element(recipient2).is().selected();
    }

    public void recipient3Click()
    {
        recipient3.click();
        waitGui().until().element(recipient3).is().selected();
    }

    public void removeClick()
    {
        guardXhr(remove).click();
    }

    public void sendMessageClick()
    {
        waitGui().until().element(sendMessage).is().visible();
        sendMessage.click();
    }

    public static class Message {

        @FindBy(css = "input.selectMsg")
        private WebElement chceckbox;

        @FindBy(css = ".btn-info")
        private WebElement read;

        public void checkboxClick()
        {
            chceckbox.click();

        }

        public void readClick()
        {
            read.click();
        }
    }

    public static class Uploaded {

        @FindBy(tagName = "img")
        private WebElement image;

        public String getImgUrl()
        {
            return image.getAttribute("src");
        }

        public void imageClick()
        {
            guardHttp(image).click();
        }

        public boolean isDisplayed()
        {
            return image.isDisplayed();
        }
    }
    public void triggerFormChangeEvent()
    {
        final JavascriptExecutor proxy = (JavascriptExecutor) GrapheneContext.getProxy();
         proxy.executeScript("jQuery(document.getElementById(arguments[0])).trigger(RichFaces.ui.FormChangeListener.formchangedEvent);",
        subject.getAttribute("id"));
        waitModel().until().element(sendMessage).attribute("disabled").is().not().present();
    }

}
