package Unit;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import telchak.selacc.FluentDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Tests {

    private FluentDriver fluentDriver;

    @Before
    public void startClassUnderTest(){
        fluentDriver =  new FluentDriver();
    }

    @Test
    public void testDriverClass(){
        Assert.assertNotNull( fluentDriver );
    }

    @Test
    public void testWithCaps(){
        Assert.assertEquals( fluentDriver, fluentDriver.withCapabilities(new DesiredCapabilities()));
    }

    @Test
    public void testHubUrl() throws MalformedURLException {
        Assert.assertEquals( fluentDriver, fluentDriver.usingHub( new URL("https://google.com.au")));
    }

    //@Test
    public void testChromeDriver(){
        WebDriver d = fluentDriver.start();
        try {
            Assert.assertEquals(d.getClass(), ChromeDriver.class);
        } finally {
            d.quit();
        }
    }

    //@Test
    public void testAndroidDriver() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("deviceName","Samsung");
        caps.setCapability("browserName","chrome");
        WebDriver d =
                fluentDriver
                        .usingHub(new URL("http:\\127.0.0.1:4723/wd/hub"))
                        .withCapabilities(caps)
                        .asType(FluentDriver.DriverType.ANDROID)
                        .start();
        Assert.assertSame(((AndroidDriver)d).getClass(), AndroidDriver.class);
        d.quit();
    }

}
