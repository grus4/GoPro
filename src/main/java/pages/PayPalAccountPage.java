package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by user on 9/18/2016.
 */
public class PayPalAccountPage extends Page{

    public PayPalAccountPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void switchToReviewPage() {
        web.waitForElementPresent("ContinueButton");
        web.waitForElementToBeClickable("ContinueButton");
        web.clickButton("ContinueButton");
        web.waitForElementPresent("CompletePurchaseButton");

        if(web.isElementPresent("CompletePurchaseButton")&&
                web.isElementAvailable("CompletePurchaseButton")){
            log.info("Switching to Review Page was correct");
        } else {
            log.error("Switching to Review Page was INCORRECT!\n");
            Assert.fail("Switching to Review Page was INCORRECT!");
        }
    }
}
