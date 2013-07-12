package pl.itcrowd.summer_code.test;

import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.jboss.arquillian.graphene.Graphene.guardHttp;

/**
 * Created with IntelliJ IDEA.
 * User: Wybraniec
 * Date: 11.07.13
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public class Marketplace {

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(1)")
    private WebElement sortAZ;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(2)")
    private WebElement sortZA;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(3)")
    private WebElement sortPriceLowest;

    @FindBy(css = "body.marketplace form select:nth-of-type(1) option:nth-of-type(4)")
    private WebElement sortPriceHighest;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(1)")
    private WebElement show16;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(2)")
    private WebElement show20;

    @FindBy(css = "body.marketplace form select:nth-of-type(2) option:nth-of-type(3)")
    private WebElement show24;

    @FindBy(id = "chargerSCr_ds_next")
    private WebElement nextPageButton;

    @FindBy(id = "chargerSCr_ds_2")
    private WebElement secondPageOfProductsLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(2) a")
    private WebElement bathAndBeautyCategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(3) a")
    private WebElement bathBodySubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(4) a")
    private WebElement candlesSubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(5) a")
    private WebElement accessoriesCategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(6) a")
    private WebElement jewelrySubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(7) a")
    private WebElement everythingElseCategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(8) a")
    private WebElement antiqueSubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(9) a")
    private WebElement booksCategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(10) a")
    private WebElement eBooksSubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(11) a")
    private WebElement paperBooksSubcategoryLink;

    @FindBy(css = "#wrap div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div div:nth-of-type(1) div ul li:nth-of-type(12) a")
    private WebElement audioBooksSubcategoryLink;

    @FindBy(tagName = "a")
    private WebElement thumbnail;

    @FindBy(id = "panel")
    private List<Marketplace> thumbnailLink;

    public void audioBooksSubcategoryLinkClick(){
        guardHttp(audioBooksSubcategoryLink).click();
    }

    public void paperBooksSubcategoryLinkClick(){
        guardHttp(paperBooksSubcategoryLink).click();
    }

    public void eBooksSubcategoryLinkClick(){
        guardHttp(eBooksSubcategoryLink).click();
    }

    public void booksCategoryLinkClick(){
        guardHttp(booksCategoryLink).click();
    }

    public void antiqueSubcategoryLinkClick(){
        guardHttp(antiqueSubcategoryLink).click();
    }

    public void everythingElseCategoryLinkClick(){
        guardHttp(everythingElseCategoryLink).click();
    }

    public void jewelrySubcategoryLinkClick(){
        guardHttp(jewelrySubcategoryLink).click();
    }

    public void accessoriesCategoryLinkClick(){
        guardHttp(accessoriesCategoryLink).click();
    }

    public void candlesSubcategoryLinkClick(){
        guardHttp(candlesSubcategoryLink).click();
    }

    public void bathBodySubcategoryLinkClick(){
        guardHttp(bathBodySubcategoryLink).click();
    }

    public void bathAndBeautyCategoryLinkClick(){
        guardHttp(bathAndBeautyCategoryLink).click();
    }

    public void secondPageOfProductsLinkClick(){
        guardHttp(secondPageOfProductsLink).click();
    }

    public void nextPageButtonClick(){
        guardHttp(nextPageButton).click();
    }

    public void show24Click(){
        guardHttp(show24).click();
    }

    public void show20Click(){
        guardHttp(show20).click();
    }

    public void show16Click(){
        guardHttp(show16).click();
    }

    public void sortPriceHighestClick(){
        guardHttp(sortPriceHighest).click();
    }

    public void sortPriceLowestClick(){
        guardHttp(sortPriceLowest).click();
    }

    public void sortZAClick(){
        guardHttp(sortZA).click();
    }

    public void sortAZClick(){
        guardHttp(sortAZ).click();
    }

}
