package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardXhr;
import static org.jboss.arquillian.graphene.Graphene.waitAjax;
import static org.jboss.arquillian.graphene.Graphene.waitGui;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class Chat {

    @FindBy(css = "input.btn-success")
    private WebElement chatButton;

    @FindBy(id = "chargingInfoModal")
    private WebElement popupAfterChatClick;

    @FindBy(css = "#chargingInfoModal div.modal-footer form input:nth-of-type(2)")
    private WebElement chatForFreeButton;

    @FindBy(css = "#chargingInfoModal div:nth-of-type(1) button")
    private WebElement exitChatCrossButton;

    @FindBy(css = "#chargingInfoModal div.modal-footer form button:nth-of-type(2)")
    private WebElement chatForCreditsButton;

    @FindBy(css = "#chargingInfoModal div.modal-footer form button:nth-of-type(1)")
    private WebElement noButton;

    @FindBy(id = "pendingModal")
    private WebElement waitingForPsychcDialogBox;

    @FindBy(css = "#pendingModal, div.modal-footer button")
    private WebElement abandonInvitatioButton;

    public void chatButtonClick(){
        chatButton.click();
        waitAjax().until().element(chatForCreditsButton).is().visible();
    }

    public void chatForFreeButtonClick(){
        chatForFreeButton.click();
        waitAjax().until().element(waitingForPsychcDialogBox).is().visible();
    }

    public void exitChatCrossButtonClick(){
        exitChatCrossButton.click();
        waitGui().until().element(exitChatCrossButton).is().not().visible();
    }

    public void chatForCreditsButtonClick(){
        chatForCreditsButton.click();
        waitAjax().until().element(waitingForPsychcDialogBox).is().visible();
    }

    public void noButtonClick(){
        noButton.click();
        waitGui().until().element(noButton).is().not().visible();
    }

    public boolean isPopUpBoxDisplayed(){
        return popupAfterChatClick.isDisplayed();
    }

    public boolean isWaitingForPsychicDisplayed(){
        return waitingForPsychcDialogBox.isDisplayed();
    }

    public void abandonInvitationButtonClick(){
        abandonInvitatioButton.click();
        waitAjax().until().element(waitingForPsychcDialogBox).is().not().visible();
    }
}

