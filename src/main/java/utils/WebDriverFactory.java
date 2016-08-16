package utils;


import net.anthavio.phanbedder.Phanbedder;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class WebDriverFactory {

    public static WebDriverWrapper driverWrapper;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String INTERNET_EXPLORER = "ie";
    private static final String CHROME = "chrome";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String LINUX = "linux";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");
    public static final String hub = PropertyLoader.loadProperty("grid2.hub");

    public WebDriverFactory() {
    }
    /**
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     * SetUp grid : browserName, browserVersion, platform.
     * @setBrowserAndVersion
     * @setPlatform
     *
     * @return WebDriver
     */
    public static WebDriverWrapper getInstance() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setJavascriptEnabled(true);

        log.info(" <--- Start work WebDriver Factory --->");
        setBrowserAndVersion(capability);
        log.info(" <--- Successful set up Browser And Version == " + capability + " --->");
        setPlatform(capability);
        log.info(" <--- Successful set up Platform == " + capability + " --->");

        driverWrapper = new WebDriverWrapper(new RemoteWebDriver(getHubURL(), capability));

        driverWrapper.manage().deleteAllCookies();
        //driverWrapper.manage().window().setSize(new Dimension(1280, 720));
        driverWrapper.manage().window().maximize();

        log.info("Screen resolution - " + driverWrapper.manage().window().getSize());

        return driverWrapper;
    }


    /**
     * Method makes the check and returns hub url
     */
    public static URL getHubURL() {
        URL hubUrl = null;

        try {
            hubUrl = new URL(hub);
            log.info("<--- HUBURL ==> " + hub + " --->");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // In case there is no Hub
        if (hubUrl == null) {
            log.error("HUBURL == null!\n");
            Assert.fail("vse propalo!");
            return null;
        } else {
            return hubUrl;
        }
    }


    /**
     * Factory method to return a WebDriver instance given the browser to hit
     * @param capability : : DesiredCapabilities object coming from getInstance()
     *
     * @void : setUp capability
     */
    public static void setBrowserAndVersion(DesiredCapabilities capability) {

        if (CHROME.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.chrome();
            //System.setProperty("webdriver.chrome.driver", "c:\\Tool\\chromedriver.exe");

            capability.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
            capability.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);

        } else if (FIREFOX.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.firefox();
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        } else if (INTERNET_EXPLORER.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.internetExplorer();
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capability.setCapability("browserstack.ie.enablePopups", false);
            /**
             * Most likely PHANTOMJS does not work!
             * Need debug!
             */
        } else if (PHANTOMJS.equals(browserName)) {
            capability.setBrowserName(browserName);
            File phantomjs = Phanbedder.unpack();
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());

        } else if (HTML_UNIT.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.htmlUnit();
        }

        if (browserVersion != null) {
            capability.setVersion(browserVersion);
            capability.setCapability("browser_version", browserVersion);
        }

    }


    /**
     * Helper method to set version and platform for a specific browser
     * @param capability : DesiredCapabilities object coming from getInstance()
     *
     * @void setUp DesiredCapabilities
     */
    private static void setPlatform(DesiredCapabilities capability) {

        if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else {
            capability.setPlatform(Platform.ANY);
        }
    }


    //old version
    public static WebDriverWrapper initDriver(){
        if(FIREFOX.equals(browserName)){
            driverWrapper = new WebDriverWrapper( new FirefoxDriver());
        } else if(PHANTOMJS.equals(browserName)){
            File phantomjs = Phanbedder.unpack();
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
            driverWrapper = new WebDriverWrapper( new PhantomJSDriver(caps));

        } else if(CHROME.equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driverWrapper = new WebDriverWrapper( new ChromeDriver(options));

        }  else if(INTERNET_EXPLORER.equals(browserName)){
            System.setProperty("webdriver.ie.driver", "C:\\Tool\\IEDriverServer.exe");

            DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
            capabilitiesIE.setCapability(
                    InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driverWrapper = new WebDriverWrapper( new InternetExplorerDriver(capabilitiesIE));
        } else {
            Assert.fail("Invalid driver name");
        }

        driverWrapper.manage().deleteAllCookies();
        driverWrapper.manage().window().maximize();

        return driverWrapper;
    }
}

