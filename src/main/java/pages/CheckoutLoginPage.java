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

    public void switchToCheckoutPageAsGuest() {
        web.waitForElementPresent("CheckoutButtonOnLoginPage");
        web.waitForElementToBeClickable("CheckoutButtonOnLoginPage");
        web.clickButton("CheckoutButtonOnLoginPage");
        sleep(8000);

        if(web.isElementPresent("NextStepButtonInShipping")) {
            log.info("Switching to Checkout page as Guest was correct");
        } else {
            log.error("Switching to Checkout page as Guest was INCORRECT!\n");
            Assert.fail("Switching to Checkout page as Guest was INCORRECT!");
        }
    }

    public void selectLoginCheckbox() {
        web.waitForElementToBeClickable("LoginCheckbox");
        web.clickElement("LoginCheckbox");
        sleep(5000);
    }

    public void fillEmailFieldForRegisteredUser(String registeredEmail) {
        web.input("EmailFieldForRegisteredUser", registeredEmail);
    }

    public void fillPasswordFieldForRegisteredUer(String registeredPassword) {
        web.input("PasswordFieldForRegisteredUser", registeredPassword);
    }

    public void switchToCheckoutPageAsRegisteredUser() {
        web.waitForElementPresent("LoginButton");
        web.waitForElementToBeClickable("LoginButton");
        web.clickButton("LoginButton");
        sleep(8000);

        if(web.isElementPresent("NextStepButtonInShipping")){
            log.info("Switching to Checkout page as Registered User was correct");
        } else {
            log.error("Switching to Checkout page as Registered User was INCORRECT!\n");
            Assert.fail("Switching to Checkout page as Registered User was INCORRECT!");
        }
    }
}
