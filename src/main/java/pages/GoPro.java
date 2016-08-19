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

    public GoPro(WebDriverWrapper driverWrapper) {
        web = new WebElementsActions(driverWrapper);
        homePage = new HomePage(driverWrapper);
        productDetailsPage = new ProductDetailsPage(driverWrapper);
    }
}
