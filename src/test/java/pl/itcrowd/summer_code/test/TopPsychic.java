package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 09.07.13
 * Time: 08:13
 * To change this template use File | Settings | File Templates.
 */
public class TopPsychic {

    @FindBy(className = "grayBorderedPanel")
    private List<TopPsychic> topPsychics;

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

    public String getDescription()
    {
        return description.getText();
    }

    public String getName()
    {
        return name.getText();
    }

    public String getPrice()
    {
        return price.getText();
    }

    public TopPsychic getTopPsychic(int index)
    {
        return topPsychics.get(index);
    }

    public int getTopPsychicsSize()
    {
        return topPsychics.size();
    }

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
