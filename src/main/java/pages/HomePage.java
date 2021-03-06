package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 19.08.2016.
 */
public class HomePage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HomePage(WebDriverWrapper dr) {
        super(dr);
    }

    public HomePage(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public void clickShopNowButton(){
        web.clickButton("ShopNowButton");
        log.info("Shop now button was clicked");
        sleep(13000);

    }

    public void clickSelectDifferentLocationLink(){
        web.clickLink("SelectDifferentLocationLink");
        log.info("Select a different location link was clicked");
    }

    public void selectCountryFromCountryConfirmDropDown(String country){
        web.selectFromListByVisibleText("CountryDropDownOnCountryConfirmDialogue", country);
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

    public void openHero4BlackProudct(){
        webDriverWrapper.get(PropertyLoader.loadProperty("Hero4BlackProductPage"));
    }

    public void openHero4SilverProduct(){
        webDriverWrapper.get(PropertyLoader.loadProperty("Hero4SilverProductPage"));
    }

    public void openHeroSessionProduct(){
        webDriverWrapper.get(PropertyLoader.loadProperty("HeroSessionProductPage"));
    }


    public void switchToHeroSessionPage(){

        web.scrollPageToElement("ShopN0wHeroSessionCamera");
        web.waitForElementPresent("ShopN0wHeroSessionCamera");
        web.waitForElementToBeClickable("ShopN0wHeroSessionCamera");
        web.clickElement("ShopN0wHeroSessionCamera");
        sleep(15000);
        web.waitForElementPresent("AddToCartButton");
        web.waitForElementToBeClickable("AddToCartButton");

    }
    public void checkCorrectSwitchingToHeroSessionPage(){

        if(web.isElementPresent("AddToCartButton")&&
                web.isElementAvailable("AddToCartButton")) {
            log.info("Switching to Hero Session page was correct");
        } else {
            log.error("Switching to Hero Session page was INCORRECT!\n");
            Assert.fail("Switching to Hero Session page was INCORRECT!");
        }
    }


    public void switchToPlusPDP() {
        web.clickElement("PlusCategory");
        web.waitForElementPresent("StartFor60DayTrialButton");
        web.waitForElementToBeClickable("StartFor60DayTrialButton");
        checkCorrectSwitchingToPlusPDP();
    }

    public void checkCorrectSwitchingToPlusPDP(){
        if(web.isElementPresent("StartFor60DayTrialButton")&&
                web.isElementAvailable("StartFor60DayTrialButton")){
            log.info("Switching to Plus PDP was correct");
        } else {
            log.error("Switching to Plus PDP was INCORRECT!\n");
            Assert.fail("Switching to Plus PDP was INCORRECT!");
        }
    }
}
