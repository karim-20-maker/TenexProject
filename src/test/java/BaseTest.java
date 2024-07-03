import Utiles.helpers;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static Utiles.PropertiesLoader.readPropertyFile;

public class BaseTest extends CommonPO{
    AndroidDriver driver;
    helpers help;
    Properties capsProp = readPropertyFile("Config/AndroidCaps.properties");

    public void login(String email, String pass){
        help = new helpers(driver);
        help.waitForVisibility(loginEmailField);
        help.enterData(loginEmailField,email);
        help.enterData(passwordField,pass);
        help.click(loginCTA);
    }

    @BeforeTest
    public void setupCaps() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName",capsProp.getProperty("platformName"));
        caps.setCapability("automationName",capsProp.getProperty("automationName"));
        caps.setCapability("platformVersion",capsProp.getProperty("platformVersion"));
        caps.setCapability("deviceName",capsProp.getProperty("deviceName"));
        caps.setCapability("AppPackage",capsProp.getProperty("appPackage"));
        caps.setCapability("appium:autoGrantPermissions","true");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url,caps);
        driver.activateApp(capsProp.getProperty("appPackage"));

    }

    @AfterSuite
    public void closeApp(){
        if(driver != null)
            driver.quit();
    }

}
