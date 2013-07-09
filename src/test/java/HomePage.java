import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 03.07.13
 * Time: 09:34
 * To change this template use File | Settings | File Templates.
 */

public class HomePage {

    @FindBy(css = "div.alert  a")
    private WebElement registerToGet3Minutes;

    @FindBy(css = "div:nth-of-type(2) div:nth-of-type(5) div.span12 a img")
    private WebElement areYouPsychicJoin;

    public void registerToGet3MinutesClick(){
        guardHttp(registerToGet3Minutes).click();
    }
    public void areYouPsychicJoinClick(){
        guardHttp(areYouPsychicJoin).click();
    }
    //Getters
    public WebElement getAreYouPsychicJoin(){
        return areYouPsychicJoin;
    }
    public WebElement getRegisterToGet3Minutes(){
        return registerToGet3Minutes;
    }


    /**
     * Created with IntelliJ IDEA.
     * User: Wybraniec
     * Date: 04.07.13
     * Time: 08:49
     * To change this template use File | Settings | File Templates.
     */
    //Subclass in HomePageClass, represents socials share menu below banner.
    public static class SocialsSharesMenu {

        @FindBy(css = "div.pluginConnectButton div div button span")
        private WebElement fbLikeItButton;

        @FindBy(xpath = "//*[@id=\"facebook\"]/body/div/div/div/table/tbody/tr/td[2]/div/div[1]")
        private WebElement fbLikesCounter;

        @FindBy(xpath = "//*[@id=\"widget\"]/div[1]")
        private WebElement twittButton;

        @FindBy(xpath = "//*[@id=\"c\"]")
        private WebElement twittsCounter;

        @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[2]/div[2]/div/a[3]")
        private WebElement pinItButton;

        @FindBy(xpath = "//*[@id=\"wrap\"]/div[2]/div[2]/div[2]/div/a[4]/a[1]")
        private WebElement shareOnSubMenu;

        public void fbLikeItButtonClick(){
            guardHttp(fbLikeItButton).click();
        }

        //Getters
        public WebElement getFbLikeItButton() {
            return fbLikeItButton;
        }

        public WebElement getFbLikesCounter() {
            return fbLikesCounter;
        }

        public WebElement getTwittButton() {
            return twittButton;
        }

        public WebElement getTwittsCounter() {
            return twittsCounter;
        }

        public WebElement getPinItButton() {
            return pinItButton;
        }

        public WebElement getShareOnSubMenu() {
            return shareOnSubMenu;
        }
    }
}
