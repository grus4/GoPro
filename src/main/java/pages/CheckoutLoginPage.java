package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by user on 8/27/2016.
 */
public class CheckoutLoginPage extends Page {
    public CheckoutLoginPage(WebDriverWrapper dr) {
        super(dr);
    }

    public CheckoutLoginPage(WebDriverWrapper dr, String page) {
        super(dr, page);
    }


    public void fillEmailField(String email) {
        web.input("EmailField", email);
        log.info("Email field was filled out " + email);
    }


    public void clickCheckoutButton() {
        web.waitForElementToBeClickable("CheckoutButtonOnLoginPage");
        web.clickButton("CheckoutButtonOnLoginPage");

    }

    public void switchToCheckoutPage() {
        web.waitForElementPresent("CheckoutButtonOnLoginPage");
        web.waitForElementToBeClickable("CheckoutButtonOnLoginPage");
        web.clickButton("CheckoutButtonOnLoginPage");

        if(web.isElementPresent("NextStepButtonInShipping")) {
            log.info("Switching to Checkout page was correct");
        } else {
            log.error("Switching to Checkout page was INCORRECT!\n");
            Assert.fail("Switching to Checkout page was INCORRECT!");
        }
    }
}
