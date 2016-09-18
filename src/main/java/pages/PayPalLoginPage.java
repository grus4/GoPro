package pages;

import org.testng.Assert;
import utils.WebDriverWrapper;

/**
 * Created by user on 9/18/2016.
 */
public class PayPalLoginPage extends Page{


    public PayPalLoginPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillEmailFieldPayPalForm(String payPalEmail) {
        web.input("EmailField_PayPalForm", payPalEmail);
    }

    public void fillPasswordField(String paypalPassword) {
        web.input("PasswordField_PayPalForm", paypalPassword);
    }

    public void switchToPayPalAccount() {
        web.waitForElementPresent("LoginButton_PayPalForm");
        web.waitForElementToBeClickable("LoginButton_PayPalForm");
        web.clickButton("LoginButton_PayPalForm");

        if(web.isElementPresent("ContinueButton")&&
                web.isElementAvailable("ContinueButton")){
            log.info("Switching to PayPal Account was correct");
        } else {
            log.error("Switching to PayPal Account was INCORRECT!\n");
            Assert.fail("Switching to PayPal Account was INCORRECT!");
        }
    }
}
