package pl.itcrowd.summer_code.test;

import junit.framework.Assert;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class MyProfileTest {

    @Drone
    WebDriver browser;

    @Page
    MyProfile myProfile;

    @Page
    LoginPage loginPage;

    @Page
    PopUp popUp;

    /**TERMS
     * Validates a click on 'change picture' button.
     * SCENARIO
     * Logged user has entered on a myaccount/myprofile page. User clicks on 'change picture' button.
     * EXPECTED
     * User should choose specified picture from disk then should be appeared popup window which allows change size of chosen picture.
     * Afterwards popup message will shown  with text 'Your profile was updated' */
    @Test
    public void changePictureTest(){
        Assert.fail("It must be tested manually.");
    }

    /**TERMS
     * Validates a 'change name' function.
     * SCENARIO
     * Logged user has entered on a myaccount/myprofile page. User gives letters in 'profil name' field then click 'save' button.
     * EXPECTED
     * Popup message will shown  with text 'Your profile was updated' */
    @Test
    public void changeNameTest(){
        //given
        browser.manage().deleteAllCookies();
        browser.navigate().to("https://itcrowd.pl/vop/login");
        loginPage.setEmailInput("testacc@itcrowd.pl");
        loginPage.setPasswordInput("testacc");
        loginPage.submitButtonClick();
        //when
        browser.navigate().to("https://itcrowd.pl/vop/view/private/myProfileDetails.jsf");
        myProfile.setNameInput("testacc2");
        myProfile.saveButtonClick();
        //then
        assertTrue(popUp.isPopUpVisible());
        assertEquals("Your profile was updated!", popUp.getPopUpText());
    }
}
