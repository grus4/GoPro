package tests;

import org.testng.annotations.Test;

/**
 * Created by Rus on 12.10.2016.
 */
public class GoProPLusCheckout_US extends Fixture {

    @Test
    public void goProPlusCheckout(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToPlusPDP();
        goPro.plusPDP.switchToGoProSignInPage();
        goPro.goProSignInPage.switchToCreateNewAccountPage();
        goPro.createNewAccountPage.fillEmailField(EMAIL);
        /*goPro.createNewAccountPage.fillFirstNameField(FIRSTNAME);
        goPro.createNewAccountPage.fillLastNameField(LASTNAME);
        goPro.createNewAccountPage.fillPasswordField(PASSWORDFORREGISTEREDUSER);
        goPro.createNewAccountPage.fillConfirmPasswordField(PASSWORDFORREGISTEREDUSER);
        goPro.createNewAccountPage.checkPrivacyPolicyCheckbox();
        goPro.createNewAccountPage.clickSignInButton();
        gopro.
*/
    }

}


