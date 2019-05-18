package telchak.selacc;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FluentDriver {

    public enum DriverType {ANDROID, IOS, BROWSER}

    /**
     * Basic values required to make the launcher work locally
     * Defaults assume local chrome browser
     */
    private DesiredCapabilities dc = DesiredCapabilities.chrome();
    private URL seleniumHub = null;
    private DriverType type = DriverType.BROWSER;


    /**
     * pass in a set of capabilities
     * @param caps capabilities
     * @return chaining object
     */
    public FluentDriver withCapabilities(DesiredCapabilities caps) {
        dc = caps;
        return this;
    }

    /**
     * pass in the hub URL, works with any hub and BrowserStack or SauceLabs
     * @param url hub URL for distributed testing
     * @return chaining object
     */
    public FluentDriver usingHub(URL url) {
        seleniumHub = url;
        return this;
    }

    /**
     *
     * @param driverType selects the type of driver to launch
     * @return chaining object
     */
    public FluentDriver asType( DriverType driverType){
        type = driverType;
        return this;
    }

    /**
     * Starts the right driver type, with a connection
     * @return WebDriver base class
     */
    public WebDriver start(){

        if( seleniumHub != null) {

            switch (type) {
                case ANDROID:
                    return new AndroidDriver(seleniumHub, dc);

                case IOS:
                    return new IOSDriver(seleniumHub, dc);

                case BROWSER:
                    return new RemoteWebDriver(seleniumHub,dc);
            }
        }

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
