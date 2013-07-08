package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 08.07.13
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public class PsychicMarketplaceTest2 {

    /**
     * TERMS:
     * User can click on one of products
     * This link provide to "https://itcrowd.pl/vop/product/productID
     *
     * SCENARIO:
     * 1. Press one of products
     * 2. Check if page "https://itcrowd.pl/vop/product/productID" has been reached
     *
     * EXPECTED:
     * Test are correct if expected page and current page after click are equals
     * If we click on the product with id 61, displayed page must be "https://itcrowd.pl/vop/product/61"
     */
    @Test
    public void productsEnterTest(){
        Assert.fail("Not implemented yet");
    }

    /**
     * TERMS:
     * This method checks if there is 6 products with images in all 16 products.
     * src must be checked to do this
     *
     * SCENARIO:
     * 1. Go to the main page
     * 2. Check thumbnails id's
     *
     * EXPECTED:
     * Thumbnails are different to each other only by id
     * So, assertions must check that each 'n' every thumbnail has expected id
     */
    @Test
    public void productsShowedImageTest(){
        Assert.fail("Not implemented yet");
    }
}
