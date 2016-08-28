package utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class WebElementsActions {

    private WebDriverWrapper webDriverWrapper;
    private static WebDriverWait waitForElement;
    private Random random;

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String EXPLICIT_WAIT = PropertyLoader.loadProperty("selenium.explicit.timeout");


    public WebElementsActions(WebDriverWrapper driver) {
        this.webDriverWrapper = driver;
        waitForElement = new WebDriverWait(driver, Long.parseLong(EXPLICIT_WAIT));
        random = new Random();
    }



    public void clickElement(String elementLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator)).click();
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(buttonLocator)).click();
        log.info("Click on Button " + buttonLocator);
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(linkLocator)).click();
        log.info("Click on Link " + linkLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData)  {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }


    public void clearField(String inputLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        log.info("Plaseholder was cleaned");
    }

    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Input in " + inputLocator + ", value -" + inputData + "and click <Enter> button");
    }


    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) {
        List<WebElement> list = webDriverWrapper.findElements(UIMappingSingleton.ui(elementLocator));

        if (list.size() == 0) {
            log.warn("Element _" + elementLocator + "_is NOT Present in DOM!");
            return false;
        }

        if (list.get(0).isDisplayed()) {
            log.info("Element _" + elementLocator + "_ is Present");
            return true;
        }
        else {
            log.error("Element _" + elementLocator + "_ is NOT Displayed Present!");
            return false;
        }
    }

    public boolean isAllElementsPresent(String elementLocator) {
        List<WebElement> list = new ArrayList<>();
        list.addAll(webDriverWrapper.findElements(UIMappingSingleton.ui(elementLocator)));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDisplayed()) {
                list.get(i).equals("");
                //log.info("Element _" + list.get(i) + "_ is present!");
            } else {
                log.warn("Element _" + list.get(i) + "_; element (" + i + ") _is NOT Present!");
                return false;
            }
        }

        log.info("Total quantity of " + elementLocator + " - " + list.size());
        return true;
    }

    /**
     * Method is used to check that element is present in the DOM.
     */
    public boolean isElementAvailable(String elementLocator) {
        if(!webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator)).isEnabled()) {
            log.info("Element is not found");
            return false;
        }
        log.info("Element is available in the DOM");
        return  true;
    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent() {
        boolean alertPresence = false;
        try {
            Alert alert = webDriverWrapper.switchTo().alert();
            alertPresence = true;
            alert.accept();
            log.info("Alert is present");
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            log.info("Alert is not found");
            return alertPresence;
        }
        return alertPresence;
    }


    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = webDriverWrapper.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            log.error("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    public void moveToElementAndClick(String moveToLocator, String clickToElement) {

        WebElement webElement = webDriverWrapper.findElement(UIMappingSingleton.ui(moveToLocator));

        Actions actions = new Actions(webDriverWrapper);
        actions.moveToElement(webElement);
        actions.perform();  //!!! always need
        clickButton(clickToElement);
        log.info("moved To Element " + moveToLocator + "and clicked on" + clickToElement);
    }

    /**
     *Method#1 for refresh page
     */
    public void refreshPage() {
        webDriverWrapper.navigate().refresh();
        log.info("Page is refreshed");
    }

    /**
     *Method#2 for refresh page
     */
    public void refreshPage2() {
        Actions actions = new Actions(webDriverWrapper.getOriginalDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
    }


    /**
     *Methods for pressing the keypad buttons
     */
    public void pressSpaceKey(String inputLocator) {

        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.SPACE);
        log.info("input <space> into " + inputLocator + "by pressing the space button on the keypad");
    }

    public void pressEnterKey(String inputLocator) {

        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("input <ENTER> into " + inputLocator + "by pressing the space button on the keypad");
    }

    public void pressESCAPEKey(String inputLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ESCAPE);
    }

    public void pressPageUp(String inputLocator) {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
    }

    public void pressTAB(String locator) {

        WebElement webElement = webDriverWrapper.findElement(UIMappingSingleton.ui((locator)));
        webElement.sendKeys(Keys.TAB);
        log.info(String.format("press TAB"));

    }

    /**
     * This method is used to select menu item
     * Use Actions class
     */
    public void selectMenuItem(String menuLocator, String submenuLocator) {
        new Actions(webDriverWrapper.getOriginalDriver()).moveToElement(getElement(menuLocator)).perform();
        log.info("Focus on Menu to open list of submenus");

        clickButton(submenuLocator);
        log.info("Click on Submenu" + submenuLocator);
    }

    /**
     * This method is used to do Focus to Element And Click
     * Use Actions class
     */
    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) {
        new Actions(webDriverWrapper.getOriginalDriver()).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);

        webDriverWrapper.switchTo();

        if (isElementPresent(elementLocator)) {
            clickButton(elementLocator);
        }
    }

    /**
     * This method is used to click on something and open window in New Tab
     * Use Actions class
     */
    public void clickOnSomethingAndOpenNewTab(String elementLocator) {
        Set<String> oldWindowsSet = webDriverWrapper.getWindowHandles();
        clickButton(elementLocator);
        Set<String> newWindowsSet = webDriverWrapper.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);

        String newWindowHandle = newWindowsSet.iterator().next();
        webDriverWrapper.switchTo().window(newWindowHandle);
    }

    public void scrollPageToElement(String elementLocator) {
        Actions actions = new Actions(webDriverWrapper.getOriginalDriver());
        actions.moveToElement(getElement(elementLocator));
        actions.perform();
    }


    /**
     * This method is used to wait for getting response from all Ajax requests
     */
    public boolean waitForAjaxResponse(int timeoutSeconds) {
        //TODO js executor
        if (webDriverWrapper instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) webDriverWrapper;

            for (int i = 0; i < timeoutSeconds; i++) {
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
                if (numberOfConnections instanceof Long) {
                    log.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

                    if (numberOfConnections == 0)
                        break;
                }
                // stay(1);
            }
            return false;
        } else {
            log.info("WebElementsActions Driver: <" + webDriverWrapper + "> cann't execute JavaScript");
            return false;
        }
    }

    /**
     * Wait the text in the element value specified time
     */
    public void waitTextPresent(WebElement elementLocator, String text) {
        log.info("*Start TO* Wait For Element " + elementLocator + " Present");
        waitForElement.until(ExpectedConditions.textToBePresentInElement(elementLocator, text));
    }

    /**
     * This method is used to do Focus to Element And Click
     * Use Actions class
     */
