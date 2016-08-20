package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 19.08.2016.
 */
public class HomePage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HomePage(WebDriverWrapper dr) {
        super(dr);
    }

    public void clickShopNowButton(){
        web.clickButton("ShopNowButton");
        log.info("Shop now button was clicked");
    }

    public void clickSelectDifferentLocationLink(){
        web.clickLink("SelectDifferentLocationLink");
        log.info("Select a different location link was clicked");
    }

    public void selectCountryFromCountryConfirmDropDown(String country){
        web.selectFromList("CountryDropDownOnCountryConfirmDialogue", country);
        log.info(country + " was selected from country list");
    }

    public void clickUnitedStatesLink(){
        web.clickLink("UnitesStatesLink");
        log.info("United States link was clicked");
    }

    public void checkSelectedCountry(String country){
        selectCountryFromCountryConfirmDropDown(country);
        String looksLikeYouAreInThisCountry = web.getElementText("LooksLikeYouAreInThisCountry");

        if(looksLikeYouAreInThisCountry.equals(country)){
            log.info("Looks like you are in " + looksLikeYouAreInThisCountry);
        } else {
            log.error("LOOKS LIKE SELECTED COUNTRY FROM DROP DOWN LIST DOES NOT MATCH WITH " + looksLikeYouAreInThisCountry);
            Assert.fail("LOOKS LIKE SELECTED COUNTRY FROM DROP DOWN LIST DOES NOT MATCH WITH " + looksLikeYouAreInThisCountry);
        }
    }



    public void switchToHeroSessionPDP(){
        web.scrollPageToElement("HeroSessionCamera");
        web.clickElement("");

        web.waitForElementPresent("");
        if(web.isElementPresent("")&&
                web.isElementAvailable("")) {
            log.info("");
        } else {
            log.error("");

        }
    }
}
