package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Rus on 12.10.2016.
 */
public class GoProPLusCheckout_US extends Fixture {

    @Test
    public void goProPlusCheckout_VISA(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToPlusPDP();
        goPro.plusPDP.switchToGoProSignInPage();
        goPro.goProSignInPage.switchToCreateNewAccountPage();
        goPro.createNewAccountPage.fillEmailField(EMAIL);
        goPro.createNewAccountPage.fillFirstNameField(FIRSTNAME);
        goPro.createNewAccountPage.fillLastNameField(LASTNAME);
        goPro.createNewAccountPage.fillPasswordField(PASSWORDFORREGISTEREDUSER);
        goPro.createNewAccountPage.fillConfirmPasswordField(PASSWORDFORREGISTEREDUSER);
        goPro.createNewAccountPage.checkPrivacyPolicyCheckbox();
        goPro.createNewAccountPage.clickSignInButton();
        goPro.goProPlusCheckoutPage.fillCardHoldersNameField(FIRSTNAME);
        goPro.goProPlusCheckoutPage.fillCardNumberField(CARDNUMBER_VISA);
        goPro.goProPlusCheckoutPage.selectExpMonth(MONTH);
        goPro.goProPlusCheckoutPage.selectExpYear(YEAR);
        goPro.goProPlusCheckoutPage.fillCVVField(VISA_CVV);
        goPro.goProPlusCheckoutPage.fillZipField(ZIP);
        goPro.goProPlusCheckoutPage.switchToGoProPlusConfirmationPage();
        Assert.assertTrue(goPro.goProPlusConfirmationPage.isThankYouMessageIsAvailable(), "Thank you message is not displayed");
        goPro.goProPlusConfirmationPage.switchToHomePage();
        goPro.homePage.deleteAllCookies();
    }

}


