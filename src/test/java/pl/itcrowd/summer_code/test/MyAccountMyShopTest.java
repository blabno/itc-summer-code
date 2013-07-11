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
    public void OrdersClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * User have Submitted Order from Peter Parker seller. Test check if user can click "Subbmitted" option in select input.
     *
     * SCENARIO
     * 1.Open the My Account - My Shop page (https://itcrowd.pl/vop/private/orderList).
     * 2.Click on "Submitted" option in select input.
     *
     * EXPECTED
     * Check if Order from Peter Parker is Displayed in contrahent column.
     */
    @ Test
    public void selectInputTest(){
        Assert.fail("Not implemented yet.");
    }


    //... Other tests
}
