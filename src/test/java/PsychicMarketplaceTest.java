import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class PsychicMarketplaceTest {

    @Drone
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[4]/div[2]")
    private PsychicMarketplace marketplace;

    @Test
    public void testMarketplaceProductClick()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");
        marketplace.clickProduct(0);

        //then
        assertEquals("https://itcrowd.pl/vop/product/62", driver.getCurrentUrl());
    }

    @Test
    public void testMarketplaceProductId()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

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

    @Test
    public void testMarketplaceProductImgUrl()
    {
        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

        //then
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=62", marketplace.getProductImgUrl(0));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=61", marketplace.getProductImgUrl(1));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=60", marketplace.getProductImgUrl(2));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=56", marketplace.getProductImgUrl(3));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=55", marketplace.getProductImgUrl(4));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=54", marketplace.getProductImgUrl(5));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=53", marketplace.getProductImgUrl(6));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=52", marketplace.getProductImgUrl(7));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=51", marketplace.getProductImgUrl(8));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=50", marketplace.getProductImgUrl(9));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=9", marketplace.getProductImgUrl(10));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=8", marketplace.getProductImgUrl(11));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=7", marketplace.getProductImgUrl(12));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=6", marketplace.getProductImgUrl(13));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=5", marketplace.getProductImgUrl(14));
        assertEquals("https://itcrowd.pl/vop/thumbnail?id=4", marketplace.getProductImgUrl(15));
    }

    @Test
    public void testMarketplaceProductUrl()
    {

        //given
        //when
        driver.navigate().to("https://itcrowd.pl/vop/");

        //then
        assertEquals("https://itcrowd.pl/vop/product/62", marketplace.getProductUrl(0));
        assertEquals("https://itcrowd.pl/vop/product/61", marketplace.getProductUrl(1));
        assertEquals("https://itcrowd.pl/vop/product/60", marketplace.getProductUrl(2));
        assertEquals("https://itcrowd.pl/vop/product/56", marketplace.getProductUrl(3));
        assertEquals("https://itcrowd.pl/vop/product/55", marketplace.getProductUrl(4));
        assertEquals("https://itcrowd.pl/vop/product/54", marketplace.getProductUrl(5));
        assertEquals("https://itcrowd.pl/vop/product/53", marketplace.getProductUrl(6));
        assertEquals("https://itcrowd.pl/vop/product/52", marketplace.getProductUrl(7));
        assertEquals("https://itcrowd.pl/vop/product/51", marketplace.getProductUrl(8));
        assertEquals("https://itcrowd.pl/vop/product/50", marketplace.getProductUrl(9));
        assertEquals("https://itcrowd.pl/vop/product/9", marketplace.getProductUrl(10));
        assertEquals("https://itcrowd.pl/vop/product/8", marketplace.getProductUrl(11));
        assertEquals("https://itcrowd.pl/vop/product/7", marketplace.getProductUrl(12));
        assertEquals("https://itcrowd.pl/vop/product/6", marketplace.getProductUrl(13));
        assertEquals("https://itcrowd.pl/vop/product/5", marketplace.getProductUrl(14));
        assertEquals("https://itcrowd.pl/vop/product/4", marketplace.getProductUrl(15));
    }
}
