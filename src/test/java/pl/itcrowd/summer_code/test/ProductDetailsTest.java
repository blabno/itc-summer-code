package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class ProductDetailsTest {

    /**TERMS
     * Test check if product name is displayed
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64)
     * EXPECTED
     *
     * Check if product name is displayed (for example "atest3")
     */
    @ Test
    public void productNameTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test check if product description is displayed
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64)
     * EXPECTED
     *
     * Check if product description is displayed (for example "123")
     */
    @ Test
    public void productDescriptionTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test check if image box is displayed after click on product image.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Check if product image is displayed (some products don't have images).
     * 3.Click on product image.
     *
     * EXPECTED
     * Check if image box is displayed.
     */
    @ Test
    public void productImageClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test check if click on thumbnail of product enlarges current thumbnail.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on the second thumbnail in the list on the right side of large image.
     * EXPECTED
     *
     * Check if clicked thumbnail is enlarged.
     */
    @ Test
    public void productThumbnailClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if sellers nickname is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if sellers nickname is displayed (for example "Psychic4").
     */
    @ Test
    public void sellerNickNameTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if sellers status is correct.
     *
     * SCENARIO
     * 1.Set seller status as Online/Offline.
     * 2.Open Product Details page of the seller product.
     *
     * EXPECTED
     * Check if sellers status is displayed as Online/Offline.
     */
    @ Test
    public void sellerStatusTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if country of seller is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if country of seller is displayed.
     */
    @ Test
    public void sellerCountryTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click on "Click to Psychic profile" redirect to seller profile page.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if current url points to seller profile page.
     */
    @ Test
    public void ClickToPsychicProfileCLickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click on Email button redirect to page where user can write an email to seller.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Click on the Email button.
     *
     * EXPECTED
     * Check if current url points to https://itcrowd.pl/vop/private/createMessage?userId=<USER_ID>.
     */
    @ Test
    public void emailCLickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click on Chat button by not logged user redirect to login page
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 2.Click on the Chat button.
     *
     * EXPECTED
     * Check if current url points to login page.
     */
    @ Test
    public void ChatClickByNotLoggedUserTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click on Chat button by logged user opens Dialog Box.
     *
     * SCENARIO
     * 1.Log in as some user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     *
     * EXPECTED
     * Check if Dialog Box is displayed.
     */
    @ Test
    public void ChatClickBytLoggedUserTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test if user can click on Chat for free in Chat Dialog Box.
     *
     * SCENARIO
     * 1.Log in as user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     * 4.Click on "Chat for free" button.
     * 5.Accept chat from invited account.
     *
     * EXPECTED
     * Check if Chat box is displayed.
     */
    @ Test
    public void chatForFreeTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click "Buy credits" in Chat Dialog Box redirect to Buy Credits page.
     *
     * SCENARIO
     * 1.Log in as some user (for example testacc@itcrowd.pl:testacc).
     * 2.Open the product page (for example https://itcrowd.pl/vop/product/64).
     * 3.Click on the Chat button.
     * 4.Click on "Buy credits"
     *
     * EXPECTED
     * Check if current url is https://itcrowd.pl/vop/private/buyCredits.
     */
    @ Test
    public void ChatBuyCreditsTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if product price is displayed.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/64).
     *
     * EXPECTED
     * Check if product price is displayed.
     */
    @ Test
    public void productPriceTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if product is available.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     *
     * EXPECTED
     * Check if there is 5 pieces available (there can be different value for other products).
     */
    @ Test
    public void productAvailabilityTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button without value set in input.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Clean quantity input
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if there is popup info with text "Wrong quantity value!" displayed.
     */
    @ Test
    public void addToCartNoQuantityTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button with to many pieces set.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Get number of available items
     * 2.Input high value into Quantity input (for example 1000000)
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if there is popup info with text "Desired quantity is greater than actual product quantity! You can buy max <available_items>." displayed.
     */
    @ Test
    public void addToCartToMuchQuantityTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if there is popup info displayed when click on Add to cart button with valid number of items.
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Get number of available items
     * 2.Input value <= available items into Quantity input
     * 3.Click Add to cart button
     *
     * EXPECTED
     * Check if Cart is displayed.
     */
    @ Test
    public void addToCartValidQuantityTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click on Read more link opens Return Policy box
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on "Read more" link
     *
     * EXPECTED
     * Check if there is Return Policy box displayed.
     */
    @ Test
    public void readMoreClickTest(){
        Assert.fail("Not implemented yet.");
    }

    /**TERMS
     * Test checks if click close (X) Button hide Return Policy box
     *
     * SCENARIO
     * 1.Open the product page (for example https://itcrowd.pl/vop/product/56).
     * 2.Click on "Read more" link
     * 3.Click X button for close box.
     *
     * EXPECTED
     * Check if there is not Return Policy box displayed.
     */
    @ Test
    public void ReturnPolicyCloseTest(){
        Assert.fail("Not implemented yet.");
    }

}