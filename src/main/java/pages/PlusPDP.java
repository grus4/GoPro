package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.10.2016.
 */
public class PlusPDP extends Page{

    public PlusPDP(WebDriverWrapper dr) {
        super(dr);
    }

    public void switchToGoProSignInPage() {
        web.clickButton("StartFor60DayTrialButton");
        web.waitForElementPresent("SignInButton");
        web.waitForElementToBeClickable("SignInButton");
        checkCorrectSwitchingToGoProLoginPage();
        sleep(5000);
    }

    public void checkCorrectSwitchingToGoProLoginPage(){
        if(web.isElementPresent("SignUpForFreeLink")&&
                web.isElementAvailable("SignUpForFreeLink")){
            log.info("Switching to GoPro Login Page was correct");
        } else {
            log.error("Switching to GoPro Login Page was INCORRECT!\n");
            Assert.fail("Switching to GoPro Login Page was INCORRECT!");
        }
    }
}
