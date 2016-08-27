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
        web.waitForElementPresent("EmailField");
        web.waitForElementToBeClickable("CheckoutButtonOnLoginPage");

        if(web.isElementPresent("EmailField")
                && web.isElementAvailable("CheckoutButtonOnLoginPage")) {

            log.info("Switching to Guest checkout Login page was correct");
        } else {
            log.error("Switching to Guest checkout Login page was INCORRECT\n");
            Assert.fail("Switching to Guest checkout Login page was INCORRECT");
        }
    }
}

