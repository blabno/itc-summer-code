package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class HeaderTest {

    @Drone
    WebDriver browser;

    @FindBy(css = "#wrap")
    Header header;

    @Before
    public void beforeTests()
    {
    }

    @Test
    /**TERMS
     * Validates a click blog button.
     * SCENARIO
     * User has entered on a homepage. User clicks on blog button.
     * EXPECTED
     * User will be redirected to blog page */
    public void testBlogButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.blogButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("http://blog.voiceofpsychic.com/"));
    }

    @Test
    /**TERMS
     * Validates a click EnglishMenu button.
     * SCENARIO
     * User has entered on a homepage. User clicks on EnglishMenu icon.
     * EXPECTED
     * Homepage will be refreshed in english language  */
    public void testEnglishMenuClick()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.englishMenuClick();
        //then
        assertEquals("Psychics", header.getPsychicsButton().getText());
    }

    @Test
    /**TERMS
     * Validates a click login button.
     * SCENARIO
     * User has entered on a homepage. User clicks on login button.
     * EXPECTED
     * User will be redirected to login page */
    public void testLoginButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.loginButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/login"));
    }

    @Test
    /**TERMS
     * Validates a click SignUp button.
     * SCENARIO
     * User has entered on a homepage. User clicks on SingUp button.
     * EXPECTED
     * User will be redirected to register user page */
    public void testLoginSingUp()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.signUpButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/register"));
    }

    @Test
    /**TERMS
     * Validates a click Marketplace button.
     * SCENARIO
     * User has entered on a homepage. User clicks on Marketplace button.
     * EXPECTED
     * User will be redirected to Marketplace page */
    public void testMarketplaceButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.marketplaceButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/shop"));
    }

    @Test
    /**TERMS
     * Validates a click 'My account' button.
     * SCENARIO
     * User has entered on a homepage. User clicks on 'My account' button.
     * EXPECTED
     * User will be redirected to 'mailbox' page */
    public void testMyaccountButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.myaccountButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/private?p=MAILBOX"));
    }

    @Test
    /**TERMS
     * Validates a click PolishMenu button.
     * SCENARIO
     * User has entered on a homepage. User clicks on EnglishMenu icon.
     * EXPECTED
     * Homepage will be refreshed in polish language  */
    public void testPolishMenuClick()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.polishMenuClick();
        //then
        assertEquals("Konsultanci", header.getPsychicsButton().getText());
    }

    @Test
    /**TERMS
     * Validates a click PhysicsButton button.
     * SCENARIO
     * User has entered on a homepage. User clicks on PhysicsButton button.
     * EXPECTED
     * User will be redirected to physics page */
    public void testPsychicsButtonClick()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.psychicsButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/psychics"));
    }

    @Test
    /**TERMS
     * Validates a click 'confirm' button in search section without input letters.
     * SCENARIO
     * User has entered on a homepage. User doesn't give input letters then clicks on 'confirm' button.
     * EXPECTED
     * User will be redirected to search results page */
    public void testSearchConfirmButton()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.setSearchInput("");
        header.searchConfirmButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=", browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click 'confirm' button in search section with correct user name for example "psychic7".
     * SCENARIO
     * User has entered on a homepage. User gives correct username then clicks on 'confirm' button.
     * EXPECTED
     * User will be redirected to search results page */
    public void testSearchInputField()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        String user = "Psychic7";
        //when
        header.setSearchInput(user);
        header.searchConfirmButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=" + user, browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click 'confirm' button in search section with random letters or wrong user name.
     * SCENARIO
     * User has entered on a homepage. User gives wrong username then clicks on 'confirm' button.
     * EXPECTED
     * User will be redirected to search result page with 'No results found!' information. */
    public void testSearchWrongInputField()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        String user = "pa92mg5d72";
        //when
        header.setSearchInput(user);
        header.searchConfirmButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=" + user, browser.getCurrentUrl());
    }

    @Test
    /**TERMS
     * Validates a click Shopping cart icon.
     * SCENARIO
     * User has entered on a homepage. User clicks on SingUp button.
     * EXPECTED
     * User will be redirected to cart page */
    public void testShoppingCartClick()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.shoppingCartButtonClick();
        //then
        assertTrue(browser.getCurrentUrl().startsWith("https://itcrowd.pl/vop/cart"));
    }

    @Test
    /**TERMS
     * Validates a click VopLogo icon.
     * SCENARIO
     * User has entered on a homepage. User clicks on VopLogo icon.
     * EXPECTED
     * Homepage will be refreshed */
    public void testVopLogoClick()
    {
        //given
        browser.navigate().to("https://itcrowd.pl/vop/");
        //when
        header.vopLogoClick();
        //then
        assertEquals("https://itcrowd.pl/vop/", browser.getCurrentUrl());
    }
}