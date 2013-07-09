import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 04.07.13
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class HeaderTest {

    @FindBy(css = "#wrap")
    Header header;
    @Drone
    WebDriver browser;
    @Before
    public void beforeTests(){
        browser.navigate().to("https://itcrowd.pl/vop/");
    }

    @Test
    public void testVopLogoClick(){
        //Given
        //URL of the main page is given in @Before
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.vopLogoClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/"));
    }
    @Test
    public void testPsychicsButtonClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.psychicsButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/psychics"));
    }
    @Test
    public void testMarketplaceButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.marketplaceButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/shop"));
    }
    @Test
    public void testBlogButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.blogButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("http://blog.voiceofpsychic.com/"));
    }
    @Test
    public void testMyaccountButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.myaccountButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private?p=MAILBOX"));
    }
    @Test
    public void testSearchInputField(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.setSearchInput();
        header.searchConfirmButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/searchResult.jsf?find=psychic7"));
    }
    @Test
    public void testSearchConfirmButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.searchConfirmButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/view/searchResult.jsf?find="));
    }
    @Test
    public void testLoginButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.loginButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/login"));
    }
    @Test
    public void testSignUpButton(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.signUpButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/register"));
    }
    @Test
    public void testShoppingCartClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.shoppingCartButtonClick();
        //Then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/cart"));
    }
    @Test
    public void testEnglishMenuClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.englishMenuClick();
        //Then
        assertEquals("Psychics",header.getPsychicsButton().getText());
    }
    @Test
    public void testPolishMenuClick(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.polishMenuClick();
        //Then
        assertEquals("Konsultanci",header.getPsychicsButton().getText());
    }
    @Test
    public void testCartAmount(){
        //Given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //When
        header.marketplaceButtonClick();
        header.itemToBuyClick();
        header.itemToAddToCartClick();
        //Then
        assertEquals("(1)",header.getCartAmount().getText());
    }




}
