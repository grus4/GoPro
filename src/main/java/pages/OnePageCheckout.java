package pages;


import org.testng.Assert;
import utils.WebDriverWrapper;

public class OnePageCheckout extends Page{
    public OnePageCheckout(WebDriverWrapper dr, String page) {
        super(dr, page);
    }

    public OnePageCheckout(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillFirstNameField(String firstName) {
        web.input("FirstNameField", firstName);
        //log.info("The First name field was filled out - " + firstName);
    }


    public void fillLastNameField(String lastName) {
        web.input("LastNameField", lastName);
        //log.info("The Last name field was filled out - " + lastName);

    }

    public void fillAddressLine_1_Field(String address) {
        web.input("Address_1_Field", address);
        //log.info("Address_1 field was filled out - " + address);

    }

    public void fillAddressLine_2_Field(String address) {
        web.input("Address_2_Field", address);
        //log.info("Address_2 field was filled out - " + address);
    }

    public void fillCityField(String city) {
        web.input("CityField", city);
        //log.info("City filed was filled out - " + city);

    }

    public void selectState(String state) {
        web.selectFromListByVisibleText("StateDropDown", state);
        //log.info(state + " was selected from State drop down menu");

    }


    public void fillZipField(String zip) {
        web.input("ZipCodeField", zip);
        //log.info("Zip field was filled out - " + zip);

    }

    public void fillPhoneField(String phone) {
        web.input("PhoneNumberField", phone);
        //log.info("Phone Number field was filled out - " + phone);
    }

    public void clickTheNextStepButton() {
        web.clickButton("NextStepButtonInShipping");
    }

    public void switchToPaymentSection() {
        //web.waitForElementPresent("NextStepButtonInShipping");
        //web.waitForElementToBeClickable("NextStepButtonInShipping");
        sleep(5000);
        web.clickButton("NextStepButtonInShipping");
        //web.waitElementNotVisible("NextStepButtonInShipping", 3);

        //web.waitForAjaxResponse(5);
        sleep(5000);
        if(web.isElementPresent("ReviewAndCompleteButton")){
            log.info("Switching to Payment section was correct");
        } else {
            log.error("Switching to Payment section was INCORRECT!\n");
            Assert.fail("Switching to Payment section was INCORRECT!");
        }

    }


    public void fillCardName(String cardName) {
        web.input("CardNameField", cardName);
        //log.info("Card Name field was filled out - " + cardName);

    }

    public void fillCardNumber(String cardNumber) {
        web.input("CardNumberField", cardNumber);
        //log.info("Card Number field was filled out - " + cardNumber);
    }

    public void selectMonth(String month) {
        web.selectFromListByVisibleText("MonthDropDown", month);
        //log.info(month + " was selected from drop down menu");
    }

    public void selectYear(String year) {
        web.selectFromListByVisibleText("YearDropDown", year);
        //log.info(year + " was selected from drop down menu");
    }

    public void fillSecurityCode(String visaCvv) {
        web.input("SecurityCodeField", visaCvv);
    }

    public void switchToReviewPage() {
        web.clickButton("ReviewAndCompleteButton");
        web.waitForElementPresent("");
    }
}
