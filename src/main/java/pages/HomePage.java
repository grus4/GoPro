package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;

/**
 * Created by Rus on 19.08.2016.
 */
public class HomePage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HomePage(WebDriverWrapper dr) {
        super(dr);
    }

    public void switchToHeroSessionPDP() {
        web.scrollPageToElement("");
        web.clickElement("");

        web.waitForElementPresent("");
        if(web.isElementPresent("")&&
                web.isElementAvailable("")) {
            log.info("");
        } else {
            log.error("");

        }
    }
}
