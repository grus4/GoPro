package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by user on 8/27/2016.
 */
public class JsExecutorWrapper {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private JavascriptExecutor js;
    WebDriver driver;

    public JsExecutorWrapper(WebDriverWrapper driver) {
        this.driver = driver.getOriginalDriver();
        js = (JavascriptExecutor)driver.getOriginalDriver();
    }

    /**
     * This method gets the value of the input field by querySelector
     */
    public String getFieldValue(String element_cssSelector) {
        String cssSelector = UIMappingSingleton.uiStr(element_cssSelector);
        String fieldValue = String.valueOf(js.executeScript("return document.querySelector('" + cssSelector + "').value;"));

        return fieldValue;
    }

    /**
     * This method gets Web page title
     */
    public String getPageTitle() {
        return js.executeScript("return document.title;").toString();
    }

    /**
     * This method Refresh browser window using Javascript
     */
    public void refreshPage() {
        js.executeScript("history.go(0)");
    }

    /**
     * This method Navigate to one page to other page using Javascript
     */
    public void navigateToPage(String pageUrl) {
        js.executeScript("window.location = '" + pageUrl + "'");
        log.info("Switch to page - " + pageUrl);
    }

    /**
     * This method Handle Scroll on Web page
     * Vertical scroll - down by XX pixels
     */
    public void scrollOnWebPage(String pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ")");
        log.info("Scroll the page by " + pixels + " pixels");
    }

    public void clickOnElement(String element) {
        js.executeScript("arguments[0].click();", element);
    }
    /*
    Click a button in Selenium WebDriver using JavaScript

    public void clickOnElement
        Code:
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);

    */


}
