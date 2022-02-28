package com.xueqiu.web;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


/**
 * 描述:
 *
 * @author 张雅静
 * @create 2019-11-17 4:52 PM
 */
public class Xueqiu {
    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:udid", "f2469ce1");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:adbPort", 5037);
        desiredCapabilities.setCapability("appium:appPackage", "com.yit.art");
        desiredCapabilities.setCapability("appium:appActivity", "com.yitlib.module.shell.welcome.WelcomeActivity");//
        desiredCapabilities.setCapability("appium:skipDeviceInitialization", true);
        desiredCapabilities.setCapability("appium:skipServerInstallation", true);
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:noReset", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() throws InterruptedException {
        Thread.sleep(5000);
        new TouchAction(driver).press(PointOption.point(505, 1740)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(539, 399)).release().perform();
        driver.getSupportedPerformanceDataTypes().stream().forEach(p -> {
            System.out.println(p);
            //System.out.println(driver.getPerformanceData("com.yit.art", p, 5));
        });

        System.out.println(driver.getPerformanceData("com.yit.art", "cpuinfo", 5));
        System.out.println(driver.getPerformanceData("com.yit.art", "memoryinfo", 5));
        System.out.println(driver.getPerformanceData("com.yit.art", "batteryinfo", 5));
        System.out.println(driver.getPerformanceData("com.yit.art", "networkinfo", 5));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }
}
