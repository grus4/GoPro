package pages;

import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by user on 8/14/2016.
 */
public class GoPro {
    public WebElementsActions web;
    public HomePage homePage;
    public ProductDetailsPage productDetailsPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckoutLoginPage checkoutLoginPage;
    public OnePageCheckout onePageCheckout;

    public GoPro(WebDriverWrapper driverWrapper) {
        web = new WebElementsActions(driverWrapper);
        homePage = new HomePage(driverWrapper);
        productDetailsPage = new ProductDetailsPage(driverWrapper);
        shoppingCartPage = new ShoppingCartPage(driverWrapper);
        checkoutLoginPage = new CheckoutLoginPage(driverWrapper);
        onePageCheckout = new OnePageCheckout(driverWrapper);
    }
}
