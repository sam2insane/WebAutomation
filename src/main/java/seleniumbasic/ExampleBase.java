package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExampleBase {

    // create a method which will return the webdriver instance
    // method should be able to take parameters of browser name and operating system


    public static WebDriver getDriver(String browserName, String os, String url) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            if(os.equalsIgnoreCase("mac")){
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver");
            }else System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if(os.equalsIgnoreCase("mac")){
                System.setProperty("webdriver.firefox.driver", "src\\main\\resources\\geckodriver");
            }else System.setProperty("webdriver.firefox.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(url);
        return driver;

    }

    public static void main(String[] args) {
        WebDriver driver = getDriver("chrome","win","https:///www.ebay.com");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("JaVA ");

        //Element <E> with attribute A containing text 't'
            //input[contains(@id,'gh')

    }
}




