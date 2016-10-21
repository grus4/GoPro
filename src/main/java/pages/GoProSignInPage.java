package pages;

import utils.WebDriverWrapper;

/**
 * Created by Rus on 18.10.2016.
 */
public class GoProSignInPage extends Page {

    public GoProSignInPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void switchToCreateNewAccountPage() {
        web.clickLink("SignUpForFreeLink");
    }
}