/*    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) {
        new Actions(webDriverWrapper.getOriginalDriver()).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);
        webDriverWrapper.switchTo();
        if (isElementPresent(elementLocator)) {
            clickButton(elementLocator);
        }
    }*/


    public WebElement getElement(String elementLocator) {
        return webDriverWrapper.findElement(UIMappingSingleton.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) {
        return webDriverWrapper.findElements(UIMappingSingleton.ui(elementsLocator));
    }


    public String getElementText(String elementsLocator) {
        return webDriverWrapper.findElement(UIMappingSingleton.ui(elementsLocator)).getText();
    }

    /**
     * Insert value into text input HTML field without Clean
     */
    public void inputWithoutClean(String inputLocator, String inputData)  {
        webDriverWrapper.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }


    /**
     * Select value from drop down list
     */
    public void selectFromList(String listLocator, String listValue) {
        new Select(webDriverWrapper.findElement(UIMappingSingleton.ui(listLocator))).selectByValue(listValue);
    }

    /**
     * Select value from drop down list by visible text
     */
    public void selectFromListByVisibleText(String listLocator, String listValue) {
        new Select(webDriverWrapper.findElement(UIMappingSingleton.ui(listLocator))).selectByVisibleText(listValue);
    }

    /**
     * Wait the element on page specified time
     */
    public void waitElementNotVisible(String elementLocator, int timeoutInS) {
        WebDriverWait wait = new WebDriverWait(webDriverWrapper, timeoutInS);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public void waitForElementPresent(String elementLocator) {
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
        log.info("WaitForElement _" + elementLocator + "_ Present");
    }


    /**
     * An expectation for checking that an element is present on the DOM of a page and clickable.
     */
    public void waitForElementToBeClickable(String elementLocator) {
        waitForElement.until(ExpectedConditions.elementToBeClickable(UIMappingSingleton.ui(elementLocator)));
        log.info("WaitForElement _" + elementLocator + "_to be clickable");
    }

   /* *//**
     * Scroll a window
     *
     * @see {@link JavascriptExecutor} and {@link JavascriptExecutor#executeScript(String, Object...)}
     *//*
    public void windowScroll() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriverWrapper;
        // Vertical scroll - down by 100  pixels
        javascriptExecutor.executeScript("window.scrollBy(0,100)", "");
    }*/

    /**
     * Select/deselect the checkbox, the second parameter should be "Y" or "N"
     */
    public void selectCheckbox(String checkboxLocator, String isSet) {
        if (webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("N")) {
            webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
        if (!webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("Y")) {
            webDriverWrapper.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
    }

    /**
     *Methods for generation random number
     */
    public int getRandom() {
        return (int) (Math.random() * 100000000);
    }


    /**
     *Method for generation random email
     */
    public String generateRandomEmail(String inputEmail) {
        String newEmail = "Test_" + getRandom() + inputEmail;

        return newEmail;
    }



}
