package seleniumbasic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class SeleniumPractice1{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = TestBase.getDriver("chrome","https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("samianrahman@aol.com");
        driver.findElement(By.id("pass")).sendKeys("89Beak928992");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@type='search']"));

        WebElement textbox = driver.findElement(By.xpath("//input[@type='search']"));



        ArrayList<String> data = DBUtils.getDataFromDatabase("select * from people;","firstname");


       for (int i=0; i<data.size(); i++) {
           driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(data.get(i));
           Thread.sleep(5000);
           driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys( Keys.CONTROL + "a");
           Thread.sleep(2000);
           driver.findElement(By.xpath("(//input[@type='search'])[1]")).sendKeys(Keys.DELETE);
           Thread.sleep(2000);


       }

       //get 5 text from ebay and store them in the SQL DATABASE.
        //insert query


    }




    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds*5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();

        } else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }  return driver;
    }

    }

