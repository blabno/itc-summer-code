package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopUp {

    @FindBy(css = "div.rf-ntf-cnt")
    private List<WebElement> popUps;

    public String getPopUpText(){
        return popUps.get(0).getText();
    }

    public String getPopUpText(int index){
        return popUps.get(index).getText();
    }

    public int popUpsSize(){
        return popUps.size();
    }

    public boolean isPopUpVisible(){
        return popUps.get(0).isDisplayed();
    }
}
