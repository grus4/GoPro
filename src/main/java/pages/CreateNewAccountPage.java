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
        web.input("EmailFieldCreateAccountForm", email);
    }
}
