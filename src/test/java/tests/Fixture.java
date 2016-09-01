package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import pages.GoPro;
import utils.*;


import java.util.concurrent.TimeUnit;


public class Fixture {
    static WebDriverWrapper webDriverWrapper;
    static GoPro goPro;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("wait.timeout");
    protected static final String EMAIL = PropertyLoader.loadProperty("user.email");
    protected static final String COUNTRY = PropertyLoader.loadProperty("country");
    protected static final String SITE_URL = PropertyLoader.loadProperty("site.url");
    protected static final String FIRSTNAME = PropertyLoader.loadProperty("first.name");
    protected static final String LASTNAME = PropertyLoader.loadProperty("last.name");
    protected static final String ADDRESS_1 = PropertyLoader.loadProperty("address_1");
    protected static final String CITY = PropertyLoader.loadProperty("city");
    protected static final String STATE = PropertyLoader.loadProperty("state");
    protected static final String ZIP = PropertyLoader.loadProperty("zip");
    protected static final String PHONE = PropertyLoader.loadProperty("phone");
    protected static final String CARDNAME_VISA = PropertyLoader.loadProperty("card.name1");
    protected static final String CARDNUMBER_VISA = PropertyLoader.loadProperty("card.number1");
    protected static final String CARDNAME_MASTERCARD = PropertyLoader.loadProperty("card.name2");
    protected static final String CARDNUMBER_MASTERCARD = PropertyLoader.loadProperty("card.number2");
    protected static final String MONTH = PropertyLoader.loadProperty("month");
    protected static final String YEAR = PropertyLoader.loadProperty("year");
    protected static final String VISA_CVV = PropertyLoader.loadProperty("cvv1");
    protected static final String MASTERCARD_CVV = PropertyLoader.loadProperty("cvv2");



    @BeforeSuite
    public static void setUp() {
        UIMappingSingleton.getInstance();

        //driver = new WebDriverWrapper(new ChromeDriver());
        //webDriverWrapper = WebDriverFactory.initDriver();
        webDriverWrapper = WebDriverFactory.getInstance();
        goPro = new GoPro(webDriverWrapper);
        webDriverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        webDriverWrapper.manage().window().maximize();
        log.info("Start Test Suite execution");
    }

    //@AfterSuite
    public static void tearDown() {
        webDriverWrapper.quit();
        log.info("Tests Suite execution completed.");
    }


}
