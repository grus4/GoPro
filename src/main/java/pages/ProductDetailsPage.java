package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 19.08.2016.
 */
public class ProductDetailsPage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ProductDetailsPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void addProductToCart(){
        web.waitForElementPresent("AddToCartButton");
        web.waitForElementToBeClickable("AddToCartButton");
        web.clickButton("AddToCartButton");
        sleep(10000);
        //web.waitForElementPresent("CheckoutButtonInMiniCart");

        if(web.isElementPresent("CheckoutButtonInMiniCart")
                && web.isElementPresent("ProductQuantityInMiniCart")){
            log.info("The product has been successfully added to the cart");
            log.info("Checkout button - " + web.isElementPresent("CheckoutButtonInMiniCart"));
            log.info("Product quantity in Mini Cart - " + web.isElementPresent("ProductQuantityInMiniCart"));
        } else {
            log.error("The product has been INCORRECTLY ADDED TO THE CART!\n");
            log.error("Checkout button - " + web.isElementPresent("CheckoutButtonInMiniCart"));
            log.error("Product quantity in Mini Cart - " + web.isElementPresent("ProductQuantityInMiniCart"));
            Assert.fail("The product has been INCORRECTLY ADDED TO THE CART!");
        }
    }

    public void switchToShoppingCart(){
        if(web.isElementPresent("CheckoutButtonInMiniCart")
                && web.isElementPresent("ProductQuantityInMiniCart")){
            web.clickButton("CheckoutButtonInMiniCart");
        } else {
            web.clickElement("CartIcon");
            web.waitForElementToBeClickable("CheckoutButtonInMiniCart");
            web.clickButton("CheckoutButtonInMiniCart");

        }

        web.waitForElementPresent("CheckoutButtonInShoppingCart");
        web.waitForElementToBeClickable("CheckoutButtonInShoppingCart");

        if(web.isElementAvailable("CheckoutButtonInShoppingCart")
                && web.isElementPresent("CheckoutButtonInShoppingCart")){
            log.info("Switching to Shopping cart was correct");
        } else {
            log.error("Switching to Shopping cart was INCORRECT!\n");
            Assert.fail("Switching to Shopping cart was INCORRECT!");
        }
    }
}
