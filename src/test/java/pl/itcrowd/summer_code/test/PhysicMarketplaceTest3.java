package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class PhysicMarketplaceTest3 {

    @Drone
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]")
    private PhysicMarketplace marketplace;


    @Test
    public void productsEnterTest(){

        //given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //when
        marketplace.clickProduct(0);
        //then
        assertEquals("https://itcrowd.pl/vop/product/62", driver.getCurrentUrl());
    }

    @Test
    public void productsShowedImageTest(){
    //given
    driver.navigate().to("https://itcrowd.pl/vop/");
    //when

    //then
    assertEquals(62, marketplace.getProductId(0));
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
