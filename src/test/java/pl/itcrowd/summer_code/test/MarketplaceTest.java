package pl.itcrowd.summer_code.test;

import org.junit.Test;

public class MarketplaceTest {

     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by name A-Z' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in ascending order by alphabet */
     @Test
     public void sortByAZtest(){
     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by name Z-A' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in descending order by alphabet */
     @Test
     public void sortByZAtest(){

     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by price lowest' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in ascending order by price */
     @Test
     public void sortByPriceAscTest(){

     }
     /**TERMS
     * Validates functionality of drop-down list called 'sort by'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'sort by price highest' then clicks button 'sort by' .
     * EXPECTED
     * Thumbnails with product will be refreshed in descending order by price */
     @Test
     public void sortByPriceDscTest(){

     }
     /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 16' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 16 thumbnails.  */
     @Test
     public void show16test(){

     }
    /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 20' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 20 thumbnails.  */
     @Test
     public void show20test(){

     }
    /**TERMS
     * Validates functionality of drop-down list called 'show'.
     * SCENARIO
     * Logged user has entered on a marketplace page. User chooses option 'show - 24' then clicks button 'show' .
     * EXPECTED
     * Marketplace page will be refreshed with maximum 24 thumbnails.  */
     @Test
     public void show24test(){

     }
    /**TERMS
     * Validates a click of 'next page' button. For example 'Show by' option should by set at 16 and there is at least 17 products.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks 'next page' button;
     * EXPECTED
     * Marketplace page will showed remaining products on next page */
    @Test
    public void nextPageTest(){

    }
    /**TERMS
     * Validates a click on 'number of page' button. For example 'Show by' option should by set at 16 and there is at least 17 products.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks '2' button;
     * EXPECTED
     * Marketplace page will showed remaining products on page 2*/
    @Test
    public void numberOfpageTest(){

    }
    /**TERMS
     * Validates a click on 'bath and beauty' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'bath and beauty' button;
     * EXPECTED
     * Marketplace page will showed products  in category 'bath and beauty'*/
    @Test
    public void goTobBathAndBeautyTest(){

    }
    /**TERMS
     * Validates a click on 'bath and body' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'bath and body' button;
     * EXPECTED
     * Marketplace page will showed  products in category 'bath and body'*/
    @Test
    public void goToBathAndBodyTest(){

    }
    /**TERMS
     * Validates a click on 'candles' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'candles' button;
     * EXPECTED
     * Marketplace page will showed  products  in category 'candles'*/
    @Test
    public void goToCandlesClick(){

    }
    /**TERMS
     * Validates a click on 'accessories' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'accessories' button;
     * EXPECTED
     * Marketplace page will showed products in category 'accessories'*/
    @Test
    public void goToAccessoriesTest(){

    }
    /**TERMS
     * Validates a click on 'jewelry' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'jewelry' button;
     * EXPECTED
     * Marketplace page will showed products in category 'accessories'*/
    @Test
    public void goTojewelryTest(){

    }
    /**TERMS
     * Validates a click on 'everything else' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'everything else' button;
     * EXPECTED
     * Marketplace page will showed products in category 'everything else'*/
    @Test
    public void goToEverythingElseTest(){

    }
    /**TERMS
     * Validates a click on 'antique' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'antique' button;
     * EXPECTED
     * Marketplace page will showed products in category 'antique'*/
    @Test
    public void goToAntiqueTest(){

    }
    /**TERMS
     * Validates a click on 'books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'books'*/
    @Test
    public void goToBooksTest(){

    }
    /**TERMS
     * Validates a click on 'e-books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'e-books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'e-books'*/
    @Test
    public void goToEbooksTest(){

    }
    /**TERMS
     * Validates a click on 'paper books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'paper books' button;
     * EXPECTED
     * Marketplace page will showed products in category 'paper books'*/
    @Test
    public void goToPaperBooksTest(){

    }
    /**TERMS
     * Validates a click on 'audio books' button in 'categories' section.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on 'audio books' button;
     * EXPECTED
     * Marketplace page will shown products in category 'audio books'*/
    @Test
    public void goToAudioBooksTest(){

    }
    /**TERMS
     * Validates a click on specified thumbnail icon.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on specified thumbnail icon.
     * EXPECTED
     * User will be redirected to page specified by thumbnail icon.*/
    @Test
    public void thumbnailTest(){

    }
    /**TERMS
     * Validates a click on specified tag icon.
     * SCENARIO
     * Logged user has entered on a marketplace page. User clicks on specified tag icon.
     * EXPECTED
     * User will be redirected to page specified by tag.*/
    @Test
    public void tagTest(){

    }
}
