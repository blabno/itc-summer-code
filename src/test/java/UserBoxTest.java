import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class UserBoxTest {

    @FindBy(css = ".grayBorderedPanel:nth-of-type(1)")
    UserBox userBoxTester;

    @Drone
    WebDriver driver;

    @Test
    public void readMoreClickTest(){
        //Given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //When
        String pageUrl= driver.getCurrentUrl();
        userBoxTester.readMoreClick();
        String actualPageUrl = driver.getCurrentUrl();
        boolean isItHomePage = pageUrl.equals(actualPageUrl);
        //Then
        assertFalse(isItHomePage);
    }
    @Test
    public void emailClickTest(){
        //Given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //When
        String pageUrl= driver.getCurrentUrl();
        userBoxTester.emailClick();
        String actualPageUrl = driver.getCurrentUrl();
        boolean isItHomePage = pageUrl.equals(actualPageUrl);
        //Then
        assertFalse(isItHomePage);
    }
    @Test
    public void statusOnlineTest()
    {
        //Given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //When
        boolean result = userBoxTester.statusOnline();
        //Then
        assertFalse(result);
    }
    @Test
    public void getPriceValueTest()
    {
        //Given
       driver.navigate().to("https://itcrowd.pl/vop/");
        //When
        String actualPrice = userBoxTester.getPriceValue();
        //Then
        assertEquals("$ 0.50 / min",actualPrice);
    }
    @Test
    public void getDescriptionTextTest()
    {
        //Given
        driver.navigate().to("https://itcrowd.pl/vop/");
       //When
        String userDescription = userBoxTester.getDescriptionText();
        //Then
        assertEquals("I am Nature Born Psychic and Spiritual Messenger, Contact me for Honest reading.",userDescription);
    }
    @Test
    public void getNameInfoTest()
    {
        //Given
        driver.navigate().to("https://itcrowd.pl/vop/");
        //When
        String userName = userBoxTester.getNameInfo();
        //Then
        assertEquals("Psychic7",userName);
    }

}