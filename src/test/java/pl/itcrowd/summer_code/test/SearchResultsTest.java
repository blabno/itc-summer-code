package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 10.07.13
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class SearchResultsTest {
    @Drone
    WebDriver driver;
    @Page
    SearchResults searchResults;
    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests(){
    }
    /**
     * TERMS:
     * Checks if typed string is not found in system
     * Not only URL must be checked, but displayed text result too
     *
     * SCENARIO:
     * 1. Go to "https://itcrowd.pl/vop/view/searchResult.jsf"
     * 2. Type some random text
     * 3. Press enter key/ searchConfirm button
     * 4. Do some assertions
     *
     * EXPECTATIONS
     * Link should redirect to the "https://itcrowd.pl/vop/view/searchResult.jsf?find=typed_string"
     * There should be message displayed in both psychics and market section: "No results found"
     */
    @Test
    public void notFoundSearchEffectTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/view/searchResult.jsf");
        //when
        searchResults.setSearchInput("asdf");
        searchResults.searchButtonClick();
        //then
        assertEquals("No results found!",searchResults.getPsychicNoResultFoundText());
        assertEquals("No results found!",searchResults.getMarketplaceNoResutFoundText());
    }

    /**
     * TERMS:
     * Checks if typed name of existing psychic forward to right URL
     * and if there is anything displayed
     *
     * SCENARIO:
     * 1. Go to "https://itcrowd.pl/vop/view/searchResult.jsf"
     * 2. Type name of existing psychic, e.g. psychic7
     * 3. Press enter key/ searchConfirm button
     * 4. Do assertions
     *
     * EXPECTATIONS
     * Link should redirect to the "https://itcrowd.pl/vop/view/searchResult.jsf?find=psychic7"
     * and there should be box displayed in Psychics section
     * In marketplace section there should be:"No results found"
     */
    @Test
    public void psychicFoundSearchEffectTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/view/searchResult.jsf");
        //when
        searchResults.setSearchInput("psychic7");
        searchResults.searchButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=psychic7",driver.getCurrentUrl());
        assertTrue((searchResults.psychicsFoundSize()) > 0);
    }

    /**
     * TERMS:
     * Checks when there was nothing typed, and search was pressed,
     * if there is a list of psychics
     *
     * SCENARIO:
     * 1. Go to "https://itcrowd.pl/vop/view/searchResult.jsf"
     * 2. Leave input empty
     * 3. Press enter key/ searchConfirm button
     * 4. Do assertions
     *
     * EXPECTATIONS
     * Link should redirect to the "https://itcrowd.pl/vop/view/searchResult.jsf?find="
     * In Psychics section there should be 6 boxes with psychics
     * In Marketplace section there should be 12 boxes with products
     */
    @Test
    public void emptyInputSearchEffectTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/view/searchResult.jsf");
        //when
        searchResults.setSearchInput("");
        searchResults.searchButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=",driver.getCurrentUrl());
        assertTrue((searchResults.psychicsFoundSize()) > 5);
        assertTrue((searchResults.productsThumbnailsSize()) > 11);
    }

    /**
     * TERMS:
     * Checks if product exists in system
     *
     * SCENARIO:
     * 1. Go to "https://itcrowd.pl/vop/view/searchResult.jsf"
     * 2. Type product name, e.g. "123"
     * 3. Press enter key/ searchConfirm button
     * 4. Do assertions
     *
     * EXPECTATIONS:
     * Link should redirect to the "https://itcrowd.pl/vop/view/searchResult.jsf?find=123"
     * In Psychics section there should be text: "No results found"
     * In Marketplace section there should be searched product.
     */
    @Test
    public void productSearchTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        driver.navigate().to("https://itcrowd.pl/vop/view/searchResult.jsf");
        //when
        searchResults.setSearchInput("123");
        searchResults.searchButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/view/searchResult.jsf?find=123",driver.getCurrentUrl());
        assertEquals("No results found!",searchResults.getPsychicNoResultFoundText());
        assertTrue((searchResults.productsThumbnailsSize()) > 0);
    }
}