package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class PhysicMarketplaceTest {

//    @FindBy (xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]")
//    public PhysicMarketplace marketplace;

    @Page
    public PhysicMarketplace marketplace;

    @Drone
    WebDriver driver;

    @Test
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
    public void productsEnterTest(){

        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //when
        marketplace.clickProduct(0);
        //then
        assertEquals("https://itcrowd.pl/vop/product/64", driver.getCurrentUrl());
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
    //given
    driver.navigate().to("https://itcrowd.pl/vop/");
    //when

    //then
    assertEquals(64, marketplace.getProductId(0));
    assertEquals(61, marketplace.getProductId(1));
    assertEquals(60, marketplace.getProductId(2));
    assertEquals(56, marketplace.getProductId(3));
    assertEquals(55, marketplace.getProductId(4));
    assertEquals(54, marketplace.getProductId(5));
    assertEquals(53, marketplace.getProductId(6));
    assertEquals(52, marketplace.getProductId(7));
    assertEquals(51, marketplace.getProductId(8));
    assertEquals(50, marketplace.getProductId(9));
    assertEquals(9, marketplace.getProductId(10));
    assertEquals(8, marketplace.getProductId(11));
    assertEquals(7, marketplace.getProductId(12));
    assertEquals(6, marketplace.getProductId(13));
    assertEquals(5, marketplace.getProductId(14));
    assertEquals(4, marketplace.getProductId(15));

    }
}
