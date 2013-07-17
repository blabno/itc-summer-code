package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class CartTest {

    @Drone
    WebDriver browser;

    @Page
    Cart cart;

    @Page
    LoginPage loginPage;

    @Page
    ProductDetails productDetails;

    @Page
    PopUp popUp;

    @Before
    public void beforeTests(){}

    /**TERMS
     * Validates a click on 'remove' button.
     * SCENARIO
     * Logged user has entered on a cart page and user has at least one product in cart. User clicks on 'remove' button.
     * EXPECTED
     * Marketplace page will be refreshed without removed product and popup message will shown with text 'Product removed'*/
    @Test
    public void removeProductTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        productDetails.addToCartClick();
        cart.getProduct(0).clickRemove();
        //then
        assertEquals("Product removed", popUp.getPopUpText());
        assertEquals(0, cart.size());
    }
    /**TERMS
     * Validates a click on 'clear cart' button.
     * SCENARIO
     * Logged user has entered on a cart page and user has at least one product in cart. User clicks on 'clear cart' button.
     * EXPECTED
     * Marketplace page will be refreshed without all products and popup message will shown with text 'Cart cleared'*/
    @Test
    public void clearCartTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        browser.manage().deleteAllCookies();
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        productDetails.addToCartClick();
        cart.clearCartButtonClick();
        //then
        assertEquals("Cart cleared!", popUp.getPopUpText());
        assertEquals(0, cart.size());
    }
    /**TERMS
     * Validates a click on 'back' button.
     * SCENARIO
     * Logged user has entered on a cart page. User clicks on 'back' button.
     * EXPECTED
     * User will be redirected to homepage'*/
    @Test
    public void goBackTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/cart");
        cart.backButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/", browser.getCurrentUrl());
    }
    /**TERMS
     * Validates a click on 'checkout' button.
     * SCENARIO
     * Logged user has entered on a cart page and user has at least one product in cart. User clicks on 'checkout' button.
     * EXPECTED
     * User will be redirected to 'checkout' page*/
    @Test
    public void checkoutTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        productDetails.addToCartClick();
        cart.checkoutButtonClick();
        //then
        assertEquals("https://itcrowd.pl/vop/private/checkout", browser.getCurrentUrl());
    }
    /**TERMS
     * Validates a click on 'product name' button.
     * SCENARIO
     * Logged user has entered on a cart page and user has at least one product in cart. User clicks on specified 'product name' button.
     * EXPECTED
     * User will be redirected to specified page by product*/
    @Test
    public void clickProductName(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        productDetails.addToCartClick();
        cart.getProduct(0).clickProduct();
        //then
        assertEquals("https://itcrowd.pl/vop/product/65", browser.getCurrentUrl());
    }
     /**TERMS
     * Validates a functionality of field total order cost.
     * SCENARIO
     * Logged user has entered on a cart page and user has at least one product in cart.
     * EXPECTED
     * Total cost will showed correct value of order*/
    @Test
    public void totalCostTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/cart");
        cart.clearCartButtonClick();
        browser.navigate().to("https://itcrowd.pl/vop/product/65");
        productDetails.addToCartClick();
        //then
        assertEquals((Double) 15.0, cart.getTotalCost());
    }
}
