package tests;

import org.testng.annotations.Test;
import utils.PropertyLoader;

/**
 * Created by user on 8/27/2016.
 */
public class GuestCheckoutTest extends Fixture {

    public static final String production_URL = PropertyLoader.loadProperty("production.url");

    @Test
    public static void guestCheckoutWithValidData(){
        goPro.homePage.openPage(production_URL);
        goPro.homePage.clickSelectDifferentLocationLink();
        goPro.homePage.selectCountryFromCountryConfirmDropDown("United States");
        goPro.homePage.clickShopNowButton();
        goPro.homePage.switchToHeroSessionPage();
        goPro.productDetailsPage.addProductToCart();
        goPro.productDetailsPage.switchToShoppingCart();
        goPro.shoppingCartPage.switchToCheckoutLoginPage();
        goPro.checkoutLoginPage.fillEmailField("user.name");
        goPro.checkoutLoginPage.clickCheckoutButton();


    }
}
