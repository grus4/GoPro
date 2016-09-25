package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPageAsGuest();
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
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPageAsGuest();
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
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPageAsGuest();
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

    @Test
    public static void GuestCheckoutWithValidData_OvernightShipping_Discover(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPageAsGuest();
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
        goPro.onePageCheckout.fillCardName(CARDNAME_DISCOVER);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_DISCOVER);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(DISCOVER_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.homePage.deleteAllCookies();
    }

    @Test
    public static void GuestCheckoutWithValidData_FreeShipping_PayPal(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.openHeroSessionProduct();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField(EMAIL);
        goPro.checkoutLoginPage.switchToCheckoutPageAsGuest();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_1);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY);
        goPro.onePageCheckout.selectState(STATE);
        goPro.onePageCheckout.fillZipField(ZIP);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSection();
        goPro.onePageCheckout.selectPayPal();
        goPro.onePageCheckout.switchToPayPalLoginPage();
        goPro.payPalLoginPage.fillEmailFieldPayPalForm(PAYPAL_EMAIL);
        goPro.payPalLoginPage.fillPasswordField(PAYPAL_PASSWORD);
        goPro.payPalLoginPage.switchToPayPalAccount();
        goPro.payPalAccountPage.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.deleteAllCookies();
    }
}
