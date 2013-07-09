package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 09.07.13
 * Time: 08:13
 * To change this template use File | Settings | File Templates.
 */
public class UserBox {

    @FindBy(css = "[id$=':description']")
    private WebElement description;

    @FindBy(css = ".btn-info")
    private WebElement email;

    @FindBy(css = "[id$=':nickname1']")
    private WebElement name;

    @FindBy(css = "[id$=':price']")
    private WebElement price;

    @FindBy(className = "pull-right")
    private WebElement readMore;

    @FindBy(css = "div.status")
    private WebElement status;

    @FindBy(css = "[id = 'row_0'] div div:nth-of-type(2) div span a img")
    private WebElement image;

    @FindBy(css = "[id$=':nickname2']")
    private WebElement max1Name;

    @FindBy(css = "[id$=':nickname3']")
    private WebElement peterName;

    @FindBy(css = "[id = 'row_3'] div div h4 span")
    private WebElement psychic5Name;

    @FindBy(css = "[id = 'row_3'] div:nth-of-type(2) div h4 span")
    private WebElement krzysztof52Name;

    @FindBy(css = "[id = 'row_3'] div:nth-of-type(3) div h4 span")
    private WebElement psychic4Name;

    //Getters
    public WebElement getImage(){
        return image;
    }

    public WebElement getDescription() {
        return description;
    }

    public String getDescriptionText()
    {
        return description.getText();
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getName() {
        return name;
    }

    public String getNameInfo()
    {
        return name.getText();
    }

    public WebElement getPrice() {
        return price;
    }

    public String getPriceValue()
    {
        return price.getText();
    }
    public String getMax1Name() {
        return max1Name.getText();
    }

    public String getPeterName() {
        return peterName.getText();
    }

    public String getPsychic5Name() {
        return psychic5Name.getText();
    }

    public String getKrzysztof52Name() {
        return krzysztof52Name.getText();
    }

    public String getPsychic4Name() {
        return psychic4Name.getText();
    }

    public WebElement getReadMore() {
        return readMore;
    }
    public WebElement getStatus() {
        return status;
    }
    //Methods

    public void emailClick()
    {
        guardHttp(email).click();
    }
    public void readMoreClick()
    {
        guardHttp(readMore).click();
    }
    public boolean statusOnline()
    {
        String actualStatus = status.getText();

        if(actualStatus.equals("Online"))
            return true;
        else
            return false;
    }
    public void nameClick(){
        guardHttp(name).click();
    }
    public void imageClick(){
        guardHttp(image).click();
    }


}