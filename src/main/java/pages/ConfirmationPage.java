package pages;

import utils.WebDriverWrapper;

/**
 * Created by Rus on 01.09.2016.
 */
public class ConfirmationPage extends Page {

    public ConfirmationPage(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public ConfirmationPage(WebDriverWrapper dr) {
        super(dr);
    }


    public boolean isThankYouMessageAvailable() {
        if(web.isElementPresent("ThankYouMessage")){
            log.info("Thank you message is displayed and the Order is successfully created");
            return true;
        } else {
            log.error("Thank you message is not displayed!!!");
            return false;
        }
    }
}
