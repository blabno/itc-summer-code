import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 05.07.13
 * Time: 12:35
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class HomePageTest {
    @FindBy(css = "#wrap")
    HomePage homePage;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){
        browser.navigate().to("https://itcrowd.pl/vop/");
    }

    @Test
    public void testRegisterToGet3Minutes(){
        //Given
        //URL of the main page is given in @Before
        //When
        homePage.registerToGet3MinutesClick();
        //Then
        assertEquals("https://itcrowd.pl/vop/register",browser.getCurrentUrl());
    }
    @Test
    public void testAreYouPsychicJoin(){
        //Given
        //URL of the main page is given in @Before
        //When
        homePage.areYouPsychicJoinClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/registerPsychic.jsf"));
    }
    @Test
    public void testFbLikeItButton(){
        //Given

        //When

        //Then
    }
}
