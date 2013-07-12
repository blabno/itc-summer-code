package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class Chat {

    @FindBy(css = "#row_0 div:nth-of-type(1) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div input:nth-of-type(1)")
    private WebElement chatButton;

    @FindBy(id = "chargingInfoModal")
    private WebElement popupAfterChatClick;

    @FindBy(css = "div.modal-footer form input:nth-of-type(2)")
    private WebElement chatForFreeButton;

    @FindBy(css = "#chargingInfoModal div:nth-of-type(1) button")
    private WebElement exitChatCrossButton;

    @FindBy(css = "div.modal-footer form button:nth-of-type(2)")
    private WebElement chatForCreditsButton;

    public void chatButtonClick(){
        guardHttp(chatButton).click();
    }

    public void chatForFreeButtonClick(){
        guardHttp(chatForFreeButton).click();
    }

    public void exitChatCrossButtonClick(){
        guardHttp(exitChatCrossButton).click();
    }

    public void charForCreditsButtonClick(){
        guardHttp(chatForCreditsButton).click();
    }
}

