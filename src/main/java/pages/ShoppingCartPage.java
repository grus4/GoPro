package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by user on 8/27/2016.
 */
public class ShoppingCartPage extends Page{
    public ShoppingCartPage(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public ShoppingCartPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void switchToCheckoutLoginPage() {
        web.clickButton("CheckoutButtonInShoppingCart");
        web.waitForElementToBeClickable("NoThanksButton");

        if(web.isElementPresent("NoThanksButton")){
            //web.waitForElementToBeClickable("NoThanksButton");
            web.clickButton("NoThanksButton");
            log.info("Close the offered SD card");
        } else {
            log.info("Switching to checkout page");
        }

        web.waitForElementPresent("EmailField");
        web.waitForElementToBeClickable("EmailField");

        if(web.isElementPresent("EmailField")) {
            log.info("Switching to Guest checkout Login page was correct");
        } else {
            log.error("Switching to Guest checkout Login page was INCORRECT\n");
            Assert.fail("Switching to Guest checkout Login page was INCORRECT");
        }
    }
}

