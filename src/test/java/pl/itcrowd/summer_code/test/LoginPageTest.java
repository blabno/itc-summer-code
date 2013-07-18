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
 * Time: 09:48
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Arquillian.class)
public class LoginPageTest {

    @Drone
    WebDriver driver;

    @Page
    LoginPage loginPage;

    @Before
    public void beforeTests(){

    }

    /**
     * TERMS:
     * Validates correct logging in
     *
     * SCENARIO:
     * 1. Go to home page
     * 2. Click on login button
     * 3. Type login: customertest2@itcrowd.pl
     * 4. Type password: aaaaaa
     * 5. Check if you can find "Welcome: customertest2" button in header
     *
     * EXPECTATIONS
     * You correctly logged in. Top menu is now extended by e.g. "Welcome:.."
     */
    @Test
    public void logInTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.setEmailInput("tester@itcrowd.pl");
        loginPage.setPasswordInput("aaaaaa");
        loginPage.submitButtonClick();
        //then
        assertTrue(loginPage.isLoggedIn());
    }

    /**
     * TERMS:
     * Checks if pop-ups will be shown, when you leave empty fields
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Put cursor in email input field
     * 3. Press enter key/ login button
     * 4. Check if correct pop-ups appeared
     *
     * EXPECTATIONS
     * Pop-ups must appear, assert text from them with expected
     * Moreover, input fields get red, and the same warnings ("Email is required","Password is required") appears on the right
     */
    @Test
    public void emptyEmailAndPassField(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.setEmailInput("");
        loginPage.setPasswordInput("");
        loginPage.submitButtonClick();
        //then
        assertTrue(loginPage.isEmptyPasswordMessageDisplayed());
        assertTrue(loginPage.isEmptyEmailMessageDisplayed());
    }

    /**
     * TERMS:
     * Checks if only one pop-up will be shown, when someone 'll leave pass input empty
     * Checks if pass input will get red, and message on the left will be shown
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Type some random text in email input field
     * 3. Leave pass input empty
     * 4. Press enter key/ login button
     * 5. Do assertions
     *
     * EXPECTATIONS
     * Pop-up with warning "Password is required" must appear.
     * Compare pop-up's text with expected text.
     */
    @Test
    public void emptyPassFieldOnlyTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.setEmailInput("test");
        loginPage.submitButtonClick();
        //then
        assertEquals("Password is required", loginPage.getPopUpText(0));
    }

    /**
     * TERMS:
     * Checks if only one pop-up will be shown, when someone 'll leave email input empty
     * Checks if email input 'll get red, and message on the left 'll be shown
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Leave email input empty
     * 3. Type some random text in pass input field
     * 4. Press enter key/ login button
     * 5. Do assertions
     *
     * EXPECTATIONS:
     * Pop-up with message "Email is required" must appear
     */
    @Test
    public void emptyEmailFieldOnlyTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.setPasswordInput("test");
        loginPage.submitButtonClick();
        //then
        assertEquals("Email is required", loginPage.getPopUpText(0));

    }

    /**
     * TERMS:
     * Checks if pop-up "Authorization failed" will be shown
     * when someone put wrong email or pass (which don't exist in DB)
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Type random email address
     * 3. Type random password
     * 4. Press enter key/ login button
     * 5. Do assertions
     *
     * EXPECTATIONS
     * Pop-up with message "Authorization failed" must appear
     */
    @Test
    public void wrongEmailOrPasswordTypedTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.setEmailInput("test");
        loginPage.setPasswordInput("test");
        loginPage.submitButtonClick();
        //then
        assertEquals("Authorization failed!", loginPage.getPopUpText(0));
    }

    /**
     * TERMS:
     * Checks if you'll be forwarded to "https://itcrowd.pl/vop/register"
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Click on "as Customer" button
     * 3. Do assertions
     *
     * EXPECTATIONS:
     * Correctly redirected after click at link.
     * All assertions will succeed
     */
    @Test
    public void registerAsCustomerLinkTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.registerAsCustomerClick();
        String currentUrl = driver.getCurrentUrl();
        //then
        assertTrue(currentUrl.startsWith("https://itcrowd.pl/vop/register"));
    }

    /**
     * TERMS:
     * Checks "register as psychic" redirects to "https://itcrowd.pl/vop/view/registerPsychic.jsf"
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Click on "as Psychic" button
     * 3. Do assertions
     *
     * EXPECTATIONS
     * Link redirects to correct page after click
     * All assertions will succeed
     */
    @Test
    public void registerAsPsychicLinkTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.registerAsPsychicClick();
        String currentUrl = driver.getCurrentUrl();
        //then
        assertTrue(currentUrl.startsWith("https://itcrowd.pl/vop/view/registerPsychic.jsf"));
    }

    /**
     * TERMS
     * Checks if link redirects to "https://itcrowd.pl/vop/view/remindPassword.jsf"
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Click on "Forgot your password?"
     * 3. Do assertions
     *
     * EXPECTATIONS:
     * Correctly redirected after click at link.
     * All assertions will succeed
     */
    @Test
    public void forgotYourPasswordTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.forgotYourPasswordLinkClick();
        String currentUrl = driver.getCurrentUrl();
        //then
        assertTrue(currentUrl.startsWith("https://itcrowd.pl/vop/view/remindPassword.jsf"));
    }

    /**
     * TERMS:
     * Checks if link redirects to "https://itcrowd.pl/vop/view/resendToken.jsf"
     *
     * SCENARIO:
     * 1. Go to itcrowd.pl/vop/login page
     * 2. Click on "Already registered, but not activated? Resend activation mail."
     * 3. Do assertions
     *
     * EXPECTATIONS:
     * Correctly redirected after click at link.
     * All assertions will succeed
     */
    @Test
    public void resendActivationEmailTest(){
        //given
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://itcrowd.pl/vop/login");
        //when
        loginPage.resendActivationMailClick();
        String currentUrl = driver.getCurrentUrl();
        //then
        assertTrue(currentUrl.startsWith("https://itcrowd.pl/vop/view/resendToken.jsf"));
    }
}
