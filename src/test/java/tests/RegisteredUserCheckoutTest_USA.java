package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisteredUserCheckoutTest_USA extends Fixture{

    @Test
    public void RegisteredCheckoutWithValidData_OvernightShipping_VISA(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.selectLoginCheckbox();
        goPro.checkoutLoginPage.fillEmailFieldForRegisteredUser(EMAILFORREGISTEREDUSER);
        goPro.checkoutLoginPage.fillPasswordFieldForRegisteredUer(PASSWORDFORREGISTEREDUSER);
        goPro.checkoutLoginPage.switchToCheckoutPageAsRegisteredUser();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_1);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY);
        goPro.onePageCheckout.selectState(STATE);
        goPro.onePageCheckout.fillZipField(ZIP);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.selectOvernightShipping();
        goPro.onePageCheckout.switchToPaymentSection();
        goPro.onePageCheckout.fillCardName(CARDNAME_VISA);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_VISA);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(VISA_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.homePage.deleteAllCookies();
    }
}
