package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(Arquillian.class)
public class MyAccountMyShopTest {

    @Drone
    WebDriver browser;

    @Page
    LoginPage loginPage;

    @Page
    MyAccountMyShop myShop;

    String myShopUrl = "https://itcrowd.pl/vop/private/orderList";

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if thumbnail is displayed when user set cursor on the item name on orders list.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Put cursor on the item name in 2. row of orders table.
     * <p/>
     * EXPECTED
     * Check if thumbnail is displayed.
     */
    @Test
    public void hoverItemNameTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        //then
        assertTrue(myShop.mouseOverItemName(1));
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click ordered item name.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Item name" link in 2. row of orders table.
     * <p/>
     * EXPECTED
     * Check if current url points to "Product details" page (https://itcrowd.pl/vop/product/2).
     */
    @Test
    public void itemNameCLickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).itemClick();
        //then
        assertEquals("https://itcrowd.pl/vop/product/2", browser.getCurrentUrl());
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Back" button on Order details page.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 2. row of order table.
     * 3.Click "Back" button.
     * <p/>
     * EXPECTED
     * Check if current url points to "My Shop" page (https://itcrowd.pl/vop/private/orderList).
     */
    @Test
    public void orderDetailsBackButtonClickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).contrahentClick();
        myShop.backButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/private/orderList", browser.getCurrentUrl());
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue candle" order.
     * Test check if user can click on order details: Contrahent, Status, Value and Date.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Seller: Peter Parker" link in 2. row of orders table.
     * 3.Save current url.
     * 4.Navigate to My Shp page
     * 5.Click on "Submitted" link in 2. row of orders table.
     * 6.Save current url.
     * 7.Navigate to My Shop page.
     * 8.Click on "14.99" link in 2. row of orders table.
     * 9.Save current url.
     * 10.Navigate to My Shop page.
     * 11.Click on "10-07-2013" link in 2. row of orders table.
     * 12.Save current url.
     * <p/>
     * EXPECTED
     * Check if all saved urls points to "Order details" page (https://itcrowd.pl/vop/private/orderDetails?orderId=20).
     */
    @Test
    public void orderDetailsClickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        String[] urls = new String[4];
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).contrahentClick();
        urls[0] = browser.getCurrentUrl();

        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).statusClick();
        urls[1] = browser.getCurrentUrl();

        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).valueClick();
        urls[2] = browser.getCurrentUrl();

        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).dateClick();
        urls[3] = browser.getCurrentUrl();
        //then
        assertEquals("https://itcrowd.pl/vop/private/orderDetails?orderId=20", urls[0]);
        assertEquals("https://itcrowd.pl/vop/private/orderDetails?orderId=20", urls[1]);
        assertEquals("https://itcrowd.pl/vop/private/orderDetails?orderId=20", urls[2]);
        assertEquals("https://itcrowd.pl/vop/private/orderDetails?orderId=20", urls[3]);
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Name" link in Order items table on Order details page.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 1. row of order table.
     * 3.Click "Blue Candle" link in 1. row of Ordered items table.
     * <p/>
     * EXPECTED
     * Check if current url points to "Product details" page (https://itcrowd.pl/vop/product/2).
     */
    @Test
    public void orderDetailsProductNameClickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).contrahentClick();
        myShop.orderNameClick(0);
        //then
        assertEquals("https://itcrowd.pl/vop/product/2", browser.getCurrentUrl());
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if order details are displayed.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 2. row of orders table.
     * <p/>
     * EXPECTED
     * Check if:
     * 1.Order Id and Status are correct.
     * 2.Buyer and sellers last names are correct
     * 3.Ordered items Name and total price are are correct.
     * 4.Order summary (Price, Incl. shipping, Total) are correct
     */
    @Test
    public void orderDetailsTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).contrahentClick();
        //then
        assertEquals("20", myShop.getOrderId());
        assertEquals("Submitted", myShop.getOrderStatus());
        assertEquals("Account", myShop.getBuyerLastName());
        assertEquals("Parker", myShop.getSellerLastName());
        assertEquals("Blue candle", myShop.getOrderedProductName(0));
        assertEquals("9.99", myShop.getOrderPrice());
        assertEquals("5.00", myShop.getOrderShipping());
        assertEquals("14.99", myShop.getOrderTotalPrice());
    }

    /**
     * TERMS
     * Test check if user can click "Orders" link.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Orders" link.
     * <p/>
     * EXPECTED
     * Check if you are redirected to (it is still the same page) https://itcrowd.pl/vop/private/orderList
     */
    @Test
    public void orderLinkClickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.ordersButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/private/orderList", browser.getCurrentUrl());
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted order from seller Voice Psychic.
     * Test check if order is displayed and if status is correct.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Submitted" option in select input.
     * 3.Get list of orders
     * <p/>
     * EXPECTED
     * 1.Check if Order from seller "Voice Psychic" is Displayed on 3. position.
     * 2.Check if Status is "Submitted".
     */
    @Test
    public void ordersAreDisplayedTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.submittedClick();
        //then
        assertEquals("Seller: Voice Psychic", myShop.getOrder(2).getContrahent());
        assertEquals("Submitted", myShop.getOrder(2).getStatus());
    }

    /**
     * TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Send Message" button.
     * <p/>
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Send Message" button in 2. row of orders table.
     * <p/>
     * EXPECTED
     * Check if current url points to "Create Message" page (https://itcrowd.pl/vop/private/createMessage?userId=2).
     */
    @Test
    public void sendMessageClickTest()
    {
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to(myShopUrl);
        myShop.getOrder(1).sendMessageButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/private/createMessage?userId=2", browser.getCurrentUrl());
    }
}
