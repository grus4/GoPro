package pages;

import utils.WebDriverWrapper;

/**
 * Created by Rus on 22.10.2016.
 */
public class GoProPlusCheckoutPage extends Page{

    public GoProPlusCheckoutPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillCardHoldersNameField(String cardHoldersName) {
        web.input("PlaceHoldersNameField", cardHoldersName);
    }

    public void fillCardNumberField(String cardNumberField) {
        web.input("CreditCardNumberField", cardNumberField);
    }

    public void selectExpMonth(String expMonth) {
        web.selectFromListByVisibleText("ExpMonthDropDownField", expMonth);
    }

    public void selectExpYear(String expYear) {
        web.selectFromListByVisibleText("ExpYearDropDownField", expYear);
    }


    public void fillCVVField(String cvv) {
        web.input("CVVField", cvv);
    }

    public void fillZipField(String zip) {
        web.input("ZipField", zip);
    }

    public void switchToGoProPlusConfirmationPage() {
        web.clickButton("SignUpButton");
        //web.waitForElementPresent("");

    }
}
