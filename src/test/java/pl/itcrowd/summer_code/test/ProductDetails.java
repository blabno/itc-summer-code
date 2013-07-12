package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class ProductDetails {
    @FindBy(css = "div.span2 li")
    private List<Thumbnail> thumbnails;

    @FindBy(css = "div.span3 div.span12 .pull-right")
    private WebElement chat;

    @FindBy(css = "div.span3 div.span12 .btn-info")
    private WebElement email;

    @FindBy(css = "div.span10 .well")
    private WebElement description;

    @FindBy(className = "div.span3 div.well div.marginBottom10 .pull-right")
    private WebElement readMore;

    @FindBy(css = "div.span12 btn-link")
    private WebElement physicProfile;

    @FindBy(css ="#returnPolicyModal div button")
    private WebElement policyBoxCloseButton;

    @FindBy(css = "div.span3 .addToCart")
    private WebElement addToCart;

    @FindBy(className = "div.span3 .quantity")
    private WebElement quantity;

    @FindBy(css = "div.rf-ntf-cnt")
    private WebElement popUp;

    @FindBy(css = "div.span3 .paddingTop10")
    private WebElement availableProducts;

    @FindBy(css = "div.span3 div.row-fluid h4")
    private WebElement price;

    @FindBy(css= "div.span3 div.span12 p")
    private WebElement countryOfSeller;

    @FindBy(css= "div.span3 .status")
    private WebElement status;

    @FindBy(css = "div.span3 div.span12 .heading")
    private WebElement name;

    public static class Thumbnail{

        @FindBy(tagName = "img")
        private WebElement image;

        @FindBy(tagName = "a")
        private WebElement thumbnail;

        public String getImgUrl()
        {
            return image.getAttribute("src");
        }

        public String getUrl()
        {
            return thumbnail.getAttribute("href");
        }

        public void clickThumbnail()
        {
            guardHttp(thumbnail).click();
        }
    }

    String getCountryOfSeller(){
        return countryOfSeller.getText();
    }
    public boolean statusOnline()
    {
        String actualStatus = status.getText();

        if(actualStatus.equals("Online"))
            return true;
        else
            return false;
    }
    public String getPrice()
    {
        return price.getText();
    }
    public void readMoreClick()
    {
        guardHttp(readMore).click();
    }
    public void emailClick()
    {
        guardHttp(email).click();
    }
    public void chatClick()
    {
        guardHttp(chat).click();
    }
    public int getThumbnailsSize()
    {
        return thumbnails.size();
    }
    public String getName()
    {
        return name.getText();
    }
    public String getNumberOfavailableProduct(){
        return availableProducts.getText();
    }
    public String getPopUpMessage()
    {
        return popUp.getText();
    }
    public void setInput(String string)
    {
        quantity.clear();
        quantity.clear();
        quantity.sendKeys(string);
    }
    public void addToCartClick()
    {
        guardHttp(addToCart).click();
    }
    public String getDescription()
    {
        return description.getText();
    }

    public void policyBoxCloseButtonClick()
    {
        guardHttp(policyBoxCloseButton).click();
    }

}
