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

    static final String SITE_URL = PropertyLoader.loadProperty("site.url");
    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("wait.timeout");



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
