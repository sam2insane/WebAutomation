package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
public  static  WebDriver driver = null;

    public static WebDriver getDriver(String browserName, String url) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(url);
        return driver;
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static WebElement getElementFromXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }
    public static void sendKeyss ( String id, String value) {
        driver.findElement(By.xpath(id)).sendKeys(value);
    }
    public static void searchInEbay (String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

}

