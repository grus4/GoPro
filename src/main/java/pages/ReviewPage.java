package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 30.08.2016.
 */
public class ReviewPage extends Page{
    public ReviewPage(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public ReviewPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void switchToConfirmationPage() {
        web.waitForElementPresent("CompletePurchaseButton");
        web.waitForElementToBeClickable("CompletePurchaseButton");
        sleep(5000);
        web.clickButton("CompletePurchaseButton");
        //web.waitForElementPresent("OrderNumber");
        sleep(6000);

        if(web.isElementPresent("OrderNumber")&&
                web.isElementAvailable("OrderNumber")){
            log.info("Switching to Confirmation page was correct and the order is created successfully");
        } else {
            log.error("Switching to Confirmation page was INCORRECT!\n");
            Assert.fail("The order is failed");
        }
    }
}
