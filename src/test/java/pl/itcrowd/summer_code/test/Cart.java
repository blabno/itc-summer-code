package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 09:46
 * To change this template use File | Settings | File Templates.
 */
public class Cart {

    @FindBy(css = "div.span12 tbody:nth-of-type(1)")
    private List<Product> products;

    @FindBy(css = "div input:nth-of-type(3)")
    private WebElement clearCartButton;

    @FindBy(css = "div input:nth-of-type(1)")
    private WebElement backButton;

    @FindBy(css = "div input:nth-of-type(2)")
    private WebElement checkoutButton;

    public Double getTotalCost(){
        Double totalCost = 0.0;
        for(Product p : products){
            totalCost += p.getShippingCost() + p.getTotalPrice();
        }
        return totalCost;
    }

    public void clearCartButtonClick(){
        guardHttp(clearCartButton).click();
    }

    public void backButtonClick(){
        guardHttp(backButton).click();
    }

    public void checkoutButtonClick(){
        guardHttp(checkoutButton).click();
    }

    public Product getProduct(int productId){
        return products.get(productId);
    }

    public static class Product {

        @FindBy(tagName = "a")
        private WebElement product;

        @FindBy(tagName = "input")
        private WebElement removeButton;

        @FindBy(css = "td:nth-of-type(1)")
        private WebElement name;

        @FindBy(css = "td:nth-of-type(2)")
        private WebElement quantity;

        @FindBy(css = "td:nth-of-type(3)")
        private WebElement pricePerUnit;

        @FindBy(css = "td:nth-of-type(4)")
        private WebElement totalPrice;

        @FindBy(css = "td:nth-of-type(5)")
        private WebElement shippingCost;

        public String getName(){
            return name.getText();
        }
        public Integer getQuantity(){
            return Integer.parseInt(quantity.getText());
        }

        public Double getPricePerUnit(){
            return Double.parseDouble(pricePerUnit.getText());
        }

        public Double getTotalPrice(){
            return Double.parseDouble(totalPrice.getText());
        }

        public Double getShippingCost(){
            return Double.parseDouble(shippingCost.getText());
        }

        public Integer getId()
        {
            String productId = product.getAttribute("href").replaceAll("[https://itcrowd.pl/vop/product/]", "");
            return Integer.parseInt(productId);
        }

        public String getUrl()
        {
            return product.getAttribute("href");
        }

        public void clickProduct()
        {
            guardHttp(product).click();
        }

        public void clickRemove(){
            guardHttp(removeButton).click();
        }
    }
}
