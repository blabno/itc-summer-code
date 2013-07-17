package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.context.GrapheneContext;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.waitGui;

public class MyAccountMyShop {
    @FindBy(css = "div.span3 li.active")
    private WebElement ordersButton;
    @FindBy(css = "body div.span9 .rf-dt-r")
    private List<Order> orders;

    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(2)")
    private WebElement waitingForSellerApproval;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(3)")
    private WebElement approvedBySeller;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(4)")
    private WebElement submitted;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(5)")
    private WebElement inRealization;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(6)")
    private WebElement shipped;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(7)")
    private WebElement realized;
    @FindBy(css = "body.my-account form select:nth-of-type(1) option:nth-of-type(8)")
    private WebElement refunded;

    //Order details
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(1) div.controls span.input")
    private WebElement orderId;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(2) div.controls span.input")
    private WebElement orderStatus;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(3) div.controls span.input")
    private WebElement buyerFirstName;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(4) div.controls span.input")
    private WebElement buyerLastName;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(11) div.controls span.input")
    private WebElement sellerFirstName;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(12) div.controls span.input")
    private WebElement sellerLastName;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(19) div.controls span.input")
    private WebElement orderPrice;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(20) div.controls span.input")
    private WebElement orderShipping;
    @FindBy(css = "div.rf-p-b form.form-horizontal div:nth-of-type(21) div.controls span.input")
    private WebElement orderTotalPrice;
    @FindBy(css = "tbody.rf-dt-b tr:nth-of-type(1) td:nth-of-type(1) a")
    private List<WebElement> orderedItems;
    @FindBy(css = "div.form-actions input")
    private WebElement backButton;


    public Order getOrder(int index)
    {
        return orders.get(index);
    }
    //Select input
    public void waitingForSellerApprovalClick()
    {
        guardHttp(waitingForSellerApproval).click();
    }
    public void approvedBySellerClick()
    {
        guardHttp(approvedBySeller).click();
    }
    public void submittedClick()
    {
        submitted.click();
    }
    public void inRealizationClick()
    {
        guardHttp(inRealization).click();
    }
    public void shippedClick()
    {
        guardHttp(shipped).click();
    }
    public void realizedClick()
    {
        guardHttp(realized).click();
    }
    public void refundedClick()
    {
        guardHttp(refunded).click();
    }
    public int getOrderedProductId(int index)
    {
        return Integer.parseInt(orderedItems.get(index).getAttribute("href").replaceAll("/vop/product/", ""));
    }
    public String getOrderedProductName(int index)
    {
        return orderedItems.get(index).getText();
    }

    public void ordersButtonClick()
    {
        ordersButton.click();
    }

    public boolean mouseOverItemName(int index)
    {
        new Actions(GrapheneContext.getProxy()).moveToElement(orders.get(index).item).build().perform();
        waitGui().until().element(orders.get(index).itemThumbnail).is().visible();
        return orders.get(index).itemThumbnail.isDisplayed();
    }

    //Order details
    public String getOrderId()
{
        return orderId.getText();
    }
    public String getOrderStatus()
    {
        return orderStatus.getText();
    }
    public String getBuyerFirstName()
    {
        return buyerFirstName.getText();
    }
    public String getBuyerLastName()
    {
        return buyerLastName.getText();
    }
    public String getSellerFirstName()
    {
        return sellerFirstName.getText();
    }
    public String getSellerLastName()
    {
        return sellerLastName.getText();
    }
    public String getOrderPrice()
    {
        return orderPrice.getText();
    }
    public String getOrderShipping()
    {
        return orderShipping.getText();
    }
    public String getOrderTotalPrice()
    {
        return orderTotalPrice.getText();
    }
    public void backButtonClick()
    {
        waitGui().until().element(backButton).is().visible();
        backButton.click();
    }
    public void orderNameClick(int index)
    {
        orderedItems.get(index).click();
    }

    public class Order{
        @FindBy(css= "td:nth-of-type(1) a")
        private WebElement contrahent;
        @FindBy(css ="td:nth-of-type(2) a")
        private WebElement status;
        @FindBy(css ="td:nth-of-type(3) a")
        private WebElement value;
        @FindBy(css ="td:nth-of-type(4) a")
        private WebElement date;
        @FindBy(css ="td:nth-of-type(5) a")
        private WebElement item;
        @FindBy(css ="td:nth-of-type(5) div.row-fluid div.span12 ol li img")
        private WebElement itemThumbnail;
        @FindBy(css = "td:nth-of-type(6) div.orderButtons input")
        private WebElement sendMessageButton;


        public void contrahentClick()
        {
            contrahent.click();
        }
        public String getContrahent()
        {
            return contrahent.getText();
        }
        public void statusClick()
        {
            status.click();
        }
        public String getStatus()
        {
            return status.getText();
        }
        public void valueClick()
        {
            value.click();
        }
        public String getValue()
        {
            return value.getText();
        }
        public void dateClick()
        {
            date.click();
        }
        public String getDate()
        {
            return date.getText();
        }
        public String getItemName()
        {
            return item.getText();
        }
        public void itemClick()
        {
            guardHttp(item).click();
        }
        public void sendMessageButtonClick()
        {
            sendMessageButton.click();
        }
    }
}


