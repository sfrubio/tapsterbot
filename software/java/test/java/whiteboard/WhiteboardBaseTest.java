package whiteboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Devices;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.Devices.SONY_XPERIA_M2;

public abstract class WhiteboardBaseTest {

    protected static AppiumDriver driver;
    protected static Devices device = SONY_XPERIA_M2;

    public static AndroidDriver getAndroidDriver(Devices device) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", device.getDeviceName());
        capabilities.setCapability("platformName", device.getPlatformName());
        capabilities.setCapability("platformVersion", device.getPlatformVersion());
        capabilities.setCapability("udid", device.getUdid());
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.vistrav.whiteboard");
        capabilities.setCapability("appActivity", "com.vistrav.whiteboard.IndexActivity");

        return new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
}
