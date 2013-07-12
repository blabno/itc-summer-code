package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyAccountMyShopTest {

    /**TERMS
     * Test check if user can click "Orders" link.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Orders" link.
     *
     * EXPECTED
     * Check if you are redirected to (it is still the same page) https://itcrowd.pl/vop/private/orderList
     */
    @ Test
    public void orderLinkClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted order from seller Voice Psychic.
     * Test check if order is displayed and if status is correct.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Submitted" option in select input.
     * 3.Get list of orders
     *
     * EXPECTED
     * 1.Check if Order from seller "Voice Psychic" is Displayed on 2. position.
     * 2.Check if Status is "Submitted".
     */
    @ Test
    public void ordersAreDisplayedTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted order. Test check if user can click "Subbmitted" option in select input.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Submitted" option in select input.
     *
     * EXPECTED
     * Check if Orders from seller Peter Parker are Displayed.
     */
    @ Test
    public void selectInputTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue candle" order.
     * Test check if user can click on order details: Contrahent, Status, Value and Date.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Seller: Peter Parker" link in 1. row of orders table.
     * 3.Save current url.
     * 4.Navigate to My Shp page
     * 5.Click on "Submitted" link in 1. row of orders table.
     * 6.Save current url.
     * 7.Navigate to My Shop page.
     * 8.Click on "14.99" link in 1. row of orders table.
     * 9.Save current url.
     * 10.Navigate to My Shop page.
     * 11.Click on "10-07-2013" link in 1. row of orders table.
     * 12.Save current url.
     *
     * EXPECTED
     * Check if all saved urls points to "Order details" page (https://itcrowd.pl/vop/private/orderDetails?orderId=20).
     */
    @ Test
    public void orderDetailsClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if thumbnail is displayed when user set cursor on the item name on orders list.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Put cursor on the item name in 1. row of orders table.
     *
     * EXPECTED
     * Check if thumbnail is displayed.
     */
    @ Test
    public void hoverItemNameTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click ordered item name.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Item name" link in 1. row of orders table.
     *
     * EXPECTED
     * Check if current url points to "Product details" page (https://itcrowd.pl/vop/product/2).
     */
    @ Test
    public void itemNameCLickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Send Message" button.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Send Message" button in 1. row of orders table.
     *
     * EXPECTED
     * Check if current url points to "Create Message" page (https://itcrowd.pl/vop/private/createMessage?userId=2).
     */
    @ Test
    public void sendMessageClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if order details are displayed.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 1. row of orders table.
     *
     * EXPECTED
     * Check if:
     * 1.Order Id and Status are correct.
     * 2.Buyer and sellers last names are correct
     * 3.Ordered items Name and total price are are correct.
     * 4.Order summary (Price, Incl. shipping, Total) are correct
     */
    @ Test
    public void orderDetailsTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Back" button on Order details page.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 1. row of order table.
     * 3.Click "Back" button.
     *
     * EXPECTED
     * Check if current url points to "My Shop" page (https://itcrowd.pl/vop/private/orderList).
     */
    @ Test
    public void orderDetailsBackButtonClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User testacc@itcrowd.pl:testacc have Submitted "Blue Candle" order.
     * Test check if user can click "Name" link in Order items table on Order details page.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click "Seller: Peter Parker" link in 1. row of order table.
     * 3.Click "Blue Candle" link in 1. row of Ordered items table.
     *
     * EXPECTED
     * Check if current url points to "Product details" page (https://itcrowd.pl/vop/product/2).
     */
    @ Test
    public void orderDetailsProductNameClickTest(){
        Assert.fail("Not implemented yet.");
    }
}
