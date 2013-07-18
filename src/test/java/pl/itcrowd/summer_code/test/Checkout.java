package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

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

    @FindBy(css = "body.cart div.span12 div.form-actions .pull-right")
    private WebElement submitOrderButton;

    @FindBy(css = "div.rf-ntf-cnt")
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

    @FindBy(css = ".alert-error")
    private WebElement alertError;

    @FindBy(tagName = "value")
    private WebElement value;
    //#rf div:nth-of-type(14) input:nth-of-type(1)
    @FindBy(css = ".pull-left")
    private WebElement cancelCheckoutButton;

    @FindBy(css = "html body div:nth-of-type(4) div")
    private WebElement considerProposalPopUp;

    @FindBy(css = "#wrap div:nth-of-type(2) span div:nth-of-type(2) input")
    private WebElement buyMoreCreditsButton;

    @FindBy(css = "#rF\\:cartTable\\:f td span")
    private WebElement totalCost;

    @FindBy(css = "#wrap div:nth-of-type(1) div div div:nth-of-type(1) form ul li:nth-of-type(6) a")
    private WebElement creditsHeld;

    @FindBy(css = "body.cart div:nth-of-type(11) div:nth-of-type(1) input")
    private WebElement checkbox;

    @FindBy(css = "body.cart div:nth-of-type(12) div:nth-of-type(1) input")
    private WebElement suggestedPrice;

    @FindBy(css = "body.cart div:nth-of-type(13) div:nth-of-type(1) textarea")
    private WebElement suggestedMessage;

    @FindBy(className = "rf-dt-fst-r")
    private List<itemForOrder> itemsForOrder;

    public static class itemForOrder{

        @FindBy(css = ":nth-of-type(1)")
        private WebElement product;

        @FindBy(css = ":nth-of-type(2)")
        private WebElement quantity;

        @FindBy(css = ":nth-of-type(3)")
        private WebElement pricePerUnit;

        @FindBy(css = ":nth-of-type(4)")
        private WebElement totalPrice;

        @FindBy(css = ":nth-of-type(5)")
        private WebElement shippingCost;

        @FindBy(css = ":nth-of-type(6)")
        private WebElement priceInclShipping;

        public String getProduct()
        {
            return product.getText();
        }
        public String getQuantity()
        {
            return quantity.getText();
        }
        public String getPricePerUnit()
        {
            return pricePerUnit.getText();
        }
        public String getTotalPrice()
        {
            return totalPrice.getText();
        }
        public String getShippingCost()
        {
            return shippingCost.getText();
        }
        public String getPriceInclShipping()
        {
            return priceInclShipping.getText();
        }
    }
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
        submitOrderButton.click();
    }

    public String getInsufficientCreditsPopUpText(){
       // waitGui().until().element(noMoneyInfo).is().visible();
        return noMoneyInfo.getText();
    }

    public void buyMoreCreditsButtonClick(){
        guardHttp(buyMoreCreditsButton).click();
    }

    public void cancelCheckoutButtonClick(){
        guardHttp(cancelCheckoutButton).click();
    }

    public String getAlertErrorMessage()
    {
        return alertError.getText();
    }
    public String getQuantity(int index)
    {
        return itemsForOrder.get(index).getQuantity();
    }
    public void checkboxClick(){
       // waitGui().until().element(checkbox).is().visible();
        checkbox.click();
        waitGui().until().element(checkbox).is().selected();
    }
    public void setShippingPrice(String newPrice)
    {
        waitGui().until().element(checkbox).is().selected();
        waitGui().until().element(suggestedPrice).is().visible();
        suggestedPrice.sendKeys(newPrice);
    }
    public void setShippingMessage(String message)
    {
        waitGui().until().element(checkbox).is().selected();
        waitGui().until().element(suggestedMessage).is().visible();
        suggestedMessage.sendKeys(message);
    }



}
