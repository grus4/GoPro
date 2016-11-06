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
        sleep(3000);

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

    public void clickTheNextStepButtonInShipping() {
        web.clickButton("NextStepButtonInShipping");
        sleep(3000);
    }

    public void switchToPaymentSection() {
        //web.waitForElementPresent("NextStepButtonInShipping");
        //web.waitForElementToBeClickable("NextStepButtonInShipping");
        sleep(10000);
        web.clickButton("NextStepButtonInShipping");
        sleep(15000);
        web.waitForElementPresent("CardNameField");
        web.waitForElementToBeClickable("CardNameField");

    }

    public void checkCorrectSwitchingToPaymentSection(){
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
        web.clickElement("OvernightShippingRadioButton");
    }

    public void selectPayPal() {
        web.waitForElementToBeClickable("PayPalRadioButton");
        web.clickElement("PayPalRadioButton");
        web.waitElementNotVisible("SecurityCodeField", 3);
    }


    public void switchToPayPalLoginPage() {
        web.waitForElementPresent("PayPalImage");
        web.clickButton("ReviewAndCompleteButton");
        sleep(20000);
        web.swithcToIframe();
        log.info("Swithicng to iFrame was correct");
        //web.waitForElementPresent("EmailField_PayPalForm");
        //web.waitForElementToBeClickable("EmailField_PayPalForm");

        if(web.isElementPresent("EmailField_PayPalForm")&&
                web.isElementAvailable("EmailField_PayPalForm")){
            log.info("Switching to PayPal Login Page was correct");
        } else {
            log.error("Switching to PayPal Login Page was INCORRECT!\n");
            Assert.fail("Switching to PayPal Login Page was INCORRECT!");
        }
    }

    public void switchToPaymentSectionOnInternationalSite() {
        sleep(10000);
        web.clickButton("NextStepButtonInShipping");
        web.waitForElementToBeClickable("SuggestedAddressIsCorrectButton");
        web.clickButton("SuggestedAddressIsCorrectButton");

        sleep(15000);
        web.waitForElementPresent("CardNameField");
        web.waitForElementToBeClickable("CardNameField");

    }


    public void leaveAllRequiredFieldsEmpty() {
        web.input("FirstNameField", "");
        web.input("LastNameField", "");
        web.input("Address_1_Field", "");
        web.input("Address_2_Field", "");
        web.input("CityField", "");
        web.input("ZipCodeField", "");
        web.input("PhoneNumberField", "");
    }

    public void checkValidationEmptyFirstNameField(){
        if(web.isElementPresent("FirstNameErrorMessage")
                && web.getElementText("FirstNameErrorMessage").equals("Please enter a First name")){
            log.info("First Name Error under the empty field is displayed correctly");
        } else {
            log.error("First Name Error under the empty field is displayed INCORRECTLY" + "\n"
                    + "is FirstNameErrorMessage present - " + web.isElementPresent("FirstNameErrorMessage")
                    + "\n" + "FirstNameErrorMessage - " + web.getElementText("FirstNameErrorMessage"));
            Assert.fail("First Name Error under the empty field is displayed INCORRECTLY" + "\n"
                    + "is FirstNameErrorMessage present - " + web.isElementPresent("FirstNameErrorMessage")
                    + "\n" + "FirstNameErrorMessage - " + web.getElementText("FirstNameErrorMessage"));
        }
    }

    public void checkValidationEmptyLastNameField(){
        if(web.isElementPresent("LastNameErrorMessage")
                && web.getElementText("LastNameErrorMessage").equals("Please enter a Last name")){
            log.info("Last Name Error under the empty field is displayed correctly");
        } else {
            log.error("Last Name Error under the empty field is displayed INCORRECTLY" + "\n"
            + "is LastNameErrorMessage present - " + web.isElementPresent("LastNameErrorMessage")
            + "\n" + "LastNameErrorMessage - " + web.getElementText("LastNameErrorMessage"));
            Assert.fail("Last Name Error under the empty field is displayed INCORRECTLY" + "\n"
                    + "is LastNameErrorMessage present - " + web.isElementPresent("LastNameErrorMessage")
                    + "\n" + "LastNameErrorMessage present - " + web.getElementText("LastNameErrorMessage"));
        }

    }

    public void checkValidationEmptyAddress_1Field(){
        if(web.isElementPresent("Address1ErrorMessage")
                && web.getElementText("Address1ErrorMessage").equals("Please enter Address information")){
            log.info("Address_1 Error Message under the empty field is displayed correctly");
        } else {
            log.error("Address_1 Error Message under the empty field is displayed INCORRECTLY" + "\n"
            + "is Address_1 Error Message present - " + web.isElementPresent("Address1ErrorMessage")
            + "\n" + "Address_1 Error Message - " + web.getElementText("Address1ErrorMessage"));
            Assert.fail("Address_1 Error Message under the empty field is displayed INCORRECTLY" + "\n"
                    + "is Address_1 Error Message present - " + web.isElementPresent("Address1ErrorMessage")
                    + "\n" + "Address_1 Error Message - " + web.getElementText("Address1ErrorMessage"));
        }
    }

    public void checkValidationEmptyCityField(){
        if(web.isElementPresent("CityErrorMessage")
                && web.getElementText("CityErrorMessage").equals("Please enter a City")){
            log.info("City Error Message under the empty field is displayed correctly");
        } else {
            log.error("City Error Message under the empty field is displayed INCORRECTLY" + "\n"
            + "is City Error Message present - " + web.isElementPresent("CityErrorMessage")
            + "\n" + "City Error Message - " + web.getElementText("CityErrorMessage"));
            Assert.fail("City Error Message under the empty field is displayed INCORRECTLY" + "\n"
                    + "is City Error Message present - " + web.isElementPresent("CityErrorMessage")
                    + "\n" + "City Error Message - " + web.getElementText("CityErrorMessage"));
        }
    }

    public void checkValidationEmptyStateDropDown(){
        if(web.isElementPresent("StateDropDownErrorMessage")
                && web.getElementText("StateDropDownErrorMessage").equals("Please select a State")){
            log.info("State Drop-Down Error Message under the empty field is displayed correctly");
        } else {
            log.error("State Drop-Down Error Message under the empty field is displayed INCORRETLY" + "\n"
            + "is State Drop-Down Error Message present - " + web.isElementPresent("StateDropDownErrorMessage")
            + "\n" + "State Drop-Down Error Message - " + web.getElementText("StateDropDownErrorMessage"));
            Assert.fail("State Drop-Down Error Message under the empty field is displayed INCORRETLY" + "\n"
                    + "is State Drop-Down Error Message present - " + web.isElementPresent("StateDropDownErrorMessage")
                    + "\n" + "State Drop-Down Error Message - " + web.getElementText("StateDropDownErrorMessage"));
        }
    }

    public void checkValidationEmptyPostCodeField(){
        if(web.isElementPresent("PostCodeErrorMessage")
                && web.getElementText("PostCodeErrorMessage").equals("Please enter a Postal Code")){
            log.info("Post Code Error Message under the empty field is displayed correctly");
        } else {
            log.error("Post Code Error Message under the empty field is displayed INCORRECTLY" + "\n"
            + "is Post Code Error Message present - " + web.isElementPresent("PostCodeErrorMessage")
            + "\n" + "Post Code Error Message - " + web.getElementText("PostCodeErrorMessage"));
            Assert.fail("Post Code Error Message under the empty field is displayed INCORRECTLY" + "\n"
                    + "is Post Code Error Message present - " + web.isElementPresent("PostCodeErrorMessage")
                    + "\n" + "Post Code Error Message - " + web.getElementText("PostCodeErrorMessage"));
        }
    }

    public void checkValidationEmptyPhoneField(){
        if(web.isElementPresent("PhoneFieldErrorMessage")
                && web.getElementText("PhoneFieldErrorMessage").equals("Please enter a Telephone Number")){
            log.info("Phone Field Error Message under the empty field is displayed correctly");
        } else {
            log.error("Phone Field Error Message under the empty field is displayed INCORRETLY" + "\n"
            + "is Phone Field Error Message present - " + web.isElementPresent("PhoneFieldErrorMessage")
            + "\n" + "Phone Field Error Message - " + web.getElementText("PhoneFieldErrorMessage"));
            Assert.fail("Phone Field Error Message under the empty field is displayed INCORRETLY" + "\n"
                    + "is Phone Field Error Message present - " + web.isElementPresent("PhoneFieldErrorMessage")
                    + "\n" + "Phone Field Error Message - " + web.getElementText("PhoneFieldErrorMessage"));
        }
    }

    public void cheeckValidationForAllEmptyReuiredFields(){
        checkValidationEmptyFirstNameField();
        checkValidationEmptyLastNameField();
        checkValidationEmptyAddress_1Field();
        checkValidationEmptyCityField();
        checkValidationEmptyStateDropDown();
        checkValidationEmptyPostCodeField();
        checkValidationEmptyPhoneField();
    }
}
