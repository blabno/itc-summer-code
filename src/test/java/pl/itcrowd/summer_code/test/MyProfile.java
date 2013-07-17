package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import static org.jboss.arquillian.graphene.Graphene.guardXhr;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
public class MyProfile {

    @FindBy(css = "#form div div span span span span input")
    private WebElement changePictureButton;

    @FindBy(css = ".controls input")
    private WebElement nameInput;

    @FindBy(css = "#form div input")
    private WebElement saveButton;

    @FindBy(tagName = "img")
    private WebElement avatar;

    public void setNameInput(String newName){
        nameInput.clear();
        nameInput.sendKeys(newName);
    }

    public void saveButtonClick(){
        guardXhr(saveButton).click();
    }

    public void changePictureButtonClick(){
        guardHttp(changePictureButton).click();
    }

    public String getAvatarUrl()
    {
        return avatar.getAttribute("src");
    }

}
