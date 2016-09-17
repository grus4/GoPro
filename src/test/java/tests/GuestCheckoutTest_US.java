package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyLoader;

/**
 * Created by user on 8/27/2016.
 */
public class GuestCheckoutTest_US extends Fixture {


    @Test ()
    public static void guestCheckoutWithValidData_FreeShipping_VISA(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.openHeroSessionProduct();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPage();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_1);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY);
        goPro.onePageCheckout.selectState(STATE);
        goPro.onePageCheckout.fillZipField(ZIP);
        goPro.onePageCheckout.fillPhoneField(PHONE);
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

    @Test
    public static void guestCheckoutWithValidData_OvernightShipping_MasterCard(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.openHeroSessionProduct();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPage();
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
        goPro.onePageCheckout.fillCardName(CARDNAME_MASTERCARD);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_MASTERCARD);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(MASTERCARD_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.homePage.deleteAllCookies();

    }

    @Test
    public static void GuestCheckoutWithValidData_FreeShipping_AMEX(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.openHeroSessionProduct();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPage();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_1);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY);
        goPro.onePageCheckout.selectState(STATE);
        goPro.onePageCheckout.fillZipField(ZIP);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSection();
        goPro.onePageCheckout.fillCardName(CARDNAME_AMEX);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_AMEX);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(AMEX_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.deleteAllCookies();

    }
}
