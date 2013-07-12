package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

public class MyAccountMyShop {
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

    public class Order{

        @FindBy(css = "input.btn-small")
        private List<Button> buttons;

        @FindBy(css= "tr:nth-of-type(1)")
        private WebElement contrahent;

        @FindBy(css ="tr:nth-of-type(2)")
        private WebElement status;

        @FindBy(css ="tr:nth-of-type(3)")
        private WebElement value;

        @FindBy(css ="tr:nth-of-type(4)")
        private WebElement date;

        @FindBy(css ="tr:nth-of-type(5)")
        private WebElement item;

        public class Button{
            @FindBy(tagName = "input")
            private WebElement button;

            public void click()
            {
                guardHttp(button).click();
            }
        }
        public void sendMessageClick()
        {
            buttons.get(0).click();
        }
        public void refundClick()
        {
            buttons.get(1).click();
        }


        public void contrahentClick()
        {
            guardHttp(contrahent).click();
        }
        public void contrahentGetText()
        {
            contrahent.getText();
        }
        public void statusClick()
        {
            guardHttp(status).click();
        }
        public void statusGetText()
        {
            status.getText();
        }
        public void valueClick()
        {
            guardHttp(value).click();
        }
        public void valueGetText()
        {
            value.getText();
        }
        public void itemGetText()
        {
            item.getText();
        }
        public void itemClick()
        {
            guardHttp(item).click();
        }

    }
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
            guardHttp(submitted).click();
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



}


