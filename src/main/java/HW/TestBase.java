package HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    final  String BASE_URL = "https://www.facebook.com";
    final  String CHROME_DRIVER_LOCATION = "chromedriver.exe";

    public static   WebDriver driver;
    private  String browserName ="chrome";

    @BeforeSuite
    public  WebDriver getDriver() {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get("https://www.facebook.com");
    return driver;
    }
}

