package pages;

import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.10.2016.
 */
public class CreateNewAccountPage extends Page {

    public CreateNewAccountPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillEmailField(String email) {
        web.clickElement("EmailFieldCreateAccountForm");
        String newEmail = web.generateRandomEmail(email);
        web.input("EmailFieldCreateAccountForm", newEmail);
    }

    public void fillFirstNameField(String firstName) {
        web.input("FirstNameCreateAccountForm", firstName);
    }

    public void fillLastNameField(String lastName) {
        web.input("LastNameCreateAccountForm", lastName);
    }

    public void fillPasswordField(String password) {
        web.input("PasswordCreateAccountForm", password);
    }

    public void fillConfirmPasswordField(String confirmPassword) {
        web.input("ConfirmPasswordAccountForm", confirmPassword);
    }


    public void checkPrivacyPolicyCheckbox() {
        web.clickElement("PrivacyPolicyCheckbox");
        log.info("Privacy Policy checkbox was checked");
    }

    public void clickSignInButton() {
        web.clickButton("CreateAccountButton");
        web.waitForElementPresent("PlaceHoldersNameField");
        web.waitForElementToBeClickable("PlaceHoldersNameField");
    }
}

