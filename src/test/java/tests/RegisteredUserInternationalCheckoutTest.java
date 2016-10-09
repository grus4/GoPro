package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Rus on 09.10.2016.
 */
public class RegisteredUserInternationalCheckoutTest extends Fixture {

    @Test
    public void registeredUserInternationalCheckoutWithValidData_VISA(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(INT_COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.homePage.checkCorrectSwitchingToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.selectLoginCheckbox();
        goPro.checkoutLoginPage.fillEmailFieldForRegisteredUser(EMAILFORREGISTEREDUSER);
        goPro.checkoutLoginPage.fillPasswordFieldForRegisteredUer(PASSWORDFORREGISTEREDUSER);
        goPro.checkoutLoginPage.switchToCheckoutPageAsRegisteredUser();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_INT);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY_INT);
        goPro.onePageCheckout.selectState(STATE_INT);
        goPro.onePageCheckout.fillZipField(ZIP_INT);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSectionOnInternationalSite();
        goPro.onePageCheckout.checkCorrectSwitchingToPaymentSection();
        goPro.onePageCheckout.fillCardName(CARDNAME_VISA);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_VISA);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(VISA_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.switchToHomePage();
        goPro.homePage.deleteAllCookies();
    }

    @Test
    public void registeredUserInternationalCheckoutWithValidData_MasterCard(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(INT_COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.homePage.checkCorrectSwitchingToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.selectLoginCheckbox();
        goPro.checkoutLoginPage.fillEmailFieldForRegisteredUser(EMAILFORREGISTEREDUSER);
        goPro.checkoutLoginPage.fillPasswordFieldForRegisteredUer(PASSWORDFORREGISTEREDUSER);
        goPro.checkoutLoginPage.switchToCheckoutPageAsRegisteredUser();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_INT);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY_INT);
        goPro.onePageCheckout.selectState(STATE_INT);
        goPro.onePageCheckout.fillZipField(ZIP_INT);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSectionOnInternationalSite();
        goPro.onePageCheckout.checkCorrectSwitchingToPaymentSection();
        goPro.onePageCheckout.fillCardName(CARDNAME_MASTERCARD);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_MASTERCARD);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(MASTERCARD_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.switchToHomePage();
        goPro.homePage.deleteAllCookies();
    }

    @Test
    public void registeredUserInternationalCheckoutWithValidData_AMEX(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(INT_COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.homePage.checkCorrectSwitchingToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.selectLoginCheckbox();
        goPro.checkoutLoginPage.fillEmailFieldForRegisteredUser(EMAILFORREGISTEREDUSER);
        goPro.checkoutLoginPage.fillPasswordFieldForRegisteredUer(PASSWORDFORREGISTEREDUSER);
        goPro.checkoutLoginPage.switchToCheckoutPageAsRegisteredUser();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_INT);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY_INT);
        goPro.onePageCheckout.selectState(STATE_INT);
        goPro.onePageCheckout.fillZipField(ZIP_INT);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSectionOnInternationalSite();
        goPro.onePageCheckout.checkCorrectSwitchingToPaymentSection();
        goPro.onePageCheckout.fillCardName(CARDNAME_AMEX);
        goPro.onePageCheckout.fillCardNumber(CARDNUMBER_AMEX);
        goPro.onePageCheckout.selectMonth(MONTH);
        goPro.onePageCheckout.selectYear(YEAR);
        goPro.onePageCheckout.fillSecurityCode(AMEX_CVV);
        goPro.onePageCheckout.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.switchToHomePage();
        goPro.homePage.deleteAllCookies();
    }


    @Test
    public void registeredUserInternationalCheckoutWithValidData_PayPal(){
        goPro.homePage.openPage(SITE_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown(INT_COUNTRY);
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.homePage.checkCorrectSwitchingToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.selectLoginCheckbox();
        goPro.checkoutLoginPage.fillEmailFieldForRegisteredUser(EMAILFORREGISTEREDUSER);
        goPro.checkoutLoginPage.fillPasswordFieldForRegisteredUer(PASSWORDFORREGISTEREDUSER);
        goPro.checkoutLoginPage.switchToCheckoutPageAsRegisteredUser();
        goPro.onePageCheckout.fillFirstNameField(FIRSTNAME);
        goPro.onePageCheckout.fillLastNameField(LASTNAME);
        goPro.onePageCheckout.fillAddressLine_1_Field(ADDRESS_INT);
        goPro.onePageCheckout.fillAddressLine_2_Field("");
        goPro.onePageCheckout.fillCityField(CITY_INT);
        goPro.onePageCheckout.selectState(STATE_INT);
        goPro.onePageCheckout.fillZipField(ZIP_INT);
        goPro.onePageCheckout.fillPhoneField(PHONE);
        goPro.onePageCheckout.switchToPaymentSectionOnInternationalSite();
        goPro.onePageCheckout.checkCorrectSwitchingToPaymentSection();
        goPro.onePageCheckout.selectPayPal();
        goPro.onePageCheckout.switchToPayPalLoginPage();
        goPro.payPalLoginPage.fillEmailFieldPayPalForm(PAYPAL_EMAIL);
        goPro.payPalLoginPage.fillPasswordField(PAYPAL_PASSWORD);
        goPro.payPalLoginPage.switchToPayPalAccount();
        goPro.payPalAccountPage.switchToReviewPage();
        goPro.reviewPage.switchToConfirmationPage();
        Assert.assertTrue(goPro.confirmationPage.isThankYouMessageAvailable(), "Thank you message is not displayed");
        goPro.confirmationPage.switchToHomePage();
        goPro.confirmationPage.deleteAllCookies();
    }
}
