package pages;


import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 22.10.2016.
 */
public class GoProPLusConfirmationPage extends Page{

    public GoProPLusConfirmationPage(WebDriverWrapper dr) {
        super(dr);
    }

    public boolean isThankYouMessageIsAvailable() {
        if(web.isElementPresent("")) {
            log.info("Thank you message is displayed and the GoPro Plus Order is successfully created");
            return true;
        } else {
            log.error("Thank you message is not displayed and the GoPro Plus Order was not created!!!\n");
            Assert.fail("Thank you message is not displayed and the GoPro Plus Order was not created!!");
            return false;
        }

    }

    public void switchToHomePage() {
        web.clickLink("ShopCategory");
        web.waitForElementPresent("ShopN0wHeroSessionCamera");
        web.waitForElementToBeClickable("ShopN0wHeroSessionCamera");
        sleep(12000);
    }
}
