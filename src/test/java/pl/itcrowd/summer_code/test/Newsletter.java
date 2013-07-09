package pl.itcrowd.summer_code.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class Newsletter {

    @FindBy(css = "[id='wrap'] div.container div.span3 div.row-fluid > input")  //"btn btn-info pull-right
    private WebElement newsletterInput;

    @FindBy(css = "[id='wrap'] div.container div.span3 div.row-fluid [type='submit']")
    private WebElement newsletterSubmit;

    @FindBy(css = "div.rf-ntf-cnt")
    private WebElement popUp;

    public WebElement getInput()
    {
        return newsletterInput;
    }

    public void setInput(String string)
    {
        newsletterInput.clear(); //.clear() don't clear input
        newsletterInput.clear();
        newsletterInput.sendKeys(string);
    }

    public WebElement getPopUp()
    {
        return popUp;
    }

    public String getPopUpText()
    {
        return popUp.getText();
    }

    public WebElement getSubmit()
    {
        return newsletterSubmit;
    }

    public void clickSignUp()
    {
        guardHttp(newsletterSubmit).click();
    }

    public boolean isPopUpVisible()
    {
        return popUp.isDisplayed();
    }

    public void popUpClick()
    {
        popUp.click();
    }

    public static class PsychicMarketplace {

        @FindBy(tagName = "li")
        private List<Product> products;

        public int getProductId(int productNumber)
        {
            return products.get(productNumber).getId();
        }

        public String getProductImgUrl(int productNumer)
        {
            return products.get(productNumer).getImgUrl();
        }

        public String getProductUrl(int productNumber)
        {
            return products.get(productNumber).getUrl();
        }

        public void clickProduct(int productNumber)
        {
            products.get(productNumber).clickProduct();
        }

        public static class Product {

            @FindBy(tagName = "img")
            private WebElement image;

            @FindBy(tagName = "a")
            private WebElement product;

            public Integer getId()
            {
                String productId = product.getAttribute("href").replaceAll("[https://itcrowd.pl/vop/product/]", "");
                return Integer.parseInt(productId);
            }

            public String getImgUrl()
            {
                return image.getAttribute("src");
            }

            public String getUrl()
            {
                return product.getAttribute("href");
            }

            public void clickProduct()
            {
                guardHttp(product).click();
            }
        }
    }
}
