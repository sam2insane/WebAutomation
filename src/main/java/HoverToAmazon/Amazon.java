package HoverToAmazon;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Amazon {
    public static void main(String[] args)throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        try {
            Thread.sleep(5000);

        }catch(Exception e) {

        }
      Actions action = new Actions(driver);
        WebElement main  = driver.findElement(By.xpath("//span[@class='nav-line-2']"));
        action.moveToElement(main).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'nav-action-inner']")));

        WebElement clickSignin = driver.findElement(By.xpath("//span[@class= 'nav-action-inner']"));
        action.moveToElement(clickSignin);
        action.click().build().perform();

        System.out.println(driver.getCurrentUrl());




        }
    }

