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

    }


    public void fillLastNameField(String lastName) {
        web.input("LastNameField", lastName);


    }

    public void fillAddressLine_1_Field(String address) {
        web.input("Address_1_Field", address);

    }

    public void fillAddressLine_2_Field(String address) {
        web.input("Address_2_Field", address);

    }

    public void fillCityField(String city) {
        web.input("CityField", city);

    }

    public void selectState(String state) {
        web.selectFromListByVisibleText("StateDropDown", state);

    }


    public void fillZipField(String zip) {
        web.input("ZipCodeField", zip);

    }

    public void fillPhoneField(String phone) {
        web.input("PhoneNumberField", phone);
    }

    public void clickTheNextStepButton() {
        web.clickButton("NextStepButtonInShipping");
    }

    public void switchToPaymentSection() {
        //web.waitForElementPresent("NextStepButtonInShipping");
        //web.waitForElementToBeClickable("NextStepButtonInShipping");
        sleep(5000);
        web.clickButton("NextStepButtonInShipping");
        sleep(10000);
        web.waitForElementPresent("CardNameField");
        web.waitForElementToBeClickable("CardNameField");

        if(web.isElementPresent("ReviewAndCompleteButton")){
            log.info("Switching to Payment section was correct");
        } else {
            log.error("Switching to Payment section was INCORRECT!\n");
            Assert.fail("Switching to Payment section was INCORRECT!");
        }

    }


    public void fillCardName(String cardName) {
        web.waitForElementPresent("CardNameField");
        web.waitForElementToBeClickable("CardNameField");
        web.input("CardNameField", cardName);


    }

    public void fillCardNumber(String cardNumber) {
        web.input("CardNumberField", cardNumber);

    }

    public void selectMonth(String month) {
        web.selectFromListByVisibleText("MonthDropDown", month);

    }

    public void selectYear(String year) {
        web.selectFromListByVisibleText("YearDropDown", year);

    }

    public void fillSecurityCode(String visaCvv) {
        web.input("SecurityCodeField", visaCvv);
    }

    public void switchToReviewPage() {
        web.waitForElementPresent("ReviewAndCompleteButton");
        web.waitForElementToBeClickable("ReviewAndCompleteButton");
        web.clickButton("ReviewAndCompleteButton");
        web.waitForElementPresent("CompletePurchaseButton");
        web.waitForElementToBeClickable("CompletePurchaseButton");

        if(web.isElementPresent("CompletePurchaseButton")
                && web.isElementAvailable("CompletePurchaseButton")){
            log.info("Switching to Review page was correct");
        } else {
            log.error("Switching to Review page was INCORRECT!\n");
            Assert.fail("Switching to Review page was INCORRECT!");
        }
    }

    public void selectOvernightShipping(){
        sleep(5000);
        //web.waitForElementToBeClickable("OvernightShippingRadioButton");
        web.clickElement("OvernightShippingRadioButton");
    }
}
