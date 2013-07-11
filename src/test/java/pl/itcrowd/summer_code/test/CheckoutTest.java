package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class CheckoutTest {


    /**TERMS
     * User have product/s i cart want to order items but he didn't set personal details
     *
     * SCENARIO
     * 1.Open the checkout page (https://itcrowd.pl/vop/private/checkout).
     *
     * EXPECTED
     * Check if you are redirected to https://itcrowd.pl/vop/private/userProfileDetails page.
     */
    @ Test
    public void noPersonalDetailsTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User want to order product/s which he has in cart but he don't have credits. Test check if proper Information is displayed.
     *
     * SCENARIO
     * 1.Open the checkout page.
     *
     * EXPECTED
     * Check if Information "You have insufficient funds to pay for this order." is displayed.
     */
    @ Test
    public void noMoneyInfoTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User want to order product/s which he has in cart but he don't have credits. Test check if proper personal details are displayed.
     *
     * SCENARIO
     * 1.Open the checkout page.
     *
     * EXPECTED
     * Check if personal details are displayed.
     */
    @ Test
    public void noMoneyPersonalDetailsTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User want to order product/s which he has in cart but he don't have credits. User can click on Buy more credits button.
     *
     * SCENARIO
     * 1.Open the checkout page.
     * 2.Get Total price for all products in cart
     * 2.Click on Buy Credits button
     *
     * EXPECTED
     * Check if current url equals https://itcrowd.pl/vop/private/buyCredits?predefinedQuantity=<TOTAL_PRICE>.
     */
    @ Test
    public void buyMoreCreditsClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User want to buy products and there is list of items for order.
     *
     * SCENARIO
     * 1.Open the checkout page.
     *
     * EXPECTED
     * Check if:
     * 1. Quantity*Price per unit == Total price.
     * 2. Shipping == sum of Shipping cost from every row.
     * 3. Total price + Shiping Cost == Price incl. shipping.
     * 4. Sum == Total price from every row.
     * 5. Total == Sum + Shipping.
     */
    @ Test
    public void totalPriceTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User have 3 Test1 and 1 Test2 items in cart and he want to checkout.
     *
     * SCENARIO
     * 1.Open the checkout page.
     *
     * EXPECTED
     * Check if Items and their amount for order are equal items in cart
     */
    @ Test
    public void itemsForOrderTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User have items in cart and he have required amount of credits. Test check if user can Negotiate shipment.
     *
     * SCENARIO
     * 1.Open the checkout page.
     * 2.Set checkbox "Negotiate shipping price".
     * 3.Insert 10 in "Shipping price proposal" input
     * 4.Insert String in Message input.
     * 5.Click submit order
     *
     * EXPECTED
     * Check if current url points to My Shop (https://itcrowd.pl/vop/private/orderList).
     */
    @ Test
    public void submitOrderWithNegotiateShipmentTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test check if user can cancel checkout.
     *
     * SCENARIO
     * 1.Open the checkout page.
     * 2.Click Cancel button.
     *
     * EXPECTED
     * Check if current url points to cart.
     */
    @ Test
    public void cancelClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User have no funds but he want to submit order.
     *
     * SCENARIO
     * 1.Open the checkout page.
     * 2.Click Submit order button.
     *
     * EXPECTED
     * Check popup box with text "You don't have sufficient funds to pay for this order!" is displayed.
     */
    @ Test
    public void SubmitOrderClickTest(){
        Assert.fail("Not implemented yet.");
    }

}