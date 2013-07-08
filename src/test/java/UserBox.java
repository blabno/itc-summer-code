import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

class UserBox {

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

    public WebElement getDescription()
    {
        return description;
    }

    public WebElement getName()
    {
        return name;
    }

    public WebElement getPrice()
    {
        return price;
    }

    public WebElement getStatus()
    {
        return name;
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
    public String getDescriptionText()
    {
        return description.getText();
    }
    public String getPriceValue()
    {
        return price.getText();
    }
    public String getNameInfo()
    {
        return name.getText();
    }

}
