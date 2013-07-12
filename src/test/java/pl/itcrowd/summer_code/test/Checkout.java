package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.waitGui;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public class Checkout {

    @FindBy(css = "#rF div:nth-of-type(14) input:nth-of-type(1)")
    private WebElement submitOrderButton;

    @FindBy(css = ".rf-ntf-sum")
    private WebElement noMoneyInfo;

    @FindBy(id = "rF:firstName:i")
    private WebElement personalFirstName;

    @FindBy(id = "rF:lastName:i")
    private WebElement personalLastName;

    @FindBy(id = "newAddress")
    private WebElement personalNewAddressChecked;

    @FindBy(id = "rF:telephone:i")
    private WebElement personalTelephone;

    @FindBy(id = "rF:addr1:i")
    private WebElement personalAddressLine1;

    @FindBy(id = "rF:addr2:i")
    private WebElement personalAddressLine2;

    @FindBy(id = "rF:city:i")
    private WebElement personalCity;

    @FindBy(id = "rF:zipcode:i")
    private WebElement personalZipCode;

    @FindBy(css = "#rf\\:country\\:i option:nth-of-type(12)")
    private WebElement personalCountry;

    @FindBy(css = "#rf\\:region\\:i option:nth-of-type(15)")
    private WebElement personalRegion;

    @FindBy(tagName = "value")
    private WebElement value;

    @FindBy(css = "#rf div:nth-of-type(14) input:nth-of-type(1)")
    private WebElement cancelCheckoutButton;

    @FindBy(css = "html body div:nth-of-type(4) div")
    private WebElement considerProposalPopUp;

    @FindBy(css = "#wrap div:nth-of-type(2) span div:nth-of-type(2) input")
    private WebElement buyMoreCreditsButton;

    @FindBy(css = "#rF\\:cartTable\\:f td span")
    private WebElement totalCost;

    @FindBy(css = "#wrap div:nth-of-type(1) div div div:nth-of-type(1) form ul li:nth-of-type(6) a")
    private WebElement creditsHeld;

    public String getFirstName(){
        return personalFirstName.getText();
    }

    public String getLastName(){
        return personalLastName.getText();
    }

    public String getTelephone(){
        return personalTelephone.getText();
    }

    public String getAddressLine1(){
        return personalAddressLine1.getText();
    }

    public String getAddressLine2(){
        return personalAddressLine2.getText();
    }

    public String getCity(){
        return personalCity.getText();
    }

    public String getZipCode(){
        return personalZipCode.getText();
    }

    public String getCountry(){
        return personalCountry.getText();
    }

    public String getRegion(){
        return personalRegion.getText();
    }

    public String getMissingQuantityOfCredits(){
        Double creditsNeeded = getTotalCost();
        Double creditsHeld = getCreditsHeld();
        Double creditsMissing = creditsNeeded - creditsHeld;
        return creditsMissing.toString();
    }

    public String getValue(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public String getBuyCreditsUrlPlusAmount(String url){
        String amount = getMissingQuantityOfCredits();
        return url+amount;
    }

    public Double getCreditsHeld(){
        String customerBalanceText = creditsHeld.getText();
        Double customerBalance = Double.parseDouble(customerBalanceText.substring(14));
        return customerBalance;
    }

    public Double getTotalCost(){
        String costText = totalCost.getText();
        return  Double.parseDouble(costText.substring(7));
    }

    public String getConsiderProposalPopUpText(){
        return considerProposalPopUp.getText();
    }

    public void submitOrderButtonClick(){
        guardHttp(submitOrderButton).click();
    }

    public String getInsufficientCreditsPopUpText(){
        new Actions(GrapheneContext.getProxy()).moveToElement(noMoneyInfo).build().perform();
        waitGui().until().element(noMoneyInfo).is().visible();
        return noMoneyInfo.getText();
    }

    public void buyMoreCreditsButtonTest(){
        guardHttp(buyMoreCreditsButton).click();
    }

    public void cancelCheckoutButtonClick(){
        guardHttp(cancelCheckoutButton).click();
    }
}
