package Base;
import ActionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import static java.lang.System.getProperty;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            System.out.println("super constructor invoked");
            FileInputStream ip = new FileInputStream(
                    getProperty("user.dir") + "\\Configuration\\Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void launchApp() {

            WebDriverManager.chromedriver().setup();
            String browserName = prop.getProperty("browser");

            if (browserName == null) {
                // Handle the case where the browser property is null
                System.out.println("Browser property is not defined in the configuration file.");
                return; // Exit the method
            }

            if (browserName.contains("Chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.contains("FireFox")) {
                driver = new FirefoxDriver();
            } else if (browserName.contains("IE")) {
                driver = new InternetExplorerDriver();
            } else {
                // Handle the case where the browser property is invalid
                System.out.println("Invalid browser specified in the configuration file.");
                return; // Exit the method
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            // Check if implicitWait and pageLoadTimeOut properties are null or not
            String implicitWaitStr = prop.getProperty("implicitWait");
            String pageLoadTimeOutStr = prop.getProperty("pageLoadTimeOut");

            int implicitWait = implicitWaitStr != null ? Integer.parseInt(implicitWaitStr) : 20;
            int pageLoadTimeOut = pageLoadTimeOutStr != null ? Integer.parseInt(pageLoadTimeOutStr) : 40;

            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);

            Action.implicitlyWait(20);
            Action.pageLoadTimeOut(40);

            // Launch URL
            String url = prop.getProperty("url");
            if (url == null) {
                // Handle the case where the URL property is null
                System.out.println("URL property is not defined in the configuration file.");
                return; // Exit the method
            }
            driver.get(url);
        }

    }


